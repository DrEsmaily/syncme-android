# Private release signing

Production and test installations have separate identities:

| Build | Application ID | Label | Signing |
| --- | --- | --- | --- |
| Debug | `com.github.dresmaily.syncme.debug` | SyncMe Test | Public upstream debug key; testing only |
| Release | `com.github.dresmaily.syncme` | SyncMe | Owner-controlled private key |

Release builds no longer inherit the debug signing configuration. Never distribute a production
APK signed with the shared debug key. Keep an encrypted backup of the production keystore,
alias and passwords before using the key for a public installation; future updates need that key.
Do not put these values in issues, chat, commits or artifacts.

## Owner setup

Use an existing private SyncMe production key if one has already been distributed for this
application ID. Otherwise generate a new key on a trusted owner-controlled machine, for example:

```sh
keytool -genkeypair -keystore /private/path/syncme-release.jks -alias syncme -keyalg RSA -keysize 3072 -validity 10000
```

Answer keytool's prompts locally. Do not pass passwords in a committed command or script.
Encode the keystore locally with `base64 -w 0 /private/path/syncme-release.jks` (Linux), or the
equivalent base64 command on your system.

In `DrEsmaily/syncme-android`, open **Settings → Secrets and variables → Actions → New repository secret**.
Create these four repository secrets:

| Secret | Value |
| --- | --- |
| `SYNCME_RELEASE_KEYSTORE_BASE64` | Base64 encoding of the private keystore |
| `SYNCME_RELEASE_KEY_ALIAS` | The selected key alias |
| `SYNCME_RELEASE_KEY_PASSWORD` | Password for that key |
| `SYNCME_RELEASE_STORE_PASSWORD` | Password for the keystore |

## Build a candidate

After CI passes on the exact `main` commit, open **Actions → Signed release candidate → Run workflow**,
select `main`, and run it. The workflow checks the three required GitHub Actions results, assembles
the release APK, verifies its package and label, rejects debuggable APKs and the public debug
certificate, and uploads the APK with its checksum, source commit and certificate information.
It removes the temporary keystore even if a build step fails. It does not publish a release.

For a local release build, set the three alias/password environment variables above and
`SYNCME_RELEASE_STORE_FILE` to the private keystore's local path, then run
`./gradlew :app:assembleGplayRelease --no-configuration-cache`.

The workflow has been checked with actionlint. A signed build requires the owner's secrets;
no private production key or successful signed release is claimed by the migration.
