package ziyue.tjmetro.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import mtr.MTR;
import mtr.block.BlockRailwaySign;
import mtr.client.ClientCache;
import mtr.client.ClientData;
import mtr.client.CustomResources;
import mtr.client.IDrawing;
import mtr.data.*;
import mtr.mappings.ScreenMapper;
import mtr.mappings.Text;
import mtr.mappings.UtilitiesClient;
import mtr.render.RenderRailwaySign;
import mtr.screen.DashboardListSelectorScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntity;
import ziyue.tjmetro.TianjinMetro;
import ziyue.tjmetro.block.base.BlockRailwaySignBase;
import ziyue.tjmetro.packet.PacketGuiServer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZiYueCommentary
 * @see mtr.screen.RailwaySignScreen
 * @see BlockRailwaySignBase
 * @since beta-1
 */

public class RailwaySignScreen extends ScreenMapper implements IGui
{
    protected int editingIndex;
    protected int page;
    protected int totalPages;
    protected int columns;
    protected int rows;

    protected final BlockPos signPos;
    protected final boolean isRailwaySign;
    protected final int length;
    protected final String[] signIds;
    protected final Set<Long> selectedIds;
    protected final List<NameColorDataBase> exitsForList = new ArrayList<>();
    protected final List<NameColorDataBase> platformsForList = new ArrayList<>();
    protected final List<NameColorDataBase> routesForList = new ArrayList<>();
    protected final List<String> allSignIds = new ArrayList<>();

    protected final Button[] buttonsEdit;
    protected final Button[] buttonsSelection;
    protected final Button buttonClear;
    protected final ImageButton buttonPrevPage;
    protected final ImageButton buttonNextPage;

    protected static final int SIGN_SIZE = 32;
    protected static final int SIGN_BUTTON_SIZE = 16;
    protected static final int BUTTON_Y_START = SIGN_SIZE + SQUARE_SIZE + SQUARE_SIZE / 2;

