package ziyue.tjmetro.mod;

import org.mtr.mapping.holder.Block;
import org.mtr.mapping.holder.SlabBlock;
import org.mtr.mapping.mapper.BlockHelper;
import org.mtr.mapping.mapper.SlabBlockExtension;
import org.mtr.mapping.mapper.StairsBlockExtension;
import org.mtr.mapping.registry.BlockRegistryObject;
import org.mtr.mod.block.BlockCeiling;
import org.mtr.mod.block.BlockPlatform;
import org.mtr.mod.block.BlockRailwaySign;
import org.mtr.mod.block.BlockStationColor;
import org.mtr.mod.item.ItemBlockEnchanted;
import ziyue.tjmetro.mod.block.*;
import ziyue.tjmetro.mod.block.base.StairBlock;

import static ziyue.tjmetro.mod.client.Filters.*;

public interface BlockList
{
    BlockRegistryObject LOGO = Registry.registerBlockWithBlockItem("logo", () -> new Block(new BlockLogo()), DECORATION);
    BlockRegistryObject PLAYER_DETECTOR = Registry.registerBlockWithBlockItem("player_detector", () -> new Block(new BlockPlayerDetector()), MISCELLANEOUS);
    BlockRegistryObject ROLLING = Registry.registerBlockWithBlockItem("rolling", () -> new Block(new BlockRolling()), BUILDING);
    BlockRegistryObject CEILING_NOT_LIT = Registry.registerBlockWithBlockItem("ceiling_not_lit", () -> new Block(new BlockCeiling(BlockHelper.createBlockSettings(false))), CEILINGS);
    BlockRegistryObject STATION_COLOR_CEILING = Registry.registerBlockWithBlockItem("station_color_ceiling", () -> new Block(new BlockStationColorCeilingAuto()), ItemBlockEnchanted::new, CEILINGS);
    BlockRegistryObject STATION_COLOR_CEILING_LIGHT = Registry.registerBlockWithBlockItem("station_color_ceiling_light", () -> new Block(new BlockStationColorCeiling()), ItemBlockEnchanted::new, CEILINGS);
    BlockRegistryObject STATION_COLOR_CEILING_NO_LIGHT = Registry.registerBlockWithBlockItem("station_color_ceiling_no_light", () -> new Block(new BlockStationColorCeiling()), ItemBlockEnchanted::new, CEILINGS);
    BlockRegistryObject STATION_COLOR_CEILING_NOT_LIT = Registry.registerBlockWithBlockItem("station_color_ceiling_not_lit", () -> new Block(new BlockStationColorCeiling(BlockHelper.createBlockSettings(false))), ItemBlockEnchanted::new, CEILINGS);
    BlockRegistryObject STATION_NAME_SIGN_1 = Registry.registerBlockWithBlockItem("station_name_sign_1", () -> new Block(new BlockStationNameSign1()), SIGNS);
    BlockRegistryObject STATION_NAME_SIGN_2 = Registry.registerBlockWithBlockItem("station_name_sign_2", () -> new Block(new BlockStationNameSign2()), SIGNS);
    BlockRegistryObject APG_CORNER = Registry.registerBlockWithBlockItem("apg_corner", () -> new Block(new BlockAPGCorner()), DECORATION);
    BlockRegistryObject PLATFORM_TJ_1 = Registry.registerBlockWithBlockItem("platform_tj_1", () -> new Block(new BlockPlatform(BlockHelper.createBlockSettings(false), false)), BUILDING);
    BlockRegistryObject PLATFORM_TJ_1_INDENTED = Registry.registerBlockWithBlockItem("platform_tj_1_indented", () -> new Block(new BlockPlatform(BlockHelper.createBlockSettings(false), true)), BUILDING);
    BlockRegistryObject PLATFORM_TJ_2 = Registry.registerBlockWithBlockItem("platform_tj_2", () -> new Block(new BlockPlatform(BlockHelper.createBlockSettings(false), false)), BUILDING);
    BlockRegistryObject PLATFORM_TJ_2_INDENTED = Registry.registerBlockWithBlockItem("platform_tj_2_indented", () -> new Block(new BlockPlatform(BlockHelper.createBlockSettings(false), true)), BUILDING);
    BlockRegistryObject MARBLE_GRAY = Registry.registerBlockWithBlockItem("marble_gray", () -> new Block(BlockHelper.createBlockSettings(false)), BUILDING);
    BlockRegistryObject MARBLE_GRAY_SLAB = Registry.registerBlockWithBlockItem("marble_gray_slab", () -> new Block(new SlabBlockExtension(BlockHelper.createBlockSettings(false))), BUILDING);
    BlockRegistryObject MARBLE_GRAY_STAIRS = Registry.registerBlockWithBlockItem("marble_gray_stairs", () -> new Block(new StairBlock(MARBLE_GRAY)), BUILDING);
    BlockRegistryObject MARBLE_YELLOW = Registry.registerBlockWithBlockItem("marble_yellow", () -> new Block(BlockHelper.createBlockSettings(false)), BUILDING);
    BlockRegistryObject MARBLE_YELLOW_SLAB = Registry.registerBlockWithBlockItem("marble_yellow_slab", () -> new Block(new SlabBlockExtension(BlockHelper.createBlockSettings(false))), BUILDING);
    BlockRegistryObject MARBLE_YELLOW_STAIRS = Registry.registerBlockWithBlockItem("marble_yellow_stairs", () -> new Block(new StairBlock(MARBLE_YELLOW)), BUILDING);
    BlockRegistryObject TIME_DISPLAY = Registry.registerBlockWithBlockItem("time_display", () -> new Block(new BlockTimeDisplay()), DECORATION);
    BlockRegistryObject EMERGENCY_EXIT_SIGN = Registry.registerBlockWithBlockItem("emergency_exit_sign", () -> new Block(new BlockEmergencyExitSign()), DECORATION);
    BlockRegistryObject SERVICE_CORRIDOR_SIGN = Registry.registerBlockWithBlockItem("service_corridor_sign", () -> new Block(new BlockServiceCorridorSign()), DECORATION);
    BlockRegistryObject ROADBLOCK = Registry.registerBlockWithBlockItem("roadblock", () -> new Block(new BlockRoadblock()), BUILDING);
    BlockRegistryObject ROADBLOCK_SIGN = Registry.registerBlockWithBlockItem("roadblock_sign", () -> new Block(new BlockRoadblockSign()), BUILDING);
    BlockRegistryObject BENCH = Registry.registerBlockWithBlockItem("bench", () -> new Block(new BlockBench()), DECORATION);
    BlockRegistryObject CUSTOM_COLOR_CONCRETE = Registry.registerBlockWithBlockItem("custom_color_concrete", () -> new Block(new BlockCustomColorConcrete()), ItemBlockEnchanted::new, BUILDING);
    BlockRegistryObject CUSTOM_COLOR_CONCRETE_SLAB = Registry.registerBlockWithBlockItem("custom_color_concrete_slab", () -> new Block(new BlockCustomColorConcreteSlab()), ItemBlockEnchanted::new, BUILDING);
    BlockRegistryObject CUSTOM_COLOR_CONCRETE_STAIRS = Registry.registerBlockWithBlockItem("custom_color_concrete_stairs", () -> new Block(new BlockCustomColorConcreteStairs()), ItemBlockEnchanted::new, BUILDING);
    BlockRegistryObject RAILWAY_SIGN_WALL_4 = Registry.registerBlockWithBlockItem("railway_sign_wall_4", () -> new Block(new BlockRailwaySignWall(4)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_6 = Registry.registerBlockWithBlockItem("railway_sign_wall_6", () -> new Block(new BlockRailwaySignWall(6)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_8 = Registry.registerBlockWithBlockItem("railway_sign_wall_8", () -> new Block(new BlockRailwaySignWall(8)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_10 = Registry.registerBlockWithBlockItem("railway_sign_wall_10", () -> new Block(new BlockRailwaySignWall(10)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_MIDDLE = Registry.registerBlock("railway_sign_wall_middle", () -> new Block(new BlockRailwaySignWall(0)));
    BlockRegistryObject RAILWAY_SIGN_WALL_DOUBLE_4 = Registry.registerBlockWithBlockItem("railway_sign_wall_double_4", () -> new Block(new BlockRailwaySignWallDouble(4)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_DOUBLE_6 = Registry.registerBlockWithBlockItem("railway_sign_wall_double_6", () -> new Block(new BlockRailwaySignWallDouble(6)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_DOUBLE_8 = Registry.registerBlockWithBlockItem("railway_sign_wall_double_8", () -> new Block(new BlockRailwaySignWallDouble(8)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_DOUBLE_10 = Registry.registerBlockWithBlockItem("railway_sign_wall_double_10", () -> new Block(new BlockRailwaySignWallDouble(10)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_DOUBLE_MIDDLE = Registry.registerBlock("railway_sign_wall_double_middle", () -> new Block(new BlockRailwaySignWallDouble(0)));
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_2 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_2", () -> new Block(new BlockRailwaySignWallBig(2)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_3 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_3", () -> new Block(new BlockRailwaySignWallBig(3)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_4 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_4", () -> new Block(new BlockRailwaySignWallBig(4)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_5 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_5", () -> new Block(new BlockRailwaySignWallBig(5)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_6 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_6", () -> new Block(new BlockRailwaySignWallBig(6)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_7 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_7", () -> new Block(new BlockRailwaySignWallBig(7)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_8 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_8", () -> new Block(new BlockRailwaySignWallBig(8)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_9 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_9", () -> new Block(new BlockRailwaySignWallBig(9)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_10 = Registry.registerBlockWithBlockItem("railway_sign_wall_big_10", () -> new Block(new BlockRailwaySignWallBig(10)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_WALL_BIG_MIDDLE = Registry.registerBlock("railway_sign_wall_big_middle", () -> new Block(new BlockRailwaySignWallBig(0)));
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_3_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_3_odd", () -> new Block(new BlockRailwaySignTianjin(3, true)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_4_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_4_odd", () -> new Block(new BlockRailwaySignTianjin(4, true)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_5_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_5_odd", () -> new Block(new BlockRailwaySignTianjin(5, true)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_6_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_6_odd", () -> new Block(new BlockRailwaySignTianjin(6, true)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_7_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_7_odd", () -> new Block(new BlockRailwaySignTianjin(7, true)), RAILWAY_SIGNS);
//    BlockRegistryObject RAILWAY_SIGN_TIANJIN_8_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_8_odd", () -> new Block(new BlockRailwaySignTianjin(8, true)), SIGNS);
//    BlockRegistryObject RAILWAY_SIGN_TIANJIN_9_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_9_odd", () -> new Block(new BlockRailwaySignTianjin(9, true)), SIGNS);
//    BlockRegistryObject RAILWAY_SIGN_TIANJIN_10_ODD = Registry.registerBlockWithBlockItem("railway_sign_tianjin_10_odd", () -> new Block(new BlockRailwaySignTianjin(10, true)), SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_2_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_2_even", () -> new Block(new BlockRailwaySignTianjin(2, false)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_3_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_3_even", () -> new Block(new BlockRailwaySignTianjin(3, false)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_4_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_4_even", () -> new Block(new BlockRailwaySignTianjin(4, false)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_5_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_5_even", () -> new Block(new BlockRailwaySignTianjin(5, false)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_6_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_6_even", () -> new Block(new BlockRailwaySignTianjin(6, false)), RAILWAY_SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_7_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_7_even", () -> new Block(new BlockRailwaySignTianjin(7, false)), RAILWAY_SIGNS);
//    BlockRegistryObject RAILWAY_SIGN_TIANJIN_8_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_8_even", () -> new Block(new BlockRailwaySignTianjin(8, false)), SIGNS);
//    BlockRegistryObject RAILWAY_SIGN_TIANJIN_9_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_9_even", () -> new Block(new BlockRailwaySignTianjin(9, false)), SIGNS);
//    BlockRegistryObject RAILWAY_SIGN_TIANJIN_10_EVEN = Registry.registerBlockWithBlockItem("railway_sign_tianjin_10_even", () -> new Block(new BlockRailwaySignTianjin(10, false)), SIGNS);
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_MIDDLE = Registry.registerBlock("railway_sign_tianjin_middle", () -> new Block(new BlockRailwaySignTianjin(0, false)));
    BlockRegistryObject RAILWAY_SIGN_TIANJIN_POLE = Registry.registerBlockWithBlockItem("railway_sign_tianjin_pole", () -> new Block(new BlockRailwaySignTianjinPole()), RAILWAY_SIGNS);
    BlockRegistryObject STATION_NAME_ENTRANCE_TIANJIN = Registry.registerBlockWithBlockItem("station_name_entrance_tianjin", () -> new Block(new BlockStationNameEntranceTianjin(false, false)), SIGNS);
    BlockRegistryObject STATION_NAME_ENTRANCE_TIANJIN_PINYIN = Registry.registerBlockWithBlockItem("station_name_entrance_tianjin_pinyin", () -> new Block(new BlockStationNameEntranceTianjin(true, false)), SIGNS);
    BlockRegistryObject STATION_NAME_ENTRANCE_TIANJIN_BMT = Registry.registerBlockWithBlockItem("station_name_entrance_tianjin_bmt", () -> new Block(new BlockStationNameEntranceTianjin(false, true)), SIGNS);
    BlockRegistryObject STATION_NAME_ENTRANCE_TIANJIN_BMT_PINYIN = Registry.registerBlockWithBlockItem("station_name_entrance_tianjin_bmt_pinyin", () -> new Block(new BlockStationNameEntranceTianjin(true, true)), SIGNS);
    BlockRegistryObject PSD_DOOR_TIANJIN = Registry.registerBlock("psd_door_tianjin", () -> new Block(new BlockPSDDoorTianjin()));
    BlockRegistryObject PSD_GLASS_TIANJIN = Registry.registerBlock("psd_glass_tianjin", () -> new Block(new BlockPSDGlassTianjin()));
    BlockRegistryObject PSD_GLASS_END_TIANJIN = Registry.registerBlock("psd_glass_end_tianjin", () -> new Block(new BlockPSDGlassEndTianjin()));
    BlockRegistryObject PSD_TOP_TIANJIN = Registry.registerBlock("psd_top_tianjin", () -> new Block(new BlockPSDTopTianjin()));
    BlockRegistryObject METAL_DETECTION_DOOR = Registry.registerBlockWithBlockItem("metal_detection_door", () -> new Block(new BlockMetalDetectionDoor()), DECORATION);
//    BlockRegistryObject HIGH_SPEED_REPEATER = Registry.registerBlockWithBlockItem("high_speed_repeater", () -> new Block(new BlockHighSpeedRepeater()), MISCELLANEOUS);

    static void registerBlocks() {
        // Calling this class to initialize constants
        TianjinMetro.LOGGER.info("Registering blocks");
    }
}
