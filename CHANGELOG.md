# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project adheres to [this versioning scheme](https://gist.github.com/cech12/69319028e88c50349a6b044000a6607b).

## [1.21.1-4.2.1.0] - 2025-11-06
### Added
- burn time (fuel efficiency) can now be configured (all loaders) (thanks to Phyne_ for the idea) #47

## [1.21.1-4.2.0.0] - 2024-10-27
### Changed
- updated to Minecraft 1.21.1 (Fabric 0.105.0+1.21.1, Neoforge 21.1.62, Forge 52.0.21)
- updated Cloth Config support (15.0.140) (Fabric/Quilt)
- updated ModMenu support (11.0.2) (Fabric/Quilt)
- updated JEI support (19.19.0.219) (Forge & NeoForge)
- updated REI support (16.0.788) (Fabric/Quilt & NeoForge)
- updated The One Probe support (1.21_neo-12.0.3) (NeoForge)
- re-added Immersive Engineering (1.21.1-12.0.0) (NeoForge)

### Fixed
- fixed JEI loading errors since 19.19.0.219 (all loaders)

## [1.21-4.1.1.0] - 2024-08-30
### Changed
- cook time factor config option is now a text field instead of a slider (thanks to NattoRiisa for the hint) #34

## [1.21-4.1.0.1] - 2024-08-10
### Fixed
- fixed startup crash for Forge

## [1.21-4.1.0.0] - 2024-07-14
### Changed
- updated NeoForge to 21.0.94-beta
- the `config` directory is used for the default configuration (NeoForge)

### Fixed
- crashed on startup with NeoForge (caused by a breaking change in 21.0.82-beta)

## [1.21-4.0.0.0] - 2024-06-29
### Changed
- updated to Minecraft 1.21 (Fabric 0.100.3+1.21, Neoforge 21.0.42-beta, Forge 51.0.18)
- updated Cloth Config support (15.0.127) (Fabric/Quilt)
- updated ModMenu support (11.0.1) (Fabric/Quilt)
- updated JEI support (19.0.0.11) (Forge & NeoForge)
- updated REI support (16.0.729) (Fabric/Quilt & NeoForge)
- updated The One Probe support (1.21_neo-12.0.0) (NeoForge)
- temporary deactivation of Immersive Engineering support until it is ported to 1.21 (NeoForge)

## [1.20.6-3.2.0.0] - 2024-06-29
### Changed
- updated to Minecraft 1.20.6 (Fabric 0.98.0+1.20.6, NeoForge 20.6.119, Forge 50.1.9)
- updated Cloth Config support (14.0.126) (Fabric/Quilt)
- updated ModMenu support (10.0.0) (Fabric/Quilt)
- updated JEI support (18.0.0.65) (Forge & NeoForge)
- updated REI support (15.0.728) (Fabric/Quilt & NeoForge)
- updated The One Probe support (1.20.5_neo-11.1.1) (NeoForge)
- temporary deactivation of Immersive Engineering support until it is ported to 1.20.6 (NeoForge)

### Fixed
- crafting recipe of Brick Blast Furnace used bricks instead of brick blocks (all loaders)

### Removed
- removed REI support for Forge

## [1.20.4-3.1.2.0] - 2024-06-05
### Added
- added Roughly Enough Items (REI) support (version 14.1.727) (all loaders)

## [1.20.4-3.1.1.0] - 2024-05-11
### Added
- registering ItemHandlers to be more compatible with other mods (NeoForge)

### Fixed
- Brick Furnace recipe advancement triggered with first inventory change (Fabric/Quilt)

## [1.20.4-3.1.0.1] - 2024-04-27
### Fixed
- JEI plugin was not loaded in Fabric/Quilt

## [1.20.4-3.1.0.0] - 2024-04-25
### Added
- add Fabric (>=0.96.11+1.20.4) support (Fabric, Quilt)

## [1.20.4-3.0.0.0] - 2024-04-06
### Changed
- updated to Minecraft 1.20.4 (Forge 49.0.38, Neoforge 20.4.218)
- updated JEI support to 17.3.0.49 (Forge & Neoforge)
- updated The One Probe support to 1.20.4_neo-11.0.2-3 (Neoforge)
- updated Immersive Engineering support to 1.20.4-11.1.0-172 (Neoforge)
- rename config option "recipeBlacklist" to "recipeBlockedList"

## [1.20.2-2.2.0.3] - 2024-03-31
### Fixed
- fuel consumption of Brick Smoker & Brick Blast Furnace were incorrect (thanks to t3chdelicious for the report)

## [1.20.2-2.2.0.2] - 2023-11-12
### Fixed
- cook time factor was sometimes ignored (thanks to Lcannine for the report) #31

## [1.20.2-2.2.0.1] - 2023-11-08
### Fixed
- cook time factor was ignored for every first smelted item (thanks to Lcannine for the report) #29

## [1.20.2-2.2.0.0] - 2023-10-23
### Changed
- update and move back to Forge 1.20.2-48.0.23 (from NeoForge) until it is stable
- Temporary deactivation of The One Probe support until it is ported to 1.20.2
- Temporary deactivation of Immersive Engineering support until it is ported to 1.20.2
- deactivate game tests, because they are not working yet

## [1.20.1-2.1.1.0] - 2023-09-24
### Added
- Added Russian translation (thanks to FishermanHMeM) #26

## [1.20.1-2.1.0.0] - 2023-08-03
### Changed
- Changed Forge to NeoForge 1.20.1-47.1.54 (compatible with Forge 47.1.0) 
- Updated compat with JEI to 1.20.1-15.2.0.23
- Re-added compat with Immersive Engineering 1.20.1-9.4.0 #22