    public RailwaySignScreen(BlockPos signPos) {
        super(Text.literal(""));
        editingIndex = -1;
        this.signPos = signPos;
        final ClientLevel world = Minecraft.getInstance().level;

        for (final BlockRailwaySign.SignType signType : BlockRailwaySign.SignType.values()) {
            allSignIds.add(signType.toString());
        }
        final List<String> sortedKeys = new ArrayList<>(CustomResources.CUSTOM_SIGNS.keySet());
        Collections.sort(sortedKeys);
        allSignIds.addAll(sortedKeys);

        try {
            final Station station = RailwayData.getStation(ClientData.STATIONS, ClientData.DATA_CACHE, signPos);
            if (station != null) {
                final Map<String, List<String>> exits = station.getGeneratedExits();
                final List<String> exitParents = new ArrayList<>(exits.keySet());
                exitParents.sort(String::compareTo);
                exitParents.forEach(exitParent -> {
                    final List<String> destinations = exits.get(exitParent);
                    exitsForList.add(new DataConverter(Station.serializeExit(exitParent), exitParent + " " + (!destinations.isEmpty() ? destinations.get(0) : ""), 0));
                });

                final List<Platform> platforms = new ArrayList<>(ClientData.DATA_CACHE.requestStationIdToPlatforms(station.id).values());
                Collections.sort(platforms);
                platforms.stream().map(platform -> new DataConverter(platform.id, platform.name + " " + IGui.mergeStations(ClientData.DATA_CACHE.requestPlatformIdToRoutes(platform.id).stream().map(route -> route.stationDetails.get(route.stationDetails.size() - 1).stationName).collect(Collectors.toList())), 0)).forEach(platformsForList::add);

                final Map<Integer, ClientCache.ColorNameTuple> routeMap = ClientData.DATA_CACHE.stationIdToRoutes.get(station.id);
                routeMap.forEach((color, route) -> routesForList.add(new DataConverter(route.color, route.name, route.color)));
            }
        } catch (Exception e) {
            if (ClientData.DATA_CACHE.stationIdToRoutes.get(RailwayData.getStation(ClientData.STATIONS, ClientData.DATA_CACHE, signPos).id) == null)
                TianjinMetro.LOGGER.warn("Position [" + signPos.toShortString() + "] has no station/routes!");
            else
                TianjinMetro.LOGGER.error(e);
        }

        if (world != null) {
            final BlockEntity entity = world.getBlockEntity(signPos);
            if (entity instanceof BlockRailwaySignBase.TileEntityRailwaySign entityRailwaySign) {
                signIds = entityRailwaySign.getSignIds();
                selectedIds = entityRailwaySign.getSelectedIds();
                isRailwaySign = true;
            } else {
                signIds = new String[0];
                selectedIds = new HashSet<>();
                isRailwaySign = false;
            }
            if (world.getBlockState(signPos).getBlock() instanceof BlockRailwaySignBase) {
                length = ((BlockRailwaySignBase) world.getBlockState(signPos).getBlock()).length;
            } else {
                length = 0;
            }
        } else {
            length = 0;
            signIds = new String[0];
            selectedIds = new HashSet<>();
            isRailwaySign = false;
        }

        buttonsEdit = new Button[length];
        for (int i = 0; i < buttonsEdit.length; i++) {
            final int index = i;
            buttonsEdit[i] = new Button(0, 0, 0, SQUARE_SIZE, Text.translatable("selectWorld.edit"), button -> edit(index));
        }

        buttonsSelection = new Button[allSignIds.size()];
        for (int i = 0; i < allSignIds.size(); i++) {
            final int index = i;
            buttonsSelection[i] = new Button(0, 0, 0, SIGN_BUTTON_SIZE, Text.literal(""), button -> setNewSignId(allSignIds.get(index)));
        }

        buttonClear = new Button(0, 0, 0, SQUARE_SIZE, Text.translatable("gui.mtr.reset_sign"), button -> setNewSignId(null));
        buttonPrevPage = new ImageButton(0, 0, 0, SQUARE_SIZE, 0, 0, 20, new ResourceLocation(MTR.MOD_ID, "textures/gui/icon_left.png"), 20, 40, button -> setPage(page - 1));
        buttonNextPage = new ImageButton(0, 0, 0, SQUARE_SIZE, 0, 0, 20, new ResourceLocation(MTR.MOD_ID, "textures/gui/icon_right.png"), 20, 40, button -> setPage(page + 1));
    }

