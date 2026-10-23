/*
 * Copyright (c) 2026 SyncMe contributors.
 *
 * SPDX-License-Identifier: AGPL-3.0-only.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.login.impl.accountprovider

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ServerSuggestionPolicyTest {
    @Test
    fun `country suffix is excluded regardless of case port or trailing dot`() {
        val suffix = "ir"
        listOf("example.$suffix", "https://sub.example.${suffix.uppercase()}:8448/path", "example.$suffix.").forEach {
            assertThat(isAutomaticServerSuggestionAllowed(it)).isFalse()
        }
    }

    @Test
    fun `other hosts are not excluded by a similar substring or path`() {
        listOf("matrix.org", "https://example.org/ir", "ir.example.org", "example.irish", "https://example.org:8448").forEach {
            assertThat(isAutomaticServerSuggestionAllowed(it)).isTrue()
        }
    }

    @Test
    fun `invalid or empty hosts are not suggested`() {
        listOf("", " ", "https://", "not a host").forEach {
            assertThat(isAutomaticServerSuggestionAllowed(it)).isFalse()
        }
    }
}
