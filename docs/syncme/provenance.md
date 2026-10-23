# Upstream provenance

- Upstream: https://github.com/element-hq/element-x-android
- Exact baseline: `def8f7f34824dcc8b05483086c333ce2b5cb08d9`
- Baseline date: 2026-10-07
- Subject: Merge pull request #7877; fix the wrong account being signed out when another account session is revoked.
- Evidence: this is both the parent of the first SyncMe branding commit `d3b1e1acbe` and the merge base between the existing Build 259 branch and upstream develop inspected on 2026-10-23.
- The source version constants say 26.09.4, but this is a development commit, not an assertion that the tree equals the v26.09.4 release tag.
- Baseline Matrix Rust SDK: `26.10.05-nightly`. Do not silently substitute a newer SDK during migration.
- Existing release reference: `345864b15f2b8b6ca41728a50a280bd5efa81f39` (Build 259 branch). The artifact-producing commit must be recorded separately when validating the APK.

Upstream workflow definitions are preserved under `docs/upstream-workflows/*.disabled`.
They are not active: several rely on Element enterprise credentials, bots and publishing services.
Reintroduce needed checks deliberately, without enabling upstream publishing automation.
