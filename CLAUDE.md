# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a coding dojo/kata based on Conway's Game of Life, designed to teach software design principles and explore tensions and synergies between different design approaches.

## Build Commands

```bash
./gradlew test      # Build and run all tests
./gradlew run       # Run the Swing-based GUI application
```

To run a single test class:
```bash
./gradlew test --tests "com.thoughtworks.game_of_life.core.WorldTest"
```

## Architecture

**Core Layer** (`com.thoughtworks.game_of_life.core`):
- `Cell` interface with `AliveCell`/`DeadCell` implementations - polymorphic behavior for Game of Life rules
- `World` - manages game state and cell evolution
- `Location` - coordinate system with neighbor calculation

**UI Layer** (`com.thoughtworks.game_of_life.ui`):
- `GameRunner` - application entry point and main game loop
- `GameCanvas` - Swing rendering with double buffering
- Presenter pattern: `CellToPresenterFactory` creates `AliveCellPresenter`/`DeadCellPresenter` based on cell type
- Screen abstraction: `IntroScreen` and `GameScreen` for UI state management

## Design Patterns in Use

- **Strategy**: Cell interface with AliveCell/DeadCell for rule variation
- **Factory**: CellToPresenterFactory for presenter creation
- **State**: Screen interface for UI state transitions
- **Composite**: GamePresenter delegates to individual cell presenters

## Testing

Tests use JUnit 4 with Hamcrest matchers and Mockito. The main test file is `WorldTest.java` covering Conway's Game of Life rules.
