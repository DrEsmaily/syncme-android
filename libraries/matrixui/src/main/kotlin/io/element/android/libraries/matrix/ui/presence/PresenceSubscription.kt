/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.ui.presence

import io.element.android.libraries.matrix.api.core.UserId

/** A screen owns one subscription, independent of changes to its visible rows. */
internal class PresenceSubscription(
    private val track: (Set<UserId>) -> Unit,
    private val release: (Set<UserId>) -> Unit,
) {
    private var users: Set<UserId> = emptySet()

    fun update(next: Set<UserId>) {
        if (next == users) return
        val added = next - users
        val removed = users - next
        if (added.isNotEmpty()) track(added)
        if (removed.isNotEmpty()) release(removed)
        users = next.toSet()
    }

    fun dispose() {
        if (users.isNotEmpty()) release(users)
        users = emptySet()
    }
}
