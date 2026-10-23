# SyncMe for Android

Independent Android Matrix client based on Element X Android.

![CI](https://github.com/DrEsmaily/syncme-android/actions/workflows/ci.yml/badge.svg?branch=main)

SyncMe 1.1.1 restores the reviewed features of legacy build 259 on its exact Element X base.
Production signing and device acceptance are separate release gates; no production release is claimed here.

## Features and history

| Capability | Review |
| --- | --- |
| Local custom tags, multiple filters and chat membership | [#10](https://github.com/DrEsmaily/syncme-android/pull/10), [#12](https://github.com/DrEsmaily/syncme-android/pull/12), [#14](https://github.com/DrEsmaily/syncme-android/pull/14) |
| Presence, last seen and room management | [#11](https://github.com/DrEsmaily/syncme-android/pull/11), [#13](https://github.com/DrEsmaily/syncme-android/pull/13) |
| Original media uploads, progress and cancellation | [#15](https://github.com/DrEsmaily/syncme-android/pull/15), [#17](https://github.com/DrEsmaily/syncme-android/pull/17) |
| Visible-event read acknowledgements and receipt display | [#16](https://github.com/DrEsmaily/syncme-android/pull/16) |
| Account recovery, branding, appearance and media cache | [#18](https://github.com/DrEsmaily/syncme-android/pull/18), [#19](https://github.com/DrEsmaily/syncme-android/pull/19), [#20](https://github.com/DrEsmaily/syncme-android/pull/20) |

The [migration audit](docs/syncme/migration-audit.md) records the source snapshot and deliberate
differences. The [file manifest](docs/syncme/legacy-port-manifest.json) maps all 176 changed application
paths to their original and reviewed Git blobs. Upstream history and original license notices are retained.

## Development

- `main`: default branch; accepted, verified changes.
- `staging`: integration and device testing for the next release.
- `feat/*`, `fix/*`, `chore/*`: short-lived branches merged through pull requests.

Start with [the development process](docs/syncme/development.md),
[upstream provenance](docs/syncme/provenance.md), and
[the migration plan](docs/syncme/migration.md).

## Build

Use JDK 21 and the Android SDK specified in `plugins/src/main/kotlin/Versions.kt`.
Run `./gradlew :app:assembleGplayDebug --no-configuration-cache`.
Test builds use the SyncMe Test label and `com.github.dresmaily.syncme.debug` application ID.
The production identity is `com.github.dresmaily.syncme`, a new independent installation.
CI artifacts include the APK, checksum, source commit, signing certificate details and build URL.
SyncMe versioning lives in [SyncMeVersion.kt](plugins/src/main/kotlin/config/SyncMeVersion.kt).
See [private signing](docs/syncme/release-signing.md) and [device acceptance](docs/syncme/device-acceptance.md)
before preparing a release.

## Origin and license

Original Element X history and license notices are retained. See [LICENSE](LICENSE)
and [LICENSE-COMMERCIAL](LICENSE-COMMERCIAL). Existing source-file license notices remain authoritative.
The original project README is preserved in `docs/README.element-x.md` (its relative links were written for the repository root).

The previous SyncMe repository remains at https://github.com/DrEsmaily/Syncme.
