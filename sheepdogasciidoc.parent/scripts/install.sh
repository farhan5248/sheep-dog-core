#!/bin/bash
cd "$(dirname "$0")/.."
gradle clean
gradle publishToMavenLocal --refresh-dependencies
gradle xtextasciidocplugin.vscode:installExtension
