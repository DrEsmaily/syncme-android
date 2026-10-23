# Migration plan and release gates

## Stages

1. Preserve the exact upstream base and establish CI and repository rules.
2. Restore SyncMe branding and build identity in source, not by CI text replacement.
3. Transfer selected changes from the existing repository in independently reviewable PRs:
   personal tags, upload progress and controls, presence, receipt behaviour, and UI changes.
4. Add regression coverage for each transferred behaviour and review SDK/TLS changes separately.
5. Verify device behaviour and upgrade installation before publishing a release.

The legacy repository and all its branches remain intact. Historical experiments are not
accepted features merely because they appear in the old history.

## Installation identity (updated user decision)

The owner explicitly chose a new independent installation over upgrade compatibility.
Production application ID: `com.github.dresmaily.syncme`.
Test application ID: `com.github.dresmaily.syncme.debug`; display name: SyncMe Test.
There is no automatic upgrade or migration of the old installation's sessions or encrypted data.

No legacy country-domain branding, preset server or automatic server suggestion should be
carried into this project. Manual server entry remains available. System keyboards and
external password managers control their own stored suggestions.

Production signing must use a private release key before a public production release.
The inherited shared debug signature is only suitable for test builds.

## Current validation status

Gradle 9.8.0 starts under JDK 21. CI YAML parses successfully. Android compilation,
unit tests, lint and device verification are still pending.

`branch-protection.json` is the planned protection request for main and staging.
The GitHub integration rejected repository-settings updates with HTTP 403; rules have
not been applied. The owner has created the new public repository.
