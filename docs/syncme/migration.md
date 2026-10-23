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

## Upgrade compatibility

- Production application ID must remain `ir.syncme.app.syncmerelease`.
- Test builds need a separate application ID so they install alongside production.
- Build 259 workflow sets base versionCode `20261026`; APK splitting multiplies it by ten
  and adds the ABI digit. Check the actual released APK before selecting the next code.
- Existing Gradle configuration signs release with the committed shared debug keystore.
  Compare the actual released APK signer before asserting upgrade compatibility.
- A public debug key is not a private production signing identity. Moving to a private key
  needs an explicit Android signing migration strategy; simply replacing the key breaks upgrades.
- Preserve and test persisted data, encryption state and login sessions; matching package and
  signer alone does not establish data compatibility.

## Current limitations

Repository creation via the available GitHub CLI integration returned
`Resource not accessible by integration (createRepository)` on 2026-10-23.
Remote setup and CI runs are pending creation/access to DrEsmaily/syncme-android.
No new APK has been built or verified yet.

The prepared `branch-protection.json` is a REST branch-protection request body for both permanent branches, to apply after the first successful CI runs. It has not been applied remotely.
