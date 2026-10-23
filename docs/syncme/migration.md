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

Build, unit tests and lint all passed for integration candidate
`7d4a6ac0a0bba5b47c6eed17648d08ca27f38dd4` in
[CI run 39948264813](https://github.com/DrEsmaily/syncme-android/actions/runs/39948264813).
The resulting staging commit `9ac25cc97197c49bb412563425cdaa3d76e738a3` has exactly the
same Git tree (`73028c53e805a8d08d05f71cc30afd724ec390fc`) as that tested candidate.

The checks cover APK assembly and identity/signature validation, unit tests (including
server suggestions), Android lint, ktlint and detekt. They do not establish on-device
behaviour or production release readiness.

The owner configured protection for both `main` and `staging`; both are confirmed protected.
`branch-protection.json` records the intended required checks. Enabling those required
status checks remains an owner-side setting because this integration cannot administer
branch protection.

The existing Syncme repository remains unchanged. Feature migration, private production
signing and device acceptance tests remain separate work tracked in
[issue 3](https://github.com/DrEsmaily/syncme-android/issues/3).
