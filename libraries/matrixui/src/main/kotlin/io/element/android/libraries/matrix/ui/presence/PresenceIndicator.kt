/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.ui.presence

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import io.element.android.compound.theme.ElementTheme
import io.element.android.libraries.matrix.api.user.UserPresence

@Composable
fun PresenceIndicator(presence: UserPresence, modifier: Modifier = Modifier) {
    if (presence != UserPresence.Online && presence != UserPresence.Away) return
    val label = presence.toPresenceText() ?: return
    val color = when (presence) {
        UserPresence.Online -> ElementTheme.colors.iconSuccessPrimary
        UserPresence.Away -> ElementTheme.colors.iconWarningPrimary
        else -> return
    }
    Box(modifier.size(10.dp).background(color, CircleShape).semantics { contentDescription = label })
}
