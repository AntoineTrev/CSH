# Hytale Java Plugin

This repository contains a Hytale server plugin written in Java, using a fully reproducible development environment powered by Devbox.

The goal is to provide a clean, modern, and deterministic setup suitable for long-term plugin development.

---

## Project Goals

- Develop Hytale server-side plugins in Java
- Use a modern JDK (OpenJDK 25)
- Ensure reproducible builds across all machines
- Provide a developer-friendly JVM toolchain
- Stay IDE-agnostic (VS Code, IntelliJ, Neovim)

---

## Technical Stack

### Core
- Java: OpenJDK 25
- Build Tool: Gradle
- Environment: Devbox (Nix-based)
- Version Control: Git

### Developer Tooling
- Java Language Server (jdtls) for IDE features (VS Code, Neovim, etc.)
- JUnit Platform (JUnit 5) for unit and integration testing
- Make for utility scripts and task shortcuts
- bash / coreutils for scripting and automation

### JVM Enhancements
- jdk-debug for low-level debugging and JVM inspection
- Lombok for reducing boilerplate code via annotations

---

## Getting Started

1. Install Devbox

curl -fsSL https://get.jetify.com/devbox | bash

2. Enter the development environment

devbox shell

All required tools (Java, Gradle, Make, jdtls, etc.) are now available.

3. Verify the installation

java --version
javac --version
gradle --version

---

## Project Structure

.
├─ devbox.json
├─ build.gradle.kts
├─ settings.gradle.kts
├─ src/
│  ├─ main/java/
│  │  └─ com/yourplugin/
│  └─ main/resources/
│     └─ plugin.json
├─ .gitignore
└─ README.md

---

## Add Hytale Lib

in libs/ directory

add HytaleServer.jar

---

## Build

gradle build

The generated plugin JAR will be located in:

build/libs/

---

## Running Tests

gradle test

The project uses JUnit Platform (JUnit 5).

---

## Gradle Configuration Notes

### Java Toolchain

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

### Lombok Configuration

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}

### Hytale API Dependency (Recommended)

dependencies {
    compileOnly("com.hytale:hytale-server-api:VERSION")
}

Using compileOnly ensures the API is not bundled into the final JAR.

---

## Hytale Plugin Best Practices

- Use compileOnly for the Hytale server API
- Never bundle the Hytale server or API in your plugin JAR
- Prefer clean, explicit APIs over reflection
- One plugin = one JAR
- Keep runtime dependencies minimal
