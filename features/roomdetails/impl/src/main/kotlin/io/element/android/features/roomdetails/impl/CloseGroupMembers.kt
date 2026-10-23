/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.roomdetails.impl

import io.element.android.libraries.core.extensions.runCatchingExceptions
import io.element.android.libraries.matrix.api.core.UserId
import io.element.android.libraries.matrix.api.room.RoomMembersState
import io.element.android.libraries.matrix.api.room.RoomMembershipState

/** Fail before any moderation if the full member list or hierarchy cannot be established. */
internal suspend fun closeGroupMembers(
    state: RoomMembersState,
    ownUserId: UserId,
    ban: suspend (UserId) -> Result<Unit>,
): Result<Unit> = runCatchingExceptions {
    val members = (state as? RoomMembersState.Ready)?.roomMembers
        ?: error("A complete member list is required")
    val own = members.firstOrNull { it.userId == ownUserId }
        ?: error("The current member is missing")
    val targets = members.filter {
        it.userId != ownUserId && it.membership in setOf(RoomMembershipState.JOIN, RoomMembershipState.INVITE, RoomMembershipState.KNOCK)
    }
    check(targets.all { it.powerLevel < own.powerLevel }) { "A member has equal or higher privileges" }
    targets.forEach { ban(it.userId).getOrThrow() }
}
