# Architecture

SyncMe preserves the baseline Element X Android modular architecture.

- `app`: Android application, variants and application wiring.
- `appnav`: top-level navigation and session flow.
- `features/*/api`, `impl`, `test`: feature contracts, implementation and test fakes.
- `libraries/matrix`: Kotlin-facing abstractions and the Matrix Rust SDK integration.
- `libraries/compound` and `libraries/designsystem`: reusable Compose UI and styling.
- `plugins`: build conventions, application configuration and toolchain versions.

Screens use Appyx nodes, Molecule presenters, immutable state and event handlers.
Metro supplies dependency injection. Keep Matrix SDK implementation types behind the Kotlin
abstraction so UI features remain testable. Preserve encryption and account lifecycle logic
when transferring legacy customisations.

## Migration boundaries

Branding and installation identity are separate from presence, personal tags, media progress,
and receipts. Transfer each behaviour with focused tests and a documented upstream delta.
Do not replace the pinned Matrix SDK while also changing feature behaviour.

[Baseline provenance](provenance.md) records the exact starting commit. The old repository
is a source of candidate changes, not evidence that every historical experiment is production-ready.
