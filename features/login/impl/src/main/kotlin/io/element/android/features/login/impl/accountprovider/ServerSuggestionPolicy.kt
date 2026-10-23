/*
 * Copyright (c) 2025 Element Creations Ltd.
 * Copyright 2023-2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.login.impl.accountprovider

import java.net.URI

/** Controls automatic suggestions only; manually entered servers remain supported. */
internal fun isAutomaticServerSuggestionAllowed(server: String): Boolean {
    val value = server.trim()
    val uri = runCatching { URI(if ("://" in value) value else "https://$value") }.getOrNull()
    val host = uri?.host?.trimEnd('.') ?: return false
    return !host.substringAfterLast('.').equals("ir", ignoreCase = true)
}
