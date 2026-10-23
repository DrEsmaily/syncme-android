# Build 259 migration audit

## Source selection

- Element X base: `def8f7f34824dcc8b05483086c333ce2b5cb08d9`.
- Reviewed SyncMe source: `345864b15f2b8b6ca41728a50a280bd5efa81f39`, branch `build/syncme-259-scroll`.
- The old default branch points at `c5c5ba1f096572d31846ac3a822924314252e0c4` at review time. Its README
  links build 259, but its application tree omits several fixes in the actual build source.
  The migration therefore uses the build source, rather than inferring application contents from that README.
- The original repository and all its branches remain available at https://github.com/DrEsmaily/Syncme.

The migration uses real new review commits and PRs. It does not backdate work or invent historical
reviews. Original Element X ancestry is retained. The maintenance run in [#21](https://github.com/DrEsmaily/syncme-android/pull/21)
also transfers the current LFS snapshot and attempts to preserve the original legacy Git history
under `legacy/syncme-build-259`. Its run result establishes whether that archive step completed.

## File-level traceability

`legacy-port-manifest.json` records all 176 paths changed between the selected base and build 259
in application, feature, library, plugin, service and navigation directories. For each path:

- `ported`: the reviewed blob matches the source blob exactly.
- `adapted`: the source was integrated with the new identity, project conventions, regression fixes or existing changes.
- `retained-upstream`: the legacy change was deliberately not enabled; the reason is recorded.

Blob IDs identify file contents independently of later documentation commits or merge commits.
Additional migration code, tests and repository automation are visible in their PR diffs.

## Deliberate differences

The application has the approved independent ID `com.github.dresmaily.syncme`, with a separate
SyncMe Test installation. There is no automatic session or encrypted-data migration from the old app.
Automatic server suggestions and prefills use the tested filtering policy; manual server entry is preserved.

Legacy startup, TLS and decryption diagnostic capture/export hooks are not enabled in the active
application. Normal upstream implementations remain in their place. This also omits the related
external-intent export surface and diagnostic-only settings. Feature behaviour does not depend
on these reports.

The pinned upstream TLS verifier and its revocation transport configuration are retained.
The legacy vendored replacement removes an additional revocation checker. Changing certificate
verification policy requires dedicated native/device validation; this migration does not silently
adopt that transport change. The SDK version remains `26.10.05-nightly`.

The reviewed integration fixes formatting, license headers, immutable Compose collection boundaries
and unused navigation dependencies. It also rejects incomplete membership and moderation failures
before leaving a group, including failures whose exception has no message. These differences have
regression coverage rather than being concealed in a source-tree copy.

SyncMe has independent version metadata. The base APK code is `20261023`, above the initial
foundation code, and the existing ABI suffix scheme remains in use. Release signing uses an
owner-controlled configuration instead of the public debug key.

## Validation and release gates

The foundation passed build, unit tests and lint in [39948264813](https://github.com/DrEsmaily/syncme-android/actions/runs/39948264813).
Tag storage passed all three checks in [40016686370](https://github.com/DrEsmaily/syncme-android/actions/runs/40016686370).
Subsequent PR checks establish validation of each later integration stage; their exact heads and
results are recorded on GitHub. A passing earlier stage does not establish a later candidate's result.

All 102 changed production Kotlin files in the complete migration were checked locally against
the project's base detekt rules. Changed Kotlin files were formatted with the pinned ktlint version,
and workflow syntax was checked with actionlint. Full Compose rules, compilation and unit tests
run in GitHub Actions because the required Android SDK is unavailable in the execution workspace.

Device acceptance and private signing remain pending. In particular, verify background delivery
with the new application ID: Firebase resources and the push gateway still use the upstream
configuration. No independent production push service setup is claimed. Tags currently use
device-local app preferences, rather than an account-specific or server-synced store.

Use the [device checklist](device-acceptance.md) and [signing guide](release-signing.md) before release.
