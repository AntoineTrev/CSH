# CSH – Cast a Spell by Hand  
## Design & Requirements Overview

---

## Mod Goal

The goal of **CSH** is to allow players to cast an **almost infinite variety of spells** in a **simple and intuitive way**, without requiring a dedicated item to be held in hand.  
The system is designed to provide **flexible, combinatorial magic**, while still allowing the player to hold weapons, tools, or other items at the same time.

---

## Context

### Hytale Overview

HYTALE is a sandbox adventure game, often compared to Minecraft, combining exploration, combat, crafting, and an advanced modding system.  
The game emphasizes player freedom, systemic gameplay, and deep customization through mods.

### Current Magic System in Hytale

The current magic system in HYTALE primarily relies on:
- spell books,
- magic staves or wands.

These systems usually involve:
- holding a **dedicated magic item**,
- consuming **physical resources or charges**,
- limited flexibility in spell usage.

### Identified Limitations

While functional, the existing approach has several drawbacks:
- A required item slot for spell casting
- Consumption of physical materials
- Limited spell modularity
- Reduced player freedom during combat

**CSH** aims to address these issues by introducing a **hand-casting magic system** based purely on player abilities.

---

## Origin of the Idea

The mod is inspired by the game **Magicka**, which allows players to create spells by combining multiple elements and actions.

For **CSH**, the system is intentionally simplified:
- a spell is composed of **one action**
- combined with **one element**

Example:  
> **Action: Projectile + Element: Fire → Fireball**

This design ensures clarity, balance, and ease of expansion.

---

## In-Game Usage

### Core Input Concept

The system relies on a **secondary magic modifier key** (for example: `Shift`).

Spell preparation flow:
1. `Shift + Action key`
2. `Shift + Element key`
3. The spell is now **prepared**

Spell execution:
- `Shift + Left Click` → Cast the spell
- `Shift + Right Click` → Cancel the spell

### User Interface

- The list of available **actions**, **elements**, and their **key bindings** is displayed in the bottom-left corner of the HUD
- The UI clearly shows:
  - selected action
  - selected element
  - spell readiness state

---

## Mana and Effect System

- Spells consume **mana only**
- Each **action** and **element** has:
  - a mana cost
  - base damage or effect values

Final spell values are calculated as:
- **Total Mana Cost = Action Cost + Element Cost**
- **Total Effects = Action Effects + Element Effects**
- **Total Damages = Action Damages + Element Damages**

---

## Cooldowns and Limitations

To prevent spell spamming:
- each **action** has its own cooldown
- each **element** has its own cooldown

Cooldowns:
- regenerate automatically over time
- are independent from each other

### Preparation Timer

- Once an action and an element are selected, a **timer** starts
- If the spell is not cast in time:
  - the selection is reset
  - no cooldown is consumed

---

## Adventure / Survival Gameplay

### Discovery System

In survival mode:
- actions and elements are **not available by default**
- they are discovered through **loot chests**, similar to recipes

Each discovery unlocks:
- a new action or element
- or an upgrade level for an existing one

### Progression and Upgrades

- Actions and elements can be upgraded up to **Level 3**
- Upgrades may:
  - extend preparation time
  - reduce cooldowns
  - increase damage or effect strength

All upgrades are displayed directly in the HUD.

---

# Spell Matrix

## Available Actions

| Action | Description |
|-------|-------------|
| Projectile | Launches a spell in a straight line |
| Area | Creates a persistent area effect |
| Self | Applies the effect to the player |
| Target Entity | Applies the effect to a targeted entity |

---

## Available Elements

| Element | Description |
|--------|-------------|
| Fire | Damage over time, burning |
| Water | Extinguish, control |
| Air | Movement, displacement |
| Life | Healing, buffs |

---

## Action + Element Matrix

### 🔥 Fire

| Action | Spell Name | Effect |
|------|-----------|--------|
| Projectile | Fireball | Direct damage + Burn |
| Area | Burning Zone | Burns entities inside |
| Self | Immolation | Player is set on fire |
| Target Entity | Burning Mark | Ignites the target |

---

### 💧 Water

| Action | Spell Name | Effect |
|------|-----------|--------|
| Projectile | Water Jet | Low damage + Wet |
| Area | Water Zone | Extinguishes fire + slow |
| Self | Purification | Removes negative effects |
| Target Entity | Drench | Extinguishes fire |

---

### 🌬️ Air

| Action | Spell Name | Effect |
|------|-----------|--------|
| Projectile | Air Blast | Knockback |
| Area | Wind Zone | Pushes entities outward |
| Self | Front Dash | Horizontal propulsion |
| Target Entity | Air Pull | Forced displacement |

---

### 🌱 Life

| Action | Spell Name | Effect |
|------|-----------|--------|
| Projectile | Vital Orb | Heals on hit |
| Area | Regeneration Zone | Continuous healing |
| Self | Self Heal | Instant heal |
| Target Entity | Blessing | Heal or buff |

---

## Status Effects

| Status | Description |
|------|-------------|
| Burn | Damage over time |
| Wet | Fire resistance, Air synergy |
| Knockback | Forced movement |
| Regeneration | Healing over time |
| Blessing | Temporary buff |

---

## Elemental Interactions

| Element A | Element B | Interaction |
|----------|----------|-------------|
| Fire | Water | Water extinguishes Fire |
| Fire | Air | Fire spreads |
| Water | Air | Increased area/duration |
| Life | Fire | Burn damage reduction |
| Life | Water | Enhanced healing |

---

## Design Notes

- Each matrix cell represents **one unique spell**
- Effects are simple but highly combinable
- The system is fully **data-driven and extensible**

---

## Future Extensions

- New elements (Earth, Lightning)
- New actions (Shield, Beam)
