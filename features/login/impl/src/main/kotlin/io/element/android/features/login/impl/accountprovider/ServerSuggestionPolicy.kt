/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.login.impl.accountprovider

import java.net.URI
import java.net.URISyntaxException

/** Controls automatic suggestions only; manually entered servers remain supported. */
internal fun isAutomaticServerSuggestionAllowed(server: String): Boolean {
    val value = server.trim()
    val uri = try {
        URI(if ("://" in value) value else "https://$value")
    } catch (_: URISyntaxException) {
        return false
    }
    val host = uri.host?.trimEnd('.') ?: return false
    return !host.substringAfterLast('.').equals("ir", ignoreCase = true)
}
