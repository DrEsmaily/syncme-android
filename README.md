# SyncMe for Android

Independent Android Matrix client based on Element X Android.

**Status: verified repository foundation; legacy feature migration is in progress. No production release yet.**

Build, unit tests and lint passed in [CI run 39948264813](https://github.com/DrEsmaily/syncme-android/actions/runs/39948264813).
Test APKs are available in that run’s artifacts. Device testing and production signing remain pending.

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
Legacy SyncMe features are being transferred in separate reviewed changes.
CI artifacts include the APK, checksum, source commit, signing certificate details and build URL.

## Origin and license

Original Element X history and license notices are retained. See [LICENSE](LICENSE)
and [LICENSE-COMMERCIAL](LICENSE-COMMERCIAL). Existing source-file license notices remain authoritative.
The original project README is preserved in `docs/README.element-x.md` (its relative links were written for the repository root).

The previous SyncMe repository remains at https://github.com/DrEsmaily/Syncme.