## [1.20.1-2.0.0.0] - 2023-06-19
### Changed
- Update mod to Forge 1.20.1-47.0.1 #21
- Update compat with JEI to 1.20.1-15.0.0.17 #21
- Update compat with The One Probe to 1.20.0-9.0.0 #21
- Temporary deactivation of Immersive Engineering support until it is ported to 1.20

## [1.19.4-1.10.1.0] - 2023-05-29
### Changed
- Update mod to Forge 1.19.4-45.0.59
- Update compat with JEI to 1.19.4-13.1.0.9
- re-add Immersive Engineering 1.19.4-9.4.0+ support

## [1.19.4-1.10.0.0] - 2023-04-04
### Changed
- Update mod to Forge 1.19.4-45.0.40
- Update compat with The One Probe to 1.19.4-8.0.0
- Update compat with JEI to 1.19.4-13.0.0.1
- Temporary deactivation of Immersive Engineering support until it is ported to 1.19.4

## [1.19.3-1.9.3.0] - 2023-02-06
### Changed
- update mod to Forge 1.19.3-44.1.5
- re-add Immersive Engineering 1.19.3-9.2.0+ support

## [1.19.3-1.9.2.1] - 2023-01-18
### Changed
- fix startup issue with mod "REI Plugin Compatibilities (REIPC)" version 10.0.45 (thanks to subsonicer for the report)

## [1.19.3-1.9.2.0] - 2023-01-17
### Changed
- re-add JEI support

## [1.19.3-1.9.1.0] - 2023-01-06
### Added
- Added Portuguese translation (thanks to alofh) #17

## [1.19.3-1.9.0.0] - 2022-12-30
### Changed
- Update mod to Forge 1.19.3-44.0.41
- Changed the recipes to use the forge tags for brick & iron ingots
- Update compat with The One Probe to 1.19.3-7.0.0
- Temporary deactivation of JEI & Immersive Engineering support until they are ported to 1.19.3

## [1.19.2-1.8.3.0] - 2022-11-04
### Added
- Support for External Heater of Immersive Engineering #16

### Changed
- Update mod to Forge 1.19.2-43.1.2

## [1.19-1.8.2.0] - 2022-09-20
### Added
- The One Probe support - Show cooking time of Brick Furnaces

## [1.19-1.8.1.0] - 2022-07-14
### Changed
- Update mod to Forge 1.19-41.0.96 to fix startup crashes since Forge 1.19-41.0.94

## [1.19-1.8.0.0] - 2022-07-12
### Changed
- Update mod to Forge 1.19-41.0.63

## [1.18.2-1.7.0.0] - 2022-04-30
### Changed
- Update mod to Forge 1.18.2-40.0.31 (fix Log4J security issue)

### Fixed
- Fix compatibility with JEI 1.18.2-9.7.0.192 and later (startup crash)

## [1.18-1.6.0.0] - 2021-12-05
### Changed
- Update mod to Forge 1.18-38.0.14

## [1.17.1-1.6.0.0] - 2021-12-05
### Changed
- Update mod to Forge 1.17.1-37.0.32
- changed versioning to fit [Forge Recommended Versioning](https://mcforge.readthedocs.io/en/latest/conventions/versioning/)
- change mappings to official channel

## [1.5.2_1.16] - 2021-04-29
### Changed
- added recipe variant for Environmental's kiln #9 (thanks to randomnickname2137 for the hint)
- Known bug: incompatibile with Polymorph (smelting recipes are used for all brick furnaces, vanilla recipes cannot be disabled)

## [1.5.1_1.16] - 2020-11-10
### Changed
- Small change to support mods like Just Enough Professions (JEP)

## [1.5.0_1.16] - 2020-10-30
### Changed
- Feature Changes:
- added new recipe types "brickfurnace:smelting", "brickfurnace:blasting", "brickfurnace:smoking" for data packs to add special recipes #6
- Villagers can now use the Brick Blast Furnace and the Brick Smoker as workplace. #5
- removed "clay to brick at campfire" recipe (can be added via a data pack)
- removed "minecart with furnace" recipe (to avoid transforming a Brick Furnace to a vanilla Furnace)
- JEI integration changed: each brick furnace has now its own JEI category
- Config Changes:
- Config file moved to server for consistant configuration
- add config option for disabling vanilla recipes inside of brick furnaces
- add config option for blacklisting single vanilla recipes inside of brick furnaces
- removed config of "clay to brick at campfire" recipe enabling

### Fixed
- tool was not needed to break the furnaces

## [1.4.1_1.16] - 2020-08-25
### Changed
- Mod also supports MC 1.16.2 now.

## [1.4.0_1.16] - 2020-08-07
### Changed
- Mod is available for MC 1.16.1 now.
- Added a cook time factor config value

## [1.3.0] - 2020-04-19
### Changed
- JEI integration
- Spanisch language support

## [1.2.1] - 2020-02-27
### Changed
- Chinese (zh_cn, zh_tw) language support (thanks to aikinitt)
- Korean (ko_kr) language support (thanks to MilkissWhite)
- texture rotation fixed (for better fitting in brick emvironment)

## [1.2.0] - 2020-02-21
### Changed
- Brick Blast Furnace and Brick Smoker added
- also with FastFurnace performace enhancement
- with own recipes
- Villagers don't use them as workplace
- support for Forge 28.1.X (1.14.4)

## [1.1.0] - 2020-02-20
### Changed
- Performance Enhancement
- Add code from FastFurnace mod (https://github.com/Shadows-of-Fire/FastFurnace) to enhance performance (thanks to tfarecnim for the hint)

## [1.0.0] - 2020-02-19
### Changed
- Adds a Brick Furnace to the game:
- acts like a normal furnace
- has brick textues
- is craftable with 8 bricks
- you can enable brick melting at campfire with a config option (default: disabled)
