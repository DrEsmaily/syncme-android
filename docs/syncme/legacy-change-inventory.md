# Legacy change inventory

Source: `DrEsmaily/Syncme`, commit `345864b15f2b8b6ca41728a50a280bd5efa81f39`.
Baseline: `def8f7f34824dcc8b05483086c333ce2b5cb08d9`.

This inventory contains 174 changed paths in application, feature, library, service, icon and build-convention directories. It is a comparison of source trees, not an approval to copy every change.

## Review order

1. Branding and installation identity, followed by launcher assets on supported Android versions.
2. Personal tags and persistence, with home filtering and room-menu regression tests.
3. Media progress and cancellation, with large-file and reconnect device tests.
4. Presence and receipts, with lifecycle, multiple-account and multi-device checks.
5. Remaining UI adjustments, independently from protocol and encryption changes.

Changes to TLS verification, identity reset, push registration and SDK bindings require separate review. Preserve upstream behaviour until the reason for each legacy change and its regression coverage are established.

## Paths by module

### app/build.gradle.kts (1)

- `app/build.gradle.kts`

### app/src (5)

- `app/src/main/kotlin/io/element/android/x/ElementXApplication.kt`
- `app/src/main/kotlin/io/element/android/x/MainActivity.kt`
- `app/src/main/kotlin/io/element/android/x/initializer/PlatformInitializer.kt`
- `app/src/main/res/xml/file_providers.xml`
- `app/src/main/res/xml/network_security_config.xml`

### appicon/element (3)

- `appicon/element/src/main/res/drawable-nodpi/syncme_launcher.webp`
- `appicon/element/src/main/res/mipmap-anydpi-v26/ic_launcher.xml`
- `appicon/element/src/main/res/mipmap-anydpi-v26/ic_launcher_round.xml`

### features/createroom (1)

- `features/createroom/impl/src/main/kotlin/io/element/android/features/createroom/impl/configureroom/ConfigureRoomView.kt`

### features/home (19)

- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/HomeFlowNode.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/HomeView.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/components/HomeTopBar.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/components/RoomSummaryRow.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/datasource/RoomListDataSource.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/datasource/RoomListRoomSummaryFactory.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/filters/RoomListFiltersEvent.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/filters/RoomListFiltersPresenter.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/filters/RoomListFiltersState.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/filters/RoomListFiltersStatePreviewParam.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/filters/RoomListFiltersView.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/model/RoomListRoomSummary.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/roomlist/RoomListContextMenu.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/roomlist/RoomListEvent.kt`
- `features/home/impl/src/main/kotlin/io/element/android/features/home/impl/roomlist/RoomListPresenter.kt`
- `features/home/impl/src/main/res/drawable/syncme_tag_outline.xml`
- `features/home/impl/src/test/kotlin/io/element/android/features/home/impl/filters/RoomListFiltersPresenterTest.kt`
- `features/home/impl/src/test/kotlin/io/element/android/features/home/impl/roomlist/RoomListContextMenuTest.kt`
- `features/home/impl/src/test/kotlin/io/element/android/features/home/impl/roomlist/RoomListPresenterTest.kt`

### features/lockscreen (1)

- `features/lockscreen/impl/src/main/kotlin/io/element/android/features/lockscreen/impl/pin/DefaultPinCodeManager.kt`

### features/login (6)

- `features/login/impl/src/main/kotlin/io/element/android/features/login/impl/LoginFlowTransitionHandler.kt`
- `features/login/impl/src/main/kotlin/io/element/android/features/login/impl/screens/confirmaccountprovider/ConfirmAccountProviderPresenter.kt`
- `features/login/impl/src/main/kotlin/io/element/android/features/login/impl/screens/loginpassword/LoginPasswordView.kt`
- `features/login/impl/src/main/kotlin/io/element/android/features/login/impl/screens/onboarding/OnBoardingView.kt`
- `features/login/impl/src/main/res/drawable/syncme_welcome_mark.xml`
- `features/login/impl/src/test/kotlin/io/element/android/features/login/impl/screens/confirmaccountprovider/ConfirmAccountProviderPresenterTest.kt`

### features/messages (29)

- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/MessagesPresenter.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/MessagesState.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/MessagesView.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/actionlist/ActionListPresenter.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/actionlist/ActionListView.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/actionlist/model/TimelineItemAction.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/attachments/preview/AttachmentsPreviewPresenter.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/attachments/preview/AttachmentsPreviewView.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/attachments/video/DefaultMediaOptimizationSelectorPresenter.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/TimelinePresenter.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/TimelineState.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/TimelineView.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/MessageEventBubble.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/MessagesReactionButton.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/TimelineItemEventRow.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/TimelineItemReactionsView.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/TimelineItemRow.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/customreaction/CustomReactionBottomSheet.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/event/TimelineItemFileView.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/components/receipt/bottomsheet/ReadReceiptBottomSheet.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/factories/OutgoingReadReceipts.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/timeline/factories/TimelineItemsFactory.kt`
- `features/messages/impl/src/main/kotlin/io/element/android/features/messages/impl/topbars/MessagesViewTopBar.kt`
- `features/messages/impl/src/test/kotlin/io/element/android/features/messages/impl/MessagesPresenterTest.kt`
- `features/messages/impl/src/test/kotlin/io/element/android/features/messages/impl/attachments/AttachmentsPreviewPresenterTest.kt`
- `features/messages/impl/src/test/kotlin/io/element/android/features/messages/impl/attachments/video/DefaultMediaOptimizationSelectorPresenterTest.kt`
- `features/messages/impl/src/test/kotlin/io/element/android/features/messages/impl/timeline/TimelinePresenterTest.kt`
- `features/messages/impl/src/test/kotlin/io/element/android/features/messages/impl/timeline/TimelineViewTest.kt`
- `features/messages/impl/src/test/kotlin/io/element/android/features/messages/impl/timeline/factories/OutgoingReadReceiptsTest.kt`

