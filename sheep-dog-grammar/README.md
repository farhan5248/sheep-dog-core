# Sheep Dog Grammar

Core grammar logic and validation framework shared across Xtext DSL projects.

## Overview

Provides shared utilities for Xtext-based parsers including content assist, validation, issue detection, and quick-fix proposals. Defines the DSL interfaces (ITestProject, ITestSuite, ITestCase, ITestStep, IStepDefinition, IStepObject) implemented by the AsciiDoc and Cucumber grammars.

## Key Functionality

- DSL interfaces for test specification elements
- Issue detection for cells, rows, test steps, and test suites
- Quick-fix proposal generation for detected issues
- Shared grammar utilities (SheepDogFactory, SheepDogBuilder, SheepDogUtility)
- IResourceRepository interface for file/model persistence abstraction

## Technology

- Eclipse EMF/UML2
- Eclipse Xtext MWE2
- Java 21

## Build

```
scripts/install.bat
```
