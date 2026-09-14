# PC Builder — Builder Design Pattern

Assignment #1 (Software Design Patterns). An implementation of the GoF
**Builder** pattern in Java, applied to assembling a custom gaming/office/
workstation computer.

## Why this product fits the Builder pattern

A `Computer` has many components (CPU, GPU, RAM, storage, motherboard,
PSU, case, cooling), some mandatory and some optional with sensible
defaults. Building it through a single telescoping constructor would be
unreadable and error-prone. The Builder pattern lets each component be set
independently, step by step, through a fluent API, and produces several
*representations* of the same product — a gaming rig, an office PC, a
workstation, or a fully custom build — from the same construction process.

## Components

| Component | Class | Role |
|---|---|---|
| Product | `Computer` | Immutable, fully assembled computer. |
| Builder | `ComputerBuilder` | Fluent contract for step-by-step construction. |
| Concrete Builder | `StandardComputerBuilder` | Accumulates choices, applies defaults, validates before building. |
| Director | `ComputerDirector` | Knows the recipes for reusable configurations (gaming / office / workstation). |
| Client | `Main` | Demonstrates director-driven builds, a fully custom build, and validation failure. |

## Running it

```bash
javac -d out $(find src/main/java -name "*.java")
java -cp out com.pcbuilder.Main
```

## Clean Code principles applied

### 1. Meaningful, intention-revealing names

Every field, class, and method name says exactly what it holds or does —
no abbreviations that require the reader to guess.

```java
// Before
String c; int r; String s;

// After (StandardComputerBuilder)
private String cpu;
private int ramGb;
private String storage;
```

### 2. Small, single-responsibility classes

Each class has exactly one reason to change: `Computer` only holds data,
`StandardComputerBuilder` only knows how to assemble and validate one, and
`ComputerDirector` only knows *sequences* of builder calls — it never
touches validation or defaults logic. This keeps every class short and
easy to reason about in isolation, instead of one class doing "everything
PC-related".

### 3. No magic numbers or strings

Thresholds and default component names are named constants, not inline
literals scattered through the logic.

```java
// Before
if (psuWatts < 300) {
    throw new IllegalStateException("PSU too weak");
}

// After (StandardComputerBuilder)
private static final int MIN_PSU_WATTS = 300;
...
if (psuWatts < MIN_PSU_WATTS) {
    throw new IllegalStateException(
        "PSU must supply at least " + MIN_PSU_WATTS + "W, but was " + psuWatts + "W.");
}
```

### 4. Validated construction with clear failure messages

`build()` never returns a half-configured `Computer`. It fails fast with a
specific `IllegalStateException` naming exactly what is missing or invalid,
instead of letting an invalid object silently exist.

```java
// Before
public Computer build() {
    return new Computer(cpu, gpu, ramGb, storage, motherboard, psuWatts,
            caseType, coolingSystem, rgbLighting); // may build garbage
}

// After (StandardComputerBuilder)
public Computer build() {
    validateRequiredFields();
    return new Computer(cpu, gpu, ramGb, storage, motherboard, psuWatts,
            caseType, coolingSystem, rgbLighting);
}

private void validateRequiredFields() {
    if (isBlank(cpu)) {
        throw new IllegalStateException("Cannot build a Computer without a CPU.");
    }
    // ... remaining mandatory checks
}
```

### 5. Immutability of the finished product

`Computer` exposes only a package-private constructor and getters — no
setters. Once built, a `Computer` can never be put into an inconsistent
state by code outside the builder, which removes an entire class of bugs.

```java
// Before (mutable product — anything can corrupt it after construction)
public class Computer {
    public String cpu;
    public void setCpu(String cpu) { this.cpu = cpu; }
}

// After (Computer.java)
public final class Computer {
    private final String cpu;
    Computer(String cpu, /* ... */) { this.cpu = cpu; /* ... */ }
    public String getCpu() { return cpu; }
    // no setters — state is fixed once built
}
```

## Project structure

```
pc-builder/
├── README.md
└── src/main/java/com/pcbuilder/
    ├── Computer.java              # Product
    ├── ComputerBuilder.java       # Builder interface
    ├── StandardComputerBuilder.java  # Concrete builder + validation
    ├── ComputerDirector.java      # Director
    └── Main.java                  # Client / demo
```
