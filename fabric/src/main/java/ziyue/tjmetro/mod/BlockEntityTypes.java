package ziyue.tjmetro.mod;

import org.mtr.mapping.registry.BlockEntityTypeRegistryObject;
import ziyue.tjmetro.mod.block.*;

/**
 * @since 1.0.0-beta-1
 */

public interface BlockEntityTypes
{
    BlockEntityTypeRegistryObject<BlockPlayerDetector.BlockEntity> PLAYER_DETECTOR = Registry.registerBlockEntityType("player_detector", BlockPlayerDetector.BlockEntity::new, BlockList.PLAYER_DETECTOR::get);
    BlockEntityTypeRegistryObject<BlockStationNameSign1.BlockEntity> STATION_NAME_SIGN_1 = Registry.registerBlockEntityType("station_name_sign_1", BlockStationNameSign1.BlockEntity::new, BlockList.STATION_NAME_SIGN_1::get);
    BlockEntityTypeRegistryObject<BlockStationNameSign2.BlockEntity> STATION_NAME_SIGN_2 = Registry.registerBlockEntityType("station_name_sign_2", BlockStationNameSign2.BlockEntity::new, BlockList.STATION_NAME_SIGN_2::get);
    BlockEntityTypeRegistryObject<BlockTimeDisplay.BlockEntity> TIME_DISPLAY = Registry.registerBlockEntityType("time_display", BlockTimeDisplay.BlockEntity::new, BlockList.TIME_DISPLAY::get);
    BlockEntityTypeRegistryObject<BlockServiceCorridorSign.BlockEntity> SERVICE_CORRIDOR_SIGN = Registry.registerBlockEntityType("service_corridor_sign", BlockServiceCorridorSign.BlockEntity::new, BlockList.SERVICE_CORRIDOR_SIGN::get);
    BlockEntityTypeRegistryObject<BlockRoadblockSign.BlockEntity> ROADBLOCK_SIGN = Registry.registerBlockEntityType("roadblock_sign", BlockRoadblockSign.BlockEntity::new, BlockList.ROADBLOCK_SIGN::get);
    BlockEntityTypeRegistryObject<BlockCustomColorConcrete.BlockEntity> CUSTOM_COLOR_CONCRETE = Registry.registerBlockEntityType("custom_color_concrete", BlockCustomColorConcrete.BlockEntity::new, BlockList.CUSTOM_COLOR_CONCRETE::get);
    BlockEntityTypeRegistryObject<BlockCustomColorConcreteSlab.BlockEntity> CUSTOM_COLOR_CONCRETE_SLAB = Registry.registerBlockEntityType("custom_color_concrete_slab", BlockCustomColorConcreteSlab.BlockEntity::new, BlockList.CUSTOM_COLOR_CONCRETE_SLAB::get);
    BlockEntityTypeRegistryObject<BlockCustomColorConcreteStairs.BlockEntity> CUSTOM_COLOR_CONCRETE_STAIRS = Registry.registerBlockEntityType("custom_color_concrete_stairs", BlockCustomColorConcreteStairs.BlockEntity::new, BlockList.CUSTOM_COLOR_CONCRETE_STAIRS::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWall.BlockEntity> RAILWAY_SIGN_WALL_4 = Registry.registerBlockEntityType("railway_sign_wall_4", (pos, state) -> new BlockRailwaySignWall.BlockEntity(4, pos, state), BlockList.RAILWAY_SIGN_WALL_4::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWall.BlockEntity> RAILWAY_SIGN_WALL_6 = Registry.registerBlockEntityType("railway_sign_wall_6", (pos, state) -> new BlockRailwaySignWall.BlockEntity(6, pos, state), BlockList.RAILWAY_SIGN_WALL_6::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWall.BlockEntity> RAILWAY_SIGN_WALL_8 = Registry.registerBlockEntityType("railway_sign_wall_8", (pos, state) -> new BlockRailwaySignWall.BlockEntity(8, pos, state), BlockList.RAILWAY_SIGN_WALL_8::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWall.BlockEntity> RAILWAY_SIGN_WALL_10 = Registry.registerBlockEntityType("railway_sign_wall_10", (pos, state) -> new BlockRailwaySignWall.BlockEntity(10, pos, state), BlockList.RAILWAY_SIGN_WALL_10::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallDouble.BlockEntity> RAILWAY_SIGN_WALL_DOUBLE_4 = Registry.registerBlockEntityType("railway_sign_wall_double_4", (pos, state) -> new BlockRailwaySignWallDouble.BlockEntity(4, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_4::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallDouble.BlockEntity> RAILWAY_SIGN_WALL_DOUBLE_6 = Registry.registerBlockEntityType("railway_sign_wall_double_6", (pos, state) -> new BlockRailwaySignWallDouble.BlockEntity(6, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_6::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallDouble.BlockEntity> RAILWAY_SIGN_WALL_DOUBLE_8 = Registry.registerBlockEntityType("railway_sign_wall_double_8", (pos, state) -> new BlockRailwaySignWallDouble.BlockEntity(8, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_8::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallDouble.BlockEntity> RAILWAY_SIGN_WALL_DOUBLE_10 = Registry.registerBlockEntityType("railway_sign_wall_double_10", (pos, state) -> new BlockRailwaySignWallDouble.BlockEntity(10, pos, state), BlockList.RAILWAY_SIGN_WALL_DOUBLE_10::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_2 = Registry.registerBlockEntityType("railway_sign_wall_big_2", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(2, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_2::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_3 = Registry.registerBlockEntityType("railway_sign_wall_big_3", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(3, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_3::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_4 = Registry.registerBlockEntityType("railway_sign_wall_big_4", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(4, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_4::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_5 = Registry.registerBlockEntityType("railway_sign_wall_big_5", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(5, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_5::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_6 = Registry.registerBlockEntityType("railway_sign_wall_big_6", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(6, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_6::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_7 = Registry.registerBlockEntityType("railway_sign_wall_big_7", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(7, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_7::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_8 = Registry.registerBlockEntityType("railway_sign_wall_big_8", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(8, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_8::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_9 = Registry.registerBlockEntityType("railway_sign_wall_big_9", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(9, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_9::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignWallBig.BlockEntity> RAILWAY_SIGN_WALL_BIG_10 = Registry.registerBlockEntityType("railway_sign_wall_big_10", (pos, state) -> new BlockRailwaySignWallBig.BlockEntity(10, pos, state), BlockList.RAILWAY_SIGN_WALL_BIG_10::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_3_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_3_odd", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(3, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_3_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_4_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_4_odd", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(4, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_4_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_5_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_5_odd", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(5, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_5_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_6_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_6_odd", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(6, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_6_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_7_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_7_odd", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(7, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_7_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_2_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_2_even", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(2, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_2_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_3_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_3_even", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(3, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_3_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_4_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_4_even", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(4, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_4_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_5_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_5_even", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(5, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_5_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_6_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_6_even", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(6, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_6_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjin.BlockEntity> RAILWAY_SIGN_TIANJIN_7_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_7_even", (pos, state) -> new BlockRailwaySignTianjin.BlockEntity(7, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_7_EVEN::get);
    BlockEntityTypeRegistryObject<BlockStationNameEntranceTianjin.BlockEntity> STATION_NAME_ENTRANCE_TIANJIN = Registry.registerBlockEntityType("station_name_entrance_tianjin", (pos, state) -> new BlockStationNameEntranceTianjin.BlockEntity(false, false, pos, state), BlockList.STATION_NAME_ENTRANCE_TIANJIN::get);
    BlockEntityTypeRegistryObject<BlockStationNameEntranceTianjin.BlockEntity> STATION_NAME_ENTRANCE_TIANJIN_PINYIN = Registry.registerBlockEntityType("station_name_entrance_tianjin_pinyin", (pos, state) -> new BlockStationNameEntranceTianjin.BlockEntity(true, false, pos, state), BlockList.STATION_NAME_ENTRANCE_TIANJIN_PINYIN::get);
    BlockEntityTypeRegistryObject<BlockStationNameEntranceTianjin.BlockEntity> STATION_NAME_ENTRANCE_TIANJIN_BMT = Registry.registerBlockEntityType("station_name_entrance_tianjin_bmt", (pos, state) -> new BlockStationNameEntranceTianjin.BlockEntity(false, true, pos, state), BlockList.STATION_NAME_ENTRANCE_TIANJIN_BMT::get);
    BlockEntityTypeRegistryObject<BlockStationNameEntranceTianjin.BlockEntity> STATION_NAME_ENTRANCE_TIANJIN_BMT_PINYIN = Registry.registerBlockEntityType("station_name_entrance_tianjin_bmt_pinyin", (pos, state) -> new BlockStationNameEntranceTianjin.BlockEntity(true, true, pos, state), BlockList.STATION_NAME_ENTRANCE_TIANJIN_BMT_PINYIN::get);
    BlockEntityTypeRegistryObject<BlockPSDDoorTianjin.BlockEntity> PSD_DOOR_TIANJIN = Registry.registerBlockEntityType("psd_door_tianjin", BlockPSDDoorTianjin.BlockEntity::new, BlockList.PSD_DOOR_TIANJIN_BLOCK::get);
    BlockEntityTypeRegistryObject<BlockPSDTopTianjin.BlockEntity> PSD_TOP_TIANJIN = Registry.registerBlockEntityType("psd_top_tianjin", BlockPSDTopTianjin.BlockEntity::new, BlockList.PSD_TOP_TIANJIN::get);
    BlockEntityTypeRegistryObject<BlockStationNameWallLegacy.BlockEntity> STATION_NAME_WALL_LEGACY = Registry.registerBlockEntityType("station_name_wall_legacy", BlockStationNameWallLegacy.BlockEntity::new, BlockList.STATION_NAME_WALL_LEGACY::get);
    BlockEntityTypeRegistryObject<BlockStationNamePlate.BlockEntity> STATION_NAME_PLATE = Registry.registerBlockEntityType("station_name_plate", BlockStationNamePlate.BlockEntity::new, BlockList.STATION_NAME_PLATE::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_2_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_2_odd", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(2, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_2_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_3_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_3_odd", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(3, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_3_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_4_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_4_odd", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(4, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_4_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_5_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_5_odd", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(5, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_5_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_6_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_6_odd", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(6, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_6_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_7_ODD = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_7_odd", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(7, true, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_7_ODD::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_2_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_2_even", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(2, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_2_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_3_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_3_even", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(3, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_3_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_4_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_4_even", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(4, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_4_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_5_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_5_even", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(5, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_5_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_6_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_6_even", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(6, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_6_EVEN::get);
    BlockEntityTypeRegistryObject<BlockRailwaySignTianjinBMT.BlockEntity> RAILWAY_SIGN_TIANJIN_BMT_7_EVEN = Registry.registerBlockEntityType("railway_sign_tianjin_bmt_7_even", (pos, state) -> new BlockRailwaySignTianjinBMT.BlockEntity(7, false, pos, state), BlockList.RAILWAY_SIGN_TIANJIN_BMT_7_EVEN::get);
    BlockEntityTypeRegistryObject<BlockAPGDoorTianjin.BlockEntity> APG_DOOR_TIANJIN = Registry.registerBlockEntityType("apg_door_tianjin", BlockAPGDoorTianjin.BlockEntity::new, BlockList.APG_DOOR_TIANJIN_BLOCK::get);
    BlockEntityTypeRegistryObject<BlockAPGDoorTianjinBMT.BlockEntity> APG_DOOR_TIANJIN_BMT = Registry.registerBlockEntityType("apg_door_tianjin_bmt", BlockAPGDoorTianjinBMT.BlockEntity::new, BlockList.APG_DOOR_TIANJIN_BMT_BLOCK::get);
    BlockEntityTypeRegistryObject<BlockAPGGlassTianjinBMT.BlockEntity> APG_GLASS_TIANJIN_BMT = Registry.registerBlockEntityType("apg_glass_tianjin_bmt", BlockAPGGlassTianjinBMT.BlockEntity::new, BlockList.APG_GLASS_TIANJIN_BMT_BLOCK::get);
    BlockEntityTypeRegistryObject<BlockMetalPoleBMT.BlockEntity> METAL_POLE_BMT = Registry.registerBlockEntityType("metal_pole_bmt", BlockMetalPoleBMT.BlockEntity::new, BlockList.METAL_POLE_BMT::get);
    BlockEntityTypeRegistryObject<BlockPSDDoorTianjinBMT.BlockEntity> PSD_DOOR_TIANJIN_BMT = Registry.registerBlockEntityType("psd_door_tianjin_bmt", BlockPSDDoorTianjinBMT.BlockEntity::new, BlockList.PSD_DOOR_TIANJIN_BMT_BLOCK::get);
    BlockEntityTypeRegistryObject<BlockPSDTopTianjinBMT.BlockEntity> PSD_TOP_TIANJIN_BMT = Registry.registerBlockEntityType("psd_top_tianjin_bmt", BlockPSDTopTianjinBMT.BlockEntity::new, BlockList.PSD_TOP_TIANJIN_BMT::get);
    BlockEntityTypeRegistryObject<BlockMetalDetectionDoor.BlockEntity> METAL_DETECTION_DOOR = Registry.registerBlockEntityType("metal_detection_door", BlockMetalDetectionDoor.BlockEntity::new, BlockList.METAL_DETECTION_DOOR::get);
    BlockEntityTypeRegistryObject<BlockAPGDoorTianjinTRT.BlockEntity> APG_DOOR_TIANJIN_TRT = Registry.registerBlockEntityType("apg_door_tianjin_trt", BlockAPGDoorTianjinTRT.BlockEntity::new, BlockList.APG_DOOR_TIANJIN_TRT_BLOCK::get);
    BlockEntityTypeRegistryObject<BlockAPGGlassTianjinTRT.BlockEntity> APG_GLASS_TIANJIN_TRT = Registry.registerBlockEntityType("apg_glass_tianjin_trt", BlockAPGGlassTianjinTRT.BlockEntity::new, BlockList.APG_GLASS_TIANJIN_TRT_BLOCK::get);

    static void registerBlockEntities() {
        // Calling this class to initialize constants
        TianjinMetro.LOGGER.info("Registering block entities");
    }
}
