# Sheep Dog AsciiDoc API

API for bidirectional transformation between AsciiDoc specifications and UML models.

## Overview

Converts AsciiDoc specification documents into Eclipse UML2 models and back. This is the core transformation library that bridges the specification format with the UML model representation used throughout the ecosystem.

## Key Functionality

- AsciiDoc to UML model transformation
- UML model to AsciiDoc generation
- UML model classes: UMLTestProject, UMLTestSuite, UMLTestCase, UMLTestStep, UMLStepDefinition, UMLStepObject

## Technology

- Eclipse EMF/UML2
- Eclipse Xtext
- Depends on sheepdogasciidoc.parent
- Java 21

## Build

```
scripts/install.bat
```
