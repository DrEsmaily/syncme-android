/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.libraries.matrix.api.user

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/** Process-local foreground hint; null until an Activity lifecycle transition is observed. */
object SyncMeAppVisibility {
    private val mutableIsForeground = MutableStateFlow<Boolean?>(null)
    val isForeground: StateFlow<Boolean?> = mutableIsForeground

    fun setForeground(value: Boolean) {
        mutableIsForeground.value = value
    }
}