    @Override
    protected void init() {
        super.init();

        for (int i = 0; i < buttonsEdit.length; i++) {
            IDrawing.setPositionAndWidth(buttonsEdit[i], (width - SIGN_SIZE * length) / 2 + i * SIGN_SIZE, SIGN_SIZE, SIGN_SIZE);
            addDrawableChild(buttonsEdit[i]);
        }

        columns = Math.max((width - SIGN_BUTTON_SIZE * 3) / (SIGN_BUTTON_SIZE * 8) * 2, 1);
        rows = Math.max((height - SIGN_SIZE - SQUARE_SIZE * 4) / SIGN_BUTTON_SIZE, 1);

        final int xOffsetSmall = (width - SIGN_BUTTON_SIZE * (columns * 4 + 3)) / 2 + SIGN_BUTTON_SIZE;
        final int xOffsetBig = xOffsetSmall + SIGN_BUTTON_SIZE * (columns + 1);

        totalPages = loopSigns((index, x, y, isBig) -> {
            IDrawing.setPositionAndWidth(buttonsSelection[index], (isBig ? xOffsetBig : xOffsetSmall) + x, BUTTON_Y_START + y, isBig ? SIGN_BUTTON_SIZE * 3 : SIGN_BUTTON_SIZE);
            buttonsSelection[index].visible = false;
            addDrawableChild(buttonsSelection[index]);
        }, true);

        final int buttonClearX = (width - PANEL_WIDTH - SQUARE_SIZE * 4) / 2;
        final int buttonY = height - SQUARE_SIZE * 2;

        IDrawing.setPositionAndWidth(buttonClear, buttonClearX, buttonY, PANEL_WIDTH);
        buttonClear.visible = false;
        addDrawableChild(buttonClear);

        IDrawing.setPositionAndWidth(buttonPrevPage, buttonClearX + PANEL_WIDTH, buttonY, SQUARE_SIZE);
        buttonPrevPage.visible = false;
        addDrawableChild(buttonPrevPage);
        IDrawing.setPositionAndWidth(buttonNextPage, buttonClearX + PANEL_WIDTH + SQUARE_SIZE * 3, buttonY, SQUARE_SIZE);
        buttonNextPage.visible = false;
        addDrawableChild(buttonNextPage);

        if (!isRailwaySign && minecraft != null) {
            UtilitiesClient.setScreen(minecraft, new DashboardListSelectorScreen(this::onClose, exitsForList, selectedIds, true, false));
        }
    }

    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        try {
            renderBackground(matrices);
            super.render(matrices, mouseX, mouseY, delta);
            if (minecraft == null) {
                return;
            }

            for (int i = 0; i < signIds.length; i++) {
                if (signIds[i] != null) {
                    RenderRailwaySign.drawSign(matrices, null, null, font, signPos, signIds[i], (width - SIGN_SIZE * length) / 2F + i * SIGN_SIZE, 0, SIGN_SIZE, RenderRailwaySign.getMaxWidth(signIds, i, false), RenderRailwaySign.getMaxWidth(signIds, i, true), selectedIds, Direction.UP, 0, (textureId, x, y, size, flipTexture) -> {
                        UtilitiesClient.beginDrawingTexture(textureId);
                        blit(matrices, (int) x, (int) y, 0, 0, (int) size, (int) size, (int) (flipTexture ? -size : size), (int) size);
                    });
                }
            }

            if (editingIndex >= 0) {
                final int xOffsetSmall = (width - SIGN_BUTTON_SIZE * (columns * 4 + 3)) / 2 + SIGN_BUTTON_SIZE;
                final int xOffsetBig = xOffsetSmall + SIGN_BUTTON_SIZE * (columns + 1);

                loopSigns((index, x, y, isBig) -> {
                    final String signId = allSignIds.get(index);
                    final CustomResources.CustomSign sign = RenderRailwaySign.getSign(signId);
                    if (sign != null) {
                        final boolean moveRight = sign.hasCustomText() && sign.flipCustomText;
                        UtilitiesClient.beginDrawingTexture(sign.textureId);
                        RenderRailwaySign.drawSign(matrices, null, null, font, signPos, signId, (isBig ? xOffsetBig : xOffsetSmall) + x + (moveRight ? SIGN_BUTTON_SIZE * 2 : 0), BUTTON_Y_START + y, SIGN_BUTTON_SIZE, 2, 2, selectedIds, Direction.UP, 0, (textureId, x1, y1, size, flipTexture) -> blit(matrices, (int) x1, (int) y1, 0, 0, (int) size, (int) size, (int) (flipTexture ? -size : size), (int) size));
                    }
                }, false);

                Gui.drawCenteredString(matrices, font, String.format("%s/%s", page + 1, totalPages), (width - PANEL_WIDTH - SQUARE_SIZE * 4) / 2 + PANEL_WIDTH + SQUARE_SIZE * 2, height - SQUARE_SIZE * 2 + TEXT_PADDING, ARGB_WHITE);
            }
        } catch (Exception e) {
            TianjinMetro.LOGGER.error(e);
        }
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        setPage(page + (int) Math.signum(-amount));
        return super.mouseScrolled(mouseX, mouseY, amount);
    }

    @Override
    public void onClose() {
        PacketGuiServer.sendSignIdsC2S(signPos, selectedIds, signIds);
        super.onClose();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void resize(Minecraft client, int width, int height) {
        super.resize(client, width, height);
        for (Button button : buttonsEdit) {
            button.active = true;
        }
        for (Button button : buttonsSelection) {
            button.visible = false;
        }
        editingIndex = -1;
    }

    protected int loopSigns(LoopSignsCallback loopSignsCallback, boolean ignorePage) {
        int pageCount = rows * columns;
        int indexSmall = 0;
        int indexBig = 0;
        int columnSmall = 0;
        int columnBig = 0;
        int rowSmall = 0;
        int rowBig = 0;
        int totalPagesSmallCount = 1;
        int totalPagesBigCount = 1;
        for (int i = 0; i < allSignIds.size(); i++) {
            final CustomResources.CustomSign sign = RenderRailwaySign.getSign(allSignIds.get(i));
            final boolean isBig = sign != null && sign.hasCustomText();

            final boolean onPage = (isBig ? indexBig : indexSmall) / pageCount == page;
            buttonsSelection[i].visible = onPage;
            if (ignorePage || onPage) {
                loopSignsCallback.loopSignsCallback(i, (isBig ? columnBig * 3 : columnSmall) * SIGN_BUTTON_SIZE, (isBig ? rowBig : rowSmall) * SIGN_BUTTON_SIZE, isBig);
            }

            if (isBig) {
                columnBig++;
                if (totalPagesBigCount < 0) {
                    totalPagesBigCount = -totalPagesBigCount + 1;
                }
                if (columnBig >= columns) {
                    columnBig = 0;
                    rowBig++;
                    if (rowBig >= rows) {
                        rowBig = 0;
                        totalPagesBigCount = -totalPagesBigCount;
                    }
                }
                indexBig++;
            } else {
                columnSmall++;
                if (totalPagesSmallCount < 0) {
                    totalPagesSmallCount = -totalPagesSmallCount + 1;
                }
                if (columnSmall >= columns) {
                    columnSmall = 0;
                    rowSmall++;
                    if (rowSmall >= rows) {
                        rowSmall = 0;
                        totalPagesSmallCount = -totalPagesSmallCount;
                    }
                }
                indexSmall++;
            }
        }
        return Math.max(Math.abs(totalPagesBigCount), Math.abs(totalPagesSmallCount));
    }

    protected void edit(int editingIndex) {
        this.editingIndex = editingIndex;
        for (Button button : buttonsEdit) {
            button.active = true;
        }
        buttonClear.visible = true;
        setPage(page);
        buttonsEdit[editingIndex].active = false;
    }

    protected void setNewSignId(String newSignId) {
        if (editingIndex >= 0 && editingIndex < signIds.length) {
            signIds[editingIndex] = newSignId;
            final boolean isExitLetter = newSignId != null && (newSignId.equals(BlockRailwaySign.SignType.EXIT_LETTER.toString()) || newSignId.equals(BlockRailwaySign.SignType.EXIT_LETTER_FLIPPED.toString()));
            final boolean isPlatform = newSignId != null && (newSignId.equals(BlockRailwaySign.SignType.PLATFORM.toString()) || newSignId.equals(BlockRailwaySign.SignType.PLATFORM_FLIPPED.toString()));
            final boolean isLine = newSignId != null && (newSignId.equals(BlockRailwaySign.SignType.LINE.toString()) || newSignId.equals(BlockRailwaySign.SignType.LINE_FLIPPED.toString()));
            if ((isExitLetter || isPlatform || isLine) && minecraft != null) {
                UtilitiesClient.setScreen(minecraft, new DashboardListSelectorScreen(this, isExitLetter ? exitsForList : isPlatform ? platformsForList : routesForList, selectedIds, false, false));
            }
        }
    }

    protected void setPage(int newPage) {
        page = Mth.clamp(newPage, 0, totalPages - 1);
        buttonPrevPage.visible = editingIndex >= 0 && page > 0;
        buttonNextPage.visible = editingIndex >= 0 && page < totalPages - 1;
    }

    @FunctionalInterface
    protected interface LoopSignsCallback
    {
        void loopSignsCallback(int index, int x, int y, boolean isBig);
    }
}
