/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.ui.presence

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import io.element.android.libraries.designsystem.preview.ElementPreview
import io.element.android.libraries.designsystem.preview.PreviewsDayNight
import io.element.android.libraries.matrix.api.MatrixClient
import io.element.android.libraries.matrix.api.core.UserId
import io.element.android.libraries.matrix.api.user.OnlineMemberCount
import io.element.android.libraries.matrix.api.user.UserPresence
import io.element.android.libraries.matrix.api.user.presenceLabel
import io.element.android.libraries.ui.strings.CommonPlurals
import io.element.android.libraries.ui.strings.CommonStrings

/** Bounded snapshots for visible users, released on navigation; one shared session stream. */
@Composable
fun MatrixClient.observePresence(users: kotlinx.collections.immutable.ImmutableSet<UserId>): Map<UserId, UserPresence> {
    val visibleUsers = users.sortedBy { it.value }.take(128).toSet()
    val subscription = remember(this) { PresenceSubscription(::trackPresence, ::releasePresence) }
    DisposableEffect(subscription) {
        onDispose { subscription.dispose() }
    }
    SideEffect { subscription.update(visibleUsers) }
    val states by presenceStates.collectAsState()
    return states
}

@Composable
fun UserPresence.toPresenceText(): String? = when (this) {
    UserPresence.Unknown -> null
    UserPresence.Online -> stringResource(CommonStrings.syncme_presence_online)
    UserPresence.Away -> stringResource(CommonStrings.syncme_presence_away)
    is UserPresence.Offline -> presenceLabel(System.currentTimeMillis())
}

@Composable
fun OnlineMemberCount?.toPresenceText(): String? = this?.let {
    pluralStringResource(
        if (isComplete) CommonPlurals.syncme_presence_online_count else CommonPlurals.syncme_presence_online_count_partial,
        online,
        online,
    )
}

@PreviewsDayNight
@Composable
internal fun PresenceStatusPreview(
    @androidx.compose.ui.tooling.preview.PreviewParameter(PresenceStatusPreviewParam::class) presence: UserPresence,
) = ElementPreview { PresenceStatus(presence) }
