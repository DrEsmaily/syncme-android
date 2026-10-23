# SyncMe for Android

Independent Android Matrix client based on Element X Android.

**Status: repository foundation and migration in progress. No upgrade APK is released from this repository yet.**

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
The initial foundation still builds the upstream application; SyncMe identity and features are transferred in separate reviewed changes.

## Origin and license

Original Element X history and license notices are retained. See [LICENSE](LICENSE)
and [LICENSE-COMMERCIAL](LICENSE-COMMERCIAL). Existing source-file license notices remain authoritative.
The original project README is preserved in `docs/README.element-x.md` (its relative links were written for the repository root).

The previous SyncMe repository remains at https://github.com/DrEsmaily/Syncme.
