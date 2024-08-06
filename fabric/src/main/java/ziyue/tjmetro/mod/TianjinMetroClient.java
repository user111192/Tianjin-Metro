package ziyue.tjmetro.mod;

import org.mtr.mapping.holder.MinecraftClient;
import org.mtr.mapping.holder.RenderLayer;
import org.mtr.mapping.holder.Screen;
import org.mtr.mapping.mapper.TextHelper;
import org.mtr.mod.Blocks;
import org.mtr.mod.Items;
import org.mtr.mod.render.RenderAPGGlass;
import org.mtr.mod.render.RenderPSDAPGDoor;
import ziyue.tjmetro.mod.client.Filters;
import ziyue.tjmetro.mod.config.ConfigClient;
import ziyue.tjmetro.mapping.FilterBuilder;
import ziyue.tjmetro.mod.render.*;
import ziyue.tjmetro.mod.screen.ConfigClientScreen;

public final class TianjinMetroClient
{
    public static void init() {
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.LOGO);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.STATION_NAME_SIGN_1);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.STATION_NAME_SIGN_2);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.APG_CORNER);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.PLATFORM_TJ_1);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.PLATFORM_TJ_1_INDENTED);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.PLATFORM_TJ_2);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.PLATFORM_TJ_2_INDENTED);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.EMERGENCY_EXIT_SIGN);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.SERVICE_CORRIDOR_SIGN);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.PSD_DOOR_TIANJIN);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.PSD_GLASS_TIANJIN);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.PSD_GLASS_END_TIANJIN);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.APG_DOOR_TIANJIN);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.APG_GLASS_TIANJIN);
        RegistryClient.registerBlockRenderType(RenderLayer.getCutout(), BlockList.APG_GLASS_END_TIANJIN);
        RegistryClient.registerBlockRenderType(RenderLayer.getTranslucent(), BlockList.ROLLING);

        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_SIGN_1, RenderStationNameSign::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_SIGN_2, RenderStationNameSign::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.TIME_DISPLAY, RenderTimeDisplay::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.SERVICE_CORRIDOR_SIGN, RenderServiceCorridorSign::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.ROADBLOCK_SIGN, RenderRoadblockSign::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_4, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_6, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_8, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_10, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_2, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_3, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_4, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_5, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_6, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_7, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_8, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_9, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_BIG_10, RenderRailwaySignWall::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_3_ODD, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_4_ODD, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_5_ODD, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_6_ODD, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_7_ODD, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_2_EVEN, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_3_EVEN, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_4_EVEN, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_5_EVEN, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_6_EVEN, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_7_EVEN, RenderRailwaySignTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_DOUBLE_4, RenderRailwaySignWallDouble::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_DOUBLE_6, RenderRailwaySignWallDouble::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_DOUBLE_8, RenderRailwaySignWallDouble::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_WALL_DOUBLE_10, RenderRailwaySignWallDouble::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_ENTRANCE_TIANJIN, RenderStationNameEntranceTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_ENTRANCE_TIANJIN_PINYIN, RenderStationNameEntranceTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_ENTRANCE_TIANJIN_BMT, RenderStationNameEntranceTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_ENTRANCE_TIANJIN_BMT_PINYIN, RenderStationNameEntranceTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.PSD_TOP_TIANJIN, RenderPSDTopTianjin::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.PSD_DOOR_TIANJIN, dispatcher -> new RenderPSDAPGDoor<>(dispatcher, 0));
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_WALL_LEGACY, RenderStationNameWallLegacy::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.STATION_NAME_PLATE, RenderStationNamePlate::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_2_ODD, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_3_ODD, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_4_ODD, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_5_ODD, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_6_ODD, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_7_ODD, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_2_EVEN, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_3_EVEN, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_4_EVEN, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_5_EVEN, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_6_EVEN, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.RAILWAY_SIGN_TIANJIN_BMT_7_EVEN, RenderRailwaySignTianjinBMT::new);
        RegistryClient.registerBlockEntityRenderer(BlockEntityTypes.APG_DOOR_TIANJIN, dispatcher -> new RenderPSDAPGDoor<>(dispatcher, 2));

        RegistryClient.registerEntityRenderer(EntityTypes.SEAT, RenderSeat::new);

        RegistryClient.registerBlockStationColor(BlockList.STATION_COLOR_CEILING, BlockList.STATION_COLOR_CEILING_LIGHT, BlockList.STATION_COLOR_CEILING_NO_LIGHT, BlockList.STATION_COLOR_CEILING_NOT_LIT);
        RegistryClient.registerBlockStationColor(BlockList.STATION_NAME_SIGN_1);
        RegistryClient.registerBlockCustomColor(BlockList.CUSTOM_COLOR_CONCRETE, BlockList.CUSTOM_COLOR_CONCRETE_SLAB, BlockList.CUSTOM_COLOR_CONCRETE_STAIRS);
        RegistryClient.registerBlockCustomColor(BlockList.METAL_POLE_BMT);
        RegistryClient.registerItemCustomColor(0xfff100, BlockList.METAL_POLE_BMT.get().asItem());

        RegistryClient.setupPackets("packet");

        RegistryClient.REGISTRY_CLIENT.init();

        FilterBuilder.setReservedButton(TianjinMetro.CREATIVE_MODE_TAB, TextHelper.translatable("button.tjmetro.tianjin_metro_options"), button ->
                MinecraftClient.getInstance().openScreen(new Screen(new ConfigClientScreen(MinecraftClient.getInstance().getCurrentScreenMapped()))));
        
        ConfigClient.refreshProperties();
    }
}
