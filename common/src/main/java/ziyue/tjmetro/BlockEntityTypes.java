package ziyue.tjmetro;

import mtr.RegistryObject;
import mtr.mappings.RegistryUtilities;
import net.minecraft.world.level.block.entity.BlockEntityType;
import ziyue.tjmetro.block.*;

/**
 * @since beta-1
 */

public interface BlockEntityTypes
{
    RegistryObject<BlockEntityType<BlockStationNameSign1.TileEntityStationNameWall>> STATION_NAME_SIGN_ENTITY_1 = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockStationNameSign1.TileEntityStationNameWall::new, BlockList.STATION_NAME_SIGN_1.get()));
    RegistryObject<BlockEntityType<BlockStationNameSign2.TileEntityStationNameWall>> STATION_NAME_SIGN_ENTITY_2 = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockStationNameSign2.TileEntityStationNameWall::new, BlockList.STATION_NAME_SIGN_2.get()));
    RegistryObject<BlockEntityType<BlockRoadblockSign.TileEntityRoadBlockSign>> ROADBLOCK_SIGN_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockRoadblockSign.TileEntityRoadBlockSign::new, BlockList.ROADBLOCK_SIGN.get()));
    RegistryObject<BlockEntityType<BlockStationNameWallLegacy.TileEntityStationNameLegacy>> STATION_NAME_WALL_LEGACY_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockStationNameWallLegacy.TileEntityStationNameLegacy::new, BlockList.STATION_NAME_WALL_LEGACY.get()));
    RegistryObject<BlockEntityType<BlockCustomColorConcrete.CustomColorConcreteEntity>> STATION_COLOR_CONCRETE_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockCustomColorConcrete.CustomColorConcreteEntity::new, BlockList.CUSTOM_COLOR_CONCRETE.get()));
    RegistryObject<BlockEntityType<BlockCustomColorConcreteStairs.CustomColorConcreteStairsEntity>> STATION_COLOR_CONCRETE_STAIRS_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockCustomColorConcreteStairs.CustomColorConcreteStairsEntity::new, BlockList.CUSTOM_COLOR_CONCRETE_STAIRS.get()));
    RegistryObject<BlockEntityType<BlockCustomColorConcreteSlab.CustomColorConcreteSlabEntity>> STATION_COLOR_CONCRETE_SLAB_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockCustomColorConcreteSlab.CustomColorConcreteSlabEntity::new, BlockList.CUSTOM_COLOR_CONCRETE_SLAB.get()));
    RegistryObject<BlockEntityType<BlockPlayerDetector.TileEntityPlayerDetector>> PLAYER_DETECTOR_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockPlayerDetector.TileEntityPlayerDetector::new, BlockList.PLAYER_DETECTOR.get()));
    RegistryObject<BlockEntityType<BlockDecorationLight.DecorationLightEntity>> DECORATION_LIGHT_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockDecorationLight.DecorationLightEntity::new, BlockList.DECORATION_LIGHT.get()));
    RegistryObject<BlockEntityType<BlockTimeDisplay.TileEntityTimeDisplay>> TIME_DISPLAY_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockTimeDisplay.TileEntityTimeDisplay::new, BlockList.TIME_DISPLAY.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWall.TileEntityRailwaySignWall>> RAILWAY_SIGN_WALL_4_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWall.TileEntityRailwaySignWall(4, pos, state), BlockList.RAILWAY_SIGN_WALL_4.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWall.TileEntityRailwaySignWall>> RAILWAY_SIGN_WALL_6_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWall.TileEntityRailwaySignWall(6, pos, state), BlockList.RAILWAY_SIGN_WALL_6.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWall.TileEntityRailwaySignWall>> RAILWAY_SIGN_WALL_8_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWall.TileEntityRailwaySignWall(8, pos, state), BlockList.RAILWAY_SIGN_WALL_8.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWall.TileEntityRailwaySignWall>> RAILWAY_SIGN_WALL_10_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWall.TileEntityRailwaySignWall(10, pos, state), BlockList.RAILWAY_SIGN_WALL_10.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble>> RAILWAY_SIGN_WALL_DOUBLE_4_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble(4, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_4.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble>> RAILWAY_SIGN_WALL_DOUBLE_6_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble(6, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_6.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble>> RAILWAY_SIGN_WALL_DOUBLE_8_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble(8, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_8.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble>> RAILWAY_SIGN_WALL_DOUBLE_10_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallDouble.TileEntityRailwaySignWallDouble(10, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_10.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_2_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(2, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_2.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_3_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(3, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_3.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_4_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(4, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_4.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_5_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(5, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_5.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_6_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(6, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_6.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_7_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(7, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_7.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_8_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(8, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_8.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_9_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(9, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_9.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignWallBig.TileEntityRailwaySignWallBig>> RAILWAY_SIGN_WALL_BIG_10_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignWallBig.TileEntityRailwaySignWallBig(10, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_10.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_2_EVEN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(2, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_2_EVEN.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_3_EVEN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(3, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_3_EVEN.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_4_EVEN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(4, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_4_EVEN.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_5_EVEN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(5, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_5_EVEN.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_6_EVEN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(6, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_6_EVEN.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_7_EVEN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(7, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_7_EVEN.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_3_ODD_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(3, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_3_ODD.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_4_ODD_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(4, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_4_ODD.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_5_ODD_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(5, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_5_ODD.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_6_ODD_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(6, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_6_ODD.get()));
    RegistryObject<BlockEntityType<BlockRailwaySignTianjin.TileEntityRailwaySignTianjin>> RAILWAY_SIGN_TIANJIN_7_ODD_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockRailwaySignTianjin.TileEntityRailwaySignTianjin(7, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_7_ODD.get()));
    RegistryObject<BlockEntityType<BlockMetalDetectionDoor.TileEntityMetalDetectionDoor>> METAL_DETECTION_DOOR_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockMetalDetectionDoor.TileEntityMetalDetectionDoor::new, BlockList.METAL_DETECTION_DOOR.get()));
    RegistryObject<BlockEntityType<BlockBench.TileEntityBench>> BENCH_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockBench.TileEntityBench::new, BlockList.BENCH.get()));
    RegistryObject<BlockEntityType<BlockServiceCorridorSign.TileEntityServiceCorridorSign>> SERVICE_CORRIDOR_SIGN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockServiceCorridorSign.TileEntityServiceCorridorSign::new, BlockList.SERVICE_CORRIDOR_SIGN.get()));
    RegistryObject<BlockEntityType<BlockPSDDoorTianjin.TileEntityPSDTianjinDoor>> PSD_DOOR_TIANJIN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockPSDDoorTianjin.TileEntityPSDTianjinDoor::new, BlockList.PSD_DOOR_TIANJIN.get()));
    RegistryObject<BlockEntityType<BlockPSDTopTianjin.TileEntityPSDTopTianjin>> PSD_TOP_TIANJIN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType(BlockPSDTopTianjin.TileEntityPSDTopTianjin::new, BlockList.PSD_TOP_TIANJIN.get()));
    RegistryObject<BlockEntityType<BlockStationNameEntranceTianjin.TileEntityStationNameEntranceTianjin>> STATION_NAME_ENTRANCE_TIANJIN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockStationNameEntranceTianjin.TileEntityStationNameEntranceTianjin(false, pos, state), BlockList.STATION_NAME_ENTRANCE_TIANJIN.get()));
    RegistryObject<BlockEntityType<BlockStationNameEntranceTianjin.TileEntityStationNameEntranceTianjin>> STATION_NAME_ENTRANCE_TIANJIN_PINYIN_TILE_ENTITY = new RegistryObject<>(() -> RegistryUtilities.getBlockEntityType((pos, state) -> new BlockStationNameEntranceTianjin.TileEntityStationNameEntranceTianjin(true, pos, state), BlockList.STATION_NAME_ENTRANCE_TIANJIN_PINYIN.get()));
}