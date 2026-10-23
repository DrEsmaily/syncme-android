# Development process

Create a focused issue with acceptance criteria for substantive changes. Branch from staging,
submit a small PR back to staging, inspect the diff, and record test evidence.
CI must pass; an independent approval is optional while there is only one developer.
Self-review is not independent review.

Use squash merges for short-lived feature PRs. Promote staging to main with a merge commit,
then merge main back into staging if needed. Do not squash promotions between these permanent
branches, rewrite shared history, or enable a linear-history rule that prevents these merges.
Delete completed short-lived branches, never staging.

For a stack of dependent PRs, use merge commits so later branches retain their real predecessor
ancestry. Test every stage, merge from the bottom of the stack, retarget the next PR to staging
and include the updated base when branch protection requires it. CI also runs on PRs targeting
temporary predecessor branches. Once the stack is integrated, delete all its temporary branches.

Protect main and staging with PR requirements, required passing CI, resolved conversations,
and restrictions on force pushes and deletion. Apply the rules to the owner too.
Activate required check names only after their actual executions are verified.

Release tags identify exact commits on main. Release notes record changes, tests, known limitations,
APK checksums and signer identity. Do not create a permanent branch for every build number.
A passing build does not replace device testing for login, encrypted messages, notifications,
media, multi-account behaviour and upgrade compatibility.
