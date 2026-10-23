/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package config

/** SyncMe versioning is independent of the retained Element X baseline version. */
object SyncMeVersion {
    const val NAME = "1.1.1"

    // Stay above the initial foundation APK code; app outputs append an ABI digit.
    const val CODE = 20_261_023
}
