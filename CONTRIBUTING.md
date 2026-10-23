# Contributing to SyncMe

## Development setup

Use JDK 21, Android Studio and the Android SDK versions in `plugins/src/main/kotlin/Versions.kt`.
Clone this repository and use its Gradle wrapper. The public application builds without
Element enterprise credentials or the private enterprise submodule.

```sh
./gradlew :app:assembleGplayDebug --no-configuration-cache
./gradlew :app:testGplayDebugUnitTest testDebugUnitTest --no-configuration-cache
./gradlew :app:lintGplayDebug lintDebug ktlintCheck detekt --no-configuration-cache
```

CI runs these checks on pull requests. Compilation, automated tests and device tests are
separate evidence; do not describe a change as device-verified without running it.

## Issues and pull requests

Report reproducible defects or propose work in this repository's Issues. Include acceptance
criteria and reference the issue in the PR. Branch from `staging`; use focused `feat/`, `fix/`
or `chore/` branches and target `staging`. Keep production changes under 500 added lines
where practical; split independent changes. Use descriptive sentence-style titles.

Describe the problem, resulting behaviour, tests and known limitations. Include screenshots
for UI changes. Review your own diff even when working alone. Resolve discussions and wait
for required CI. An independent reviewer is welcome but not mandatory for a solo maintainer.
Use exactly one `PR-` release-category label.

Use squash for short-lived feature branches; use a merge commit to promote `staging` to
`main`. See [the branch and release process](docs/syncme/development.md).

## Code conventions

Follow `.editorconfig`, the existing feature API/implementation/test module boundaries,
Compose state/event patterns and the Matrix SDK abstraction. Use Timber, and never log
passwords, access tokens, encryption keys or message contents.

Preserve upstream licenses and attribution. Do not edit generated `localazy.xml` files.
Place new strings in `temporary.xml` using numbered formatting placeholders. Keep upstream
translation updates separate from SyncMe-specific strings.

See [architecture](docs/syncme/architecture.md) and [provenance](docs/syncme/provenance.md).
The original upstream contribution guide is archived at `docs/CONTRIBUTING.element-x.md`;
its Element team approval and service instructions do not govern SyncMe contributions.
