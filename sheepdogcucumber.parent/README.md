# Sheep Dog Cucumber Parser

Xtext-based DSL for Cucumber/Gherkin feature files with formatting, validation, and code generation.

## Overview

Multi-module project containing an Xtext grammar for parsing and manipulating Cucumber feature files. Defines the grammar for Gherkin syntax including Features, Scenarios, Backgrounds, and step definitions.

## Modules

| Module | Description |
|--------|-------------|
| sheepdogcucumber | Core Xtext grammar, parser, formatter, validator, and generator |

## Key Functionality

- Xtext grammar for full Cucumber/Gherkin syntax
- Parser for .feature files
- Formatter for consistent file formatting
- Validator for syntax and semantic checks
- Support for Scenario Outlines with Examples tables
- Support for step tables and DocStrings

## Technology

- Eclipse Xtext 2.42
- Eclipse EMF
- Java 21

## Build

```
scripts/install.bat
```
