# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/) and this project adheres to [Forge Recommended Versioning](https://mcforge.readthedocs.io/en/latest/conventions/versioning/).

## [1.19.2-1.8.4.0] - 2023-09-24
### Added
- Added Russian translation (thanks to FishermanHMeM) #26

## [1.19.2-1.8.3.2] - 2023-01-19
### Added
- Added Portuguese translation (thanks to alofh) #17

## [1.19.2-1.8.3.1] - 2023-01-19
### Fixed
- fixed JEI support by updating JEI to 11.5.0.297 #20 (thanks to Tenchu98 for the report)

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
