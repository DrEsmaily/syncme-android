/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.roomdetails.impl

import com.google.common.truth.Truth.assertThat
import io.element.android.features.roomdetails.impl.members.aRoomMember
import io.element.android.libraries.matrix.api.core.UserId
import io.element.android.libraries.matrix.api.room.RoomMembersState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CloseGroupMembersTest {
    private val own = aRoomMember(UserId("@owner:example.org"), powerLevel = 100)
    private val other = aRoomMember(UserId("@other:example.org"), powerLevel = 0)

    @Test
    fun `unknown members and equal administrators never start banning`() = runTest {
        var calls = 0
        for (state in listOf(RoomMembersState.Unknown, ready(own, other.copy(powerLevel = 100)), ready(other))) {
            assertThat(closeGroupMembers(state, own.userId) {
                calls++
                Result.success(Unit)
            }.isFailure).isTrue()
        }
        assertThat(calls).isEqualTo(0)
    }

    @Test
    fun `a failure without a message still stops closure`() = runTest {
        var calls = 0
        val result = closeGroupMembers(ready(own, other, other.copy(userId = UserId("@third:example.org"))), own.userId) {
            calls++
            Result.failure(IllegalStateException())
        }
        assertThat(result.isFailure).isTrue()
        assertThat(calls).isEqualTo(1)
    }

    @Test
    fun `successful closure moderates other active members only`() = runTest {
        val banned = mutableListOf<UserId>()
        val result = closeGroupMembers(ready(own, other), own.userId) {
            banned += it
            Result.success(Unit)
        }
        assertThat(result.isSuccess).isTrue()
        assertThat(banned).containsExactly(other.userId)
    }

    @Test(expected = CancellationException::class)
    fun `cancellation is propagated`() = runTest {
        closeGroupMembers(ready(own, other), own.userId) { throw CancellationException() }
        Unit
    }

    private fun ready(vararg members: io.element.android.libraries.matrix.api.room.RoomMember) =
        RoomMembersState.Ready(members.toList().toImmutableList())
}
