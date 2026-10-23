# Device acceptance for the migrated SyncMe build

Record the device model, Android version, exact APK checksum, commit, signer and results in the
release issue. Download the universal test APK and provenance from a successful CI build artifact.
The test installation is independent of the previous SyncMe app and uses a new session.

- [ ] Install on Android 7.x and a current Android release; verify the SyncMe launcher artwork and SyncMe Test label.
- [ ] Open login; confirm there is no legacy country-domain prefill or automatic suggestion. Check history after a restart.
- [ ] Log in with a password and, where the server supports it, OAuth. Test an invalid server and a recoverable login failure.
- [ ] Send encrypted messages in a direct chat and a group; receive replies, verify another session and restart the app.
- [ ] Confirm that scrolling or background updates do not mark unrendered messages as read. Test public and private receipt settings.
- [ ] Create, rename, select multiple tags, tag chats, clear memberships and delete a tag; restart and confirm persistence.
- [ ] Add and switch accounts; verify account layout, cached avatars and notification routing. Tags currently use device-local app preferences.
- [ ] Send an original video with optimization disabled; test a large upload, progress, cancellation, retry and a reconnect.
- [ ] Open media after a restart; inspect disk usage and clear media cache. The five-GiB budget applies per account and is not eagerly allocated.
- [ ] Check online, away and last-seen display with another account; scroll and return, switch apps and disconnect the network.
- [ ] Lock the phone and test notification delivery after the app has been in the background; repeat after restarting the phone.
- [ ] Reset identity on a disposable test account, including servers where backup is disabled; verify completion and cancellation.
- [ ] Test group closure only in a disposable group. Check an equal-privilege administrator and a failed ban; confirm that a partial failure does not leave silently.
- [ ] For the private signed candidate, install a subsequent higher-version build using the same private key and confirm that the update succeeds.

Only an explicit server online response produces a green presence indicator. Unknown or failed
presence requests must not imply online status. System keyboard and password-manager history is
controlled outside SyncMe and should be distinguished from the app's own server suggestions.

CI does not establish these device results. Leave unchecked items pending until they are actually tested.
