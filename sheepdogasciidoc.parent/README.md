# Sheep Dog AsciiDoc Parser

Xtext-based DSL for AsciiDoc specification files with formatting, validation, and code generation.

## Overview

Multi-module project containing an Xtext grammar and Language Server Protocol (LSP) implementation for AsciiDoc specifications. The LSP server is consumed by both the VS Code and Eclipse IDE plugins.

## Modules

| Module | Description |
|--------|-------------|
| xtextasciidocplugin | Core Xtext grammar, parser, formatter, validator, and generator |
| xtextasciidocplugin.ide | LSP server implementation |

## Key Functionality

- Xtext grammar for Sheep Dog AsciiDoc specification format
- Formatting rules for consistent document structure
- Validation with error markers
- Code generation from AsciiDoc specifications
- Scoping provider for cross-reference resolution

## Technology

- Eclipse Xtext 2.42
- Eclipse EMF
- Language Server Protocol (LSP)
- Java 21

## Build

```
scripts/install.bat
```