### features/poll (1)

- `features/poll/api/src/main/kotlin/io/element/android/features/poll/api/pollcontent/PollContentView.kt`

### features/preferences (10)

- `features/preferences/impl/src/main/kotlin/io/element/android/features/preferences/impl/account/PreferencesAccountView.kt`
- `features/preferences/impl/src/main/kotlin/io/element/android/features/preferences/impl/developer/DeveloperSettingsView.kt`
- `features/preferences/impl/src/main/kotlin/io/element/android/features/preferences/impl/root/PreferencesRootNode.kt`
- `features/preferences/impl/src/main/kotlin/io/element/android/features/preferences/impl/root/PreferencesRootPresenter.kt`
- `features/preferences/impl/src/main/kotlin/io/element/android/features/preferences/impl/root/PreferencesRootView.kt`
- `features/preferences/impl/src/main/kotlin/io/element/android/features/preferences/impl/root/VersionFormatter.kt`
- `features/preferences/impl/src/main/kotlin/io/element/android/features/preferences/impl/utils/ShowDeveloperSettingsProvider.kt`
- `features/preferences/impl/src/test/kotlin/io/element/android/features/preferences/impl/root/PreferencesRootPresenterTest.kt`
- `features/preferences/impl/src/test/kotlin/io/element/android/features/preferences/impl/root/PreferencesRootViewTest.kt`
- `features/preferences/impl/src/test/kotlin/io/element/android/features/preferences/impl/root/VersionFormatterTest.kt`

### features/roomdetails (10)

- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/RoomDetailsEvent.kt`
- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/RoomDetailsPresenter.kt`
- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/RoomDetailsState.kt`
- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/RoomDetailsView.kt`
- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/members/RoomMemberListEvent.kt`
- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/members/RoomMemberListPresenter.kt`
- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/members/RoomMemberListState.kt`
- `features/roomdetails/impl/src/main/kotlin/io/element/android/features/roomdetails/impl/members/RoomMemberListView.kt`
- `features/roomdetails/impl/src/test/kotlin/io/element/android/features/roomdetails/impl/MatrixRoomFixture.kt`
- `features/roomdetails/impl/src/test/kotlin/io/element/android/features/roomdetails/impl/members/RoomMemberListPresenterTest.kt`

### features/roomdirectory (1)

- `features/roomdirectory/impl/src/main/kotlin/io/element/android/features/roomdirectory/impl/root/RoomDirectoryPresenter.kt`

### features/securebackup (6)

- `features/securebackup/impl/src/main/kotlin/io/element/android/features/securebackup/impl/reset/ResetIdentityFlowManager.kt`
- `features/securebackup/impl/src/main/kotlin/io/element/android/features/securebackup/impl/reset/ResetIdentityFlowNode.kt`
- `features/securebackup/impl/src/main/kotlin/io/element/android/features/securebackup/impl/reset/password/ResetIdentityPasswordNode.kt`
- `features/securebackup/impl/src/main/kotlin/io/element/android/features/securebackup/impl/reset/password/ResetIdentityPasswordPresenter.kt`
- `features/securebackup/impl/src/test/kotlin/io/element/android/features/securebackup/impl/reset/ResetIdentityFlowManagerTest.kt`
- `features/securebackup/impl/src/test/kotlin/io/element/android/features/securebackup/impl/reset/password/ResetIdentityPasswordPresenterTest.kt`

### features/startchat (1)

- `features/startchat/impl/src/main/kotlin/io/element/android/features/startchat/impl/root/StartChatView.kt`

### features/userprofile (5)

- `features/userprofile/api/src/main/kotlin/io/element/android/features/userprofile/api/UserProfileState.kt`
- `features/userprofile/impl/src/main/kotlin/io/element/android/features/userprofile/impl/root/UserProfilePresenter.kt`
- `features/userprofile/impl/src/test/kotlin/io/element/android/features/userprofile/impl/UserProfilePresenterTest.kt`
- `features/userprofile/shared/src/main/kotlin/io/element/android/features/userprofile/shared/UserProfileHeaderSection.kt`
- `features/userprofile/shared/src/main/kotlin/io/element/android/features/userprofile/shared/UserProfileView.kt`

### libraries/architecture (2)

- `libraries/architecture/src/main/kotlin/io/element/android/libraries/architecture/animation/ScreenTransition.kt`
- `libraries/architecture/src/main/kotlin/io/element/android/libraries/architecture/appyx/FaderOrSliderTransitionHandler.kt`

### libraries/compound (4)

- `libraries/compound/src/main/kotlin/io/element/android/compound/tokens/generated/SemanticColorsDark.kt`
- `libraries/compound/src/main/kotlin/io/element/android/compound/tokens/generated/SemanticColorsDarkHc.kt`
- `libraries/compound/src/main/kotlin/io/element/android/compound/tokens/generated/SemanticColorsLight.kt`
- `libraries/compound/src/main/kotlin/io/element/android/compound/tokens/generated/SemanticColorsLightHc.kt`

### libraries/designsystem (6)

- `libraries/designsystem/src/main/kotlin/io/element/android/libraries/designsystem/components/avatar/internal/AvatarThumbnail.kt`
- `libraries/designsystem/src/main/kotlin/io/element/android/libraries/designsystem/components/avatar/internal/ImageAvatar.kt`
- `libraries/designsystem/src/main/kotlin/io/element/android/libraries/designsystem/theme/ColorAliases.kt`
- `libraries/designsystem/src/main/kotlin/io/element/android/libraries/designsystem/theme/components/ModalBottomSheet.kt`
- `libraries/designsystem/src/main/res/drawable/ic_notification.xml`
- `libraries/designsystem/src/test/kotlin/io/element/android/libraries/designsystem/components/avatar/internal/AvatarThumbnailTest.kt`

### libraries/featureflag (1)

- `libraries/featureflag/api/src/main/kotlin/io/element/android/libraries/featureflag/api/FeatureFlags.kt`

### libraries/matrix (31)

- `libraries/matrix/api/build.gradle.kts`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/MatrixClient.kt`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/auth/OAuthConfig.kt`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/diagnostics/DecryptionDiagnostics.kt`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/diagnostics/StartupTrace.kt`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/diagnostics/SyncMeDiagnosticsControl.kt`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/diagnostics/TlsAudit.kt`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/user/SyncMeAppVisibility.kt`
- `libraries/matrix/api/src/main/kotlin/io/element/android/libraries/matrix/api/user/UserPresence.kt`
- `libraries/matrix/api/src/test/kotlin/io/element/android/libraries/matrix/api/user/OnlineMemberCountTest.kt`
- `libraries/matrix/api/src/test/kotlin/io/element/android/libraries/matrix/api/user/UserPresenceTest.kt`
- `libraries/matrix/impl/build.gradle.kts`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/ClientBuilderProvider.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/RustHomeserverCapabilitiesProvider.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/RustMatrixClient.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/RustMatrixClientFactory.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/analytics/UtdTracker.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/encryption/RustEncryptionService.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/encryption/RustIdentityResetHandle.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/sync/RustSyncService.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/timeline/RustTimeline.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/timeline/item/event/EventTimelineItemMapper.kt`
- `libraries/matrix/impl/src/main/kotlin/io/element/android/libraries/matrix/impl/user/RustPresenceService.kt`
- `libraries/matrix/impl/src/test/kotlin/io/element/android/libraries/matrix/impl/RustMatrixClientFactoryTest.kt`
- `libraries/matrix/impl/src/test/kotlin/io/element/android/libraries/matrix/impl/auth/OAuthConfigurationProviderTest.kt`
- `libraries/matrix/impl/src/test/kotlin/io/element/android/libraries/matrix/impl/diagnostics/DecryptionDiagnosticsTest.kt`
- `libraries/matrix/impl/src/test/kotlin/io/element/android/libraries/matrix/impl/fixtures/fakes/FakeFfiClient.kt`
- `libraries/matrix/impl/src/test/kotlin/io/element/android/libraries/matrix/impl/fixtures/fakes/FakeFfiClientBuilder.kt`
- `libraries/matrix/impl/src/test/kotlin/io/element/android/libraries/matrix/impl/user/PresenceFromJsonTest.kt`
- `libraries/matrix/impl/src/test/kotlin/io/element/android/libraries/matrix/impl/user/RustPresenceServiceTest.kt`
- `libraries/matrix/test/src/main/kotlin/io/element/android/libraries/matrix/test/FakeMatrixClient.kt`

### libraries/matrixui (6)

- `libraries/matrixui/src/main/kotlin/io/element/android/libraries/matrix/ui/components/MatrixUserRow.kt`
- `libraries/matrixui/src/main/kotlin/io/element/android/libraries/matrix/ui/components/UserRow.kt`
- `libraries/matrixui/src/main/kotlin/io/element/android/libraries/matrix/ui/presence/Presence.kt`
- `libraries/matrixui/src/main/kotlin/io/element/android/libraries/matrix/ui/presence/PresenceSubscription.kt`
- `libraries/matrixui/src/main/kotlin/io/element/android/libraries/matrix/ui/room/MatrixRoomMembers.kt`
- `libraries/matrixui/src/test/kotlin/io/element/android/libraries/matrix/ui/presence/PresenceSubscriptionTest.kt`

### libraries/mediaupload (1)

- `libraries/mediaupload/impl/src/main/kotlin/io/element/android/libraries/mediaupload/impl/AndroidMediaPreProcessor.kt`

### libraries/mediaviewer (3)

- `libraries/mediaviewer/impl/src/main/kotlin/io/element/android/libraries/mediaviewer/impl/local/video/MediaVideoView.kt`
- `libraries/mediaviewer/impl/src/main/kotlin/io/element/android/libraries/mediaviewer/impl/util/Colors.kt`
- `libraries/mediaviewer/impl/src/main/kotlin/io/element/android/libraries/mediaviewer/impl/viewer/MediaViewerView.kt`

### libraries/network (1)

- `libraries/network/src/main/kotlin/io/element/android/libraries/network/di/NetworkBindingContainer.kt`

### libraries/preferences (4)

- `libraries/preferences/api/src/main/kotlin/io/element/android/libraries/preferences/api/store/AppPreferencesStore.kt`
- `libraries/preferences/impl/src/main/kotlin/io/element/android/libraries/preferences/impl/store/DefaultAppPreferencesStore.kt`
- `libraries/preferences/impl/src/test/kotlin/io/element/android/libraries/preferences/impl/store/DefaultAppPreferencesStoreTest.kt`
- `libraries/preferences/test/src/main/kotlin/io/element/android/libraries/preferences/test/InMemoryAppPreferencesStore.kt`

### libraries/pushproviders (4)

- `libraries/pushproviders/firebase/src/main/kotlin/io/element/android/libraries/pushproviders/firebase/FirebasePushProvider.kt`
- `libraries/pushproviders/firebase/src/test/kotlin/io/element/android/libraries/pushproviders/firebase/FirebasePushProviderTest.kt`
- `libraries/pushproviders/firebase/src/test/kotlin/io/element/android/libraries/pushproviders/firebase/InMemoryFirebaseStore.kt`
- `libraries/pushproviders/firebase/src/test/kotlin/io/element/android/libraries/pushproviders/firebase/troubleshoot/FirebaseTokenTestTest.kt`

### libraries/rustls-tls (8)

- `libraries/rustls-tls/LICENSE-APACHE`
- `libraries/rustls-tls/LICENSE-MIT`
- `libraries/rustls-tls/README.md`
- `libraries/rustls-tls/build.gradle.kts`
- `libraries/rustls-tls/consumer-rules.pro`
- `libraries/rustls-tls/src/main/kotlin/org/rustls/platformverifier/CertificateVerifier.kt`
- `libraries/rustls-tls/src/test/kotlin/org/rustls/platformverifier/CertificateVerifierTest.kt`
- `libraries/rustls-tls/src/test/resources/server.pem`

### libraries/textcomposer (1)

- `libraries/textcomposer/impl/src/main/kotlin/io/element/android/libraries/textcomposer/TextComposer.kt`

### libraries/ui-strings (1)

- `libraries/ui-strings/src/main/res/values/temporary.xml`

### libraries/usersearch (1)

- `libraries/usersearch/impl/src/main/kotlin/io/element/android/libraries/usersearch/impl/MatrixUserRepository.kt`

### plugins/src (1)

- `plugins/src/main/kotlin/config/BuildTimeConfig.kt`
