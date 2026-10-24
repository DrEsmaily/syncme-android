/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.ui.presence

import io.element.android.libraries.matrix.api.user.UserPresence

internal class PresenceStatusPreviewParam : androidx.compose.ui.tooling.preview.PreviewParameterProvider<UserPresence> {
    override val values = sequenceOf(
        UserPresence.Unknown,
        UserPresence.Online,
        UserPresence.Away,
        UserPresence.Offline(null),
        *listOf(30 * 60_000L, 5 * 3_600_000L, 5 * 86_400_000L, 15 * 86_400_000L, 40 * 86_400_000L, 400 * 86_400_000L)
            .map { UserPresence.Offline(System.currentTimeMillis() - it) }.toTypedArray(),
    )
}
