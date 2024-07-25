package ziyue.tjmetro.mod.client;

import org.mtr.core.tool.Utilities;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.ResourceManagerHelper;
import org.mtr.mod.Init;
import org.mtr.mod.client.MinecraftClientData;
import org.mtr.mod.config.Config;
import org.mtr.mod.config.LanguageDisplay;
import org.mtr.mod.data.IGui;
import org.mtr.mod.render.MainRenderer;
import ziyue.tjmetro.mod.config.ConfigClient;
import ziyue.tjmetro.mod.Reference;
import ziyue.tjmetro.mod.TianjinMetro;

import javax.annotation.Nullable;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.text.AttributedString;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;

import static org.mtr.mod.client.DynamicTextureCache.LINE_HEIGHT_MULTIPLIER;
import static org.mtr.mod.data.IGui.ARGB_WHITE;

public class DynamicTextureCache
{
    protected Font font;
    protected Font fontCjk;

    protected final Object2ObjectLinkedOpenHashMap<String, DynamicResource> dynamicResources = new Object2ObjectLinkedOpenHashMap<>();
    protected final ObjectOpenHashSet<String> generatingResources = new ObjectOpenHashSet<>();
    protected final ObjectArrayList<Runnable> resourceRegistryQueue = new ObjectArrayList<>();

    public static DynamicTextureCache instance = new DynamicTextureCache();

    protected static final int COOL_DOWN_TIME = 10000; // Images not requested within the last 10 seconds will be unregistered
    protected static final Identifier DEFAULT_BLACK_RESOURCE = new Identifier(Init.MOD_ID, "textures/block/black.png");
    protected static final Identifier DEFAULT_WHITE_RESOURCE = new Identifier(Init.MOD_ID, "textures/block/white.png");
    protected static final Identifier DEFAULT_TRANSPARENT_RESOURCE = new Identifier(Init.MOD_ID, "textures/block/transparent.png");

    public void reload() {
        font = null;
        fontCjk = null;
        TianjinMetro.LOGGER.debug("Refreshing dynamic resources");
        dynamicResources.values().forEach(dynamicResource -> dynamicResource.needsRefresh = true);
        generatingResources.clear();
    }

    public void tick() {
        final ObjectArrayList<String> keysToRemove = new ObjectArrayList<>();
        dynamicResources.forEach((checkKey, checkDynamicResource) -> {
            if (checkDynamicResource.expiryTime < System.currentTimeMillis()) {
                checkDynamicResource.remove();
                keysToRemove.add(checkKey);
            }
        });
        keysToRemove.forEach(dynamicResources::remove);
    }

    public DynamicResource getDirectionArrow(long platformId, boolean hasLeft, boolean hasRight, IGui.HorizontalAlignment horizontalAlignment, boolean showToString, float paddingScale, float aspectRatio, int backgroundColor, int textColor, int transparentColor) {
        return getResource(String.format("tjmetro_direction_arrow_%s_%s_%s_%s_%s_%s_%s_%s_%s_%s", platformId, hasLeft, hasRight, horizontalAlignment, showToString, paddingScale, aspectRatio, backgroundColor, textColor, transparentColor), () -> RouteMapGenerator.generateDirectionArrow(platformId, hasLeft, hasRight, horizontalAlignment, showToString, paddingScale, aspectRatio, backgroundColor, textColor, transparentColor), transparentColor == 0 && backgroundColor == ARGB_WHITE ? DefaultRenderingColor.WHITE : DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getPSDStationName(long platformId, IGui.HorizontalAlignment horizontalAlignment, float paddingScale, float aspectRatio, int backgroundColor, int textColor, int transparentColor) {
        return getResource(String.format("tjmetro_psd_station_name_%s_%s_%s_%s_%s_%s_%s", platformId, horizontalAlignment, paddingScale, aspectRatio, backgroundColor, textColor, transparentColor), () -> RouteMapGenerator.generatePSDStationName(platformId, horizontalAlignment, paddingScale, aspectRatio, backgroundColor, textColor, transparentColor), transparentColor == 0 && backgroundColor == ARGB_WHITE ? DefaultRenderingColor.WHITE : DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getPSDNextStation(long platformId, int arrowDirection, float paddingScale, float aspectRatio, int backgroundColor, int textColor, int transparentColor) {
        return getResource(String.format("tjmetro_psd_next_station_%s_%s_%s_%s_%s_%s_%s", platformId, arrowDirection, paddingScale, aspectRatio, backgroundColor, textColor, transparentColor), () -> RouteMapGenerator.generatePSDNextStation(platformId, arrowDirection, paddingScale, aspectRatio, backgroundColor, textColor, transparentColor), transparentColor == 0 && backgroundColor == ARGB_WHITE ? DefaultRenderingColor.WHITE : DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getRouteMap(long platformId, boolean vertical, boolean flip, float aspectRatio, boolean transparentWhite) {
        return getResource(String.format("tjmetro_route_map_%s_%s_%s_%s_%s", platformId, vertical, flip, aspectRatio, transparentWhite), () -> RouteMapGenerator.generateRouteMap(platformId, vertical, flip, aspectRatio, transparentWhite), transparentWhite ? DefaultRenderingColor.TRANSPARENT : DefaultRenderingColor.WHITE);
    }

    public DynamicResource getRouteSquare(int color, String routeName, IGui.HorizontalAlignment horizontalAlignment) {
        return getResource(String.format("tjmetro_route_square_%s_%s_%s", color, routeName, horizontalAlignment), () -> RouteMapGenerator.generateRouteSquare(color, routeName, horizontalAlignment), DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getExitSignLetter(String exitLetter, String exitNumber, int backgroundColor) {
        return getResource(String.format("tjmetro_exit_sign_letter_%s_%s", exitLetter, exitNumber), () -> RouteMapGenerator.generateExitSignLetter(exitLetter, exitNumber, backgroundColor), DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getExitSignLetterTianjin(String exitLetter, String exitNumber, int backgroundColor, int textColor, boolean forceMTRFont) {
        return getResource(String.format("tjmetro_exit_sign_letter_tianjin_%s_%s_%s_%s_%s", exitLetter, exitNumber, backgroundColor, textColor, forceMTRFont), () -> RouteMapGenerator.generateExitSignLetterTianjin(exitLetter, exitNumber, backgroundColor, textColor, forceMTRFont), DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getBoundFor(long platformId, IGui.HorizontalAlignment horizontalAlignment, float aspectRatio, float paddingScale, int backgroundColor, int textColor, boolean forceMTRFont) {
        return getResource(String.format("tjmetro_bound_for_%s_%s_%s_%s_%s_%s_%s", platformId, horizontalAlignment, aspectRatio, paddingScale, backgroundColor, textColor, forceMTRFont), () -> RouteMapGenerator.generateBoundFor(platformId, horizontalAlignment, aspectRatio, paddingScale, backgroundColor, textColor, forceMTRFont), DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getSignText(String string, IGui.HorizontalAlignment horizontalAlignment, float paddingScale, int backgroundColor, int textColor) {
        return getResource(String.format("tjmetro_sign_text_%s_%s_%s_%s_%s", string, horizontalAlignment, paddingScale, backgroundColor, textColor), () -> RouteMapGenerator.generateSignText(string, horizontalAlignment, paddingScale, backgroundColor, textColor), DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getStationNameEntrance(long stationId, long selectedId, int style, String stationName, boolean isBMT, float aspectRatio) {
        return getResource(String.format("tjmetro_station_name_entrance_%s_%s_%s_%s_%s_%s", stationId, selectedId, style, stationName, isBMT, aspectRatio), () -> RouteMapGenerator.generateStationNameEntrance(stationId, selectedId, style, stationName, isBMT, aspectRatio), DefaultRenderingColor.TRANSPARENT);
    }

    public DynamicResource getStationNamePlate(long platformId, int arrowDirection, int backgroundColor, float paddingScale, float aspectRatio, int textColor, int transparentColor) {
        return getResource(String.format("tjmetro_station_name_plate_%s_%s_%s_%s_%s_%s_%s", platformId, arrowDirection, backgroundColor, paddingScale, aspectRatio, textColor, transparentColor), () -> RouteMapGenerator.generateStationNamePlate(platformId, arrowDirection, backgroundColor, paddingScale, aspectRatio, textColor, transparentColor), DefaultRenderingColor.TRANSPARENT);
    }

    public Text getText(String text, int maxWidth, int maxHeight, int fontSizeCjk, int fontSize, int padding, IGui.HorizontalAlignment horizontalAlignment) {
        return getText(text, maxWidth, maxHeight, fontSizeCjk, fontSize, padding, horizontalAlignment, false);
    }

    public Text getText(String text, int maxWidth, int maxHeight, int fontSizeCjk, int fontSize, int padding, IGui.HorizontalAlignment horizontalAlignment, boolean forceMTRFont) {
        if (forceMTRFont) {
            final int[] dimensions = new int[2];
            final byte[] pixels = org.mtr.mod.client.DynamicTextureCache.instance.getTextPixels(text, dimensions, maxWidth, maxHeight, fontSizeCjk, fontSize, padding, horizontalAlignment);
            return new Text(pixels, dimensions[0], dimensions[1], dimensions[0]);
        }

        if (maxWidth <= 0) return new Text(new byte[0], 0, 0, 0);

        final boolean customFont = ConfigClient.USE_TIANJIN_METRO_FONT.get();
        final boolean oneRow = horizontalAlignment == null;
        final String[] defaultTextSplit = IGui.textOrUntitled(text).split("\\|");
        final String[] textSplit;
        if (Config.getClient().getLanguageDisplay() == LanguageDisplay.NORMAL) {
            textSplit = defaultTextSplit;
        } else {
            final String[] tempTextSplit = Arrays.stream(IGui.textOrUntitled(text).split("\\|")).filter(textPart -> IGui.isCjk(textPart) == (Config.getClient().getLanguageDisplay() == LanguageDisplay.CJK_ONLY)).toArray(String[]::new);
            textSplit = tempTextSplit.length == 0 ? defaultTextSplit : tempTextSplit;
        }
        final AttributedString[] attributedStrings = new AttributedString[textSplit.length];
        final int[] textWidths = new int[textSplit.length];
        final int[] fontSizes = new int[textSplit.length];
        final FontRenderContext context = new FontRenderContext(new AffineTransform(), false, false);
        int width = 0;
        int height = 0;

        for (int index = 0; index < textSplit.length; index++) {
            final int newFontSize = IGui.isCjk(textSplit[index]) || font.canDisplayUpTo(textSplit[index]) >= 0 ? fontSizeCjk : fontSize;
            attributedStrings[index] = new AttributedString(textSplit[index]);
            fontSizes[index] = newFontSize;

            final Font fontSized = font.deriveFont(Font.PLAIN, newFontSize);
            final Font fontCjkSized = fontCjk.deriveFont(Font.PLAIN, newFontSize);

            for (int characterIndex = 0; characterIndex < textSplit[index].length(); characterIndex++) {
                final char character = textSplit[index].charAt(characterIndex);
                final Font newFont;
                if (fontSized.canDisplay(character)) {
                    newFont = fontSized;
                } else if (fontCjkSized.canDisplay(character)) {
                    newFont = fontCjkSized;
                } else {
                    Font defaultFont = null;
                    for (final Font testFont : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
                        if (testFont.canDisplay(character)) {
                            defaultFont = testFont;
                            break;
                        }
                    }
                    newFont = (defaultFont == null ? new Font(null) : defaultFont).deriveFont(Font.PLAIN, newFontSize);
                }
                textWidths[index] += newFont.getStringBounds(textSplit[index].substring(characterIndex, characterIndex + 1), context).getBounds().width;
                attributedStrings[index].addAttribute(TextAttribute.FONT, newFont, characterIndex, characterIndex + 1);
            }

            if (oneRow) {
                if (index > 0) {
                    width += padding;
                }
                width += textWidths[index];
                height = Math.max(height, (int) (fontSizes[index] * LINE_HEIGHT_MULTIPLIER));
            } else {
                width = Math.max(width, Math.min(maxWidth, textWidths[index]));
                height += (int) (fontSizes[index] * LINE_HEIGHT_MULTIPLIER);
            }
        }

        int textOffset = 0;
        final int imageHeight = Math.min(height, maxHeight);
        final BufferedImage image = new BufferedImage(width + (oneRow ? 0 : padding * 2), imageHeight + (oneRow ? 0 : padding * 2), BufferedImage.TYPE_BYTE_GRAY);
        final Graphics2D graphics2D = image.createGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int realWidth = 0;
        for (int index = 0; index < textSplit.length; index++) {
            if (oneRow) {
                graphics2D.drawString(attributedStrings[index].getIterator(), textOffset, height / LINE_HEIGHT_MULTIPLIER - (customFont ? height * 0.035F : 0));
                textOffset += textWidths[index] + padding;
            } else {
                final float scaleY = (float) imageHeight / height;
                final float textWidth = Math.min(maxWidth, textWidths[index] * scaleY);
                final float scaleX = textWidth / textWidths[index];
                final AffineTransform stretch = new AffineTransform();
                stretch.concatenate(AffineTransform.getScaleInstance(scaleX, scaleY));
                graphics2D.setTransform(stretch);
                graphics2D.drawString(attributedStrings[index].getIterator(), horizontalAlignment.getOffset(0, textWidth - width) / scaleY + padding / scaleX, textOffset + fontSizes[index] + padding / scaleY - (customFont ? height * 0.035F : 0));
                textOffset += (int) (fontSizes[index] * LINE_HEIGHT_MULTIPLIER);
                realWidth = Math.max(realWidth, (int) textWidth);
            }
        }
        realWidth += padding;

        width = width + (oneRow ? 0 : padding * 2);
        height = imageHeight + (oneRow ? 0 : padding * 2);
        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        graphics2D.dispose();
        image.flush();
        return new Text(pixels, realWidth, height, width);
    }

    protected DynamicResource getResource(String key, Supplier<NativeImage> supplier, DefaultRenderingColor defaultRenderingColor) {
        if (!resourceRegistryQueue.isEmpty()) {
            final Runnable runnable = resourceRegistryQueue.remove(0);
            if (runnable != null) {
                runnable.run();
            }
        }

        final DynamicResource dynamicResource = dynamicResources.get(key);

        if (dynamicResource != null && !dynamicResource.needsRefresh) {
            dynamicResource.expiryTime = System.currentTimeMillis() + COOL_DOWN_TIME;
            return dynamicResource;
        }

        if (generatingResources.contains(key)) {
            return defaultRenderingColor.dynamicResource;
        }

        MainRenderer.WORKER_THREAD.scheduleDynamicTextures(() -> {
            while (font == null) {
                ResourceManagerHelper.readResource(ConfigClient.USE_TIANJIN_METRO_FONT.get() ? new Identifier(Reference.MOD_ID, "font/dengxian.ttf") : new Identifier(Init.MOD_ID, "font/noto-sans-semibold.ttf"), inputStream -> {
                    try {
                        font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
                    } catch (Exception e) {
                        TianjinMetro.LOGGER.error(e.getMessage(), e);
                    }
                });
            }

            while (fontCjk == null) {
                ResourceManagerHelper.readResource(ConfigClient.USE_TIANJIN_METRO_FONT.get() ? new Identifier(Reference.MOD_ID, "font/dengxian.ttf") : new Identifier(Init.MOD_ID, "font/noto-serif-cjk-tc-semibold.ttf"), inputStream -> {
                    try {
                        fontCjk = Font.createFont(Font.TRUETYPE_FONT, inputStream);
                    } catch (Exception e) {
                        TianjinMetro.LOGGER.error(e.getMessage(), e);
                    }
                });
            }

            final NativeImage nativeImage = supplier.get();

            resourceRegistryQueue.add(() -> {
                final DynamicResource staticTextureProviderOld = dynamicResources.get(key);
                if (staticTextureProviderOld != null) {
                    staticTextureProviderOld.remove();
                }

                final DynamicResource dynamicResourceNew;
                if (nativeImage != null) {
                    final NativeImageBackedTexture nativeImageBackedTexture = new NativeImageBackedTexture(nativeImage);
                    final Identifier identifier = new Identifier(Reference.MOD_ID, "id_" + Utilities.numberToPaddedHexString(new Random().nextLong()).toLowerCase(Locale.ENGLISH));
                    MinecraftClient.getInstance().getTextureManager().registerTexture(identifier, new AbstractTexture(nativeImageBackedTexture.data));
                    dynamicResourceNew = new DynamicResource(identifier, nativeImageBackedTexture);
                    dynamicResources.put(key, dynamicResourceNew);
                }

                generatingResources.remove(key);
            });
        });
        RouteMapGenerator.setConstants();
        generatingResources.add(key);

        if (dynamicResource == null) {
            return defaultRenderingColor.dynamicResource;
        } else {
            dynamicResource.expiryTime = System.currentTimeMillis() + COOL_DOWN_TIME;
            dynamicResource.needsRefresh = false;
            return dynamicResource;
        }
    }

    /**
     * A text that contains its pixels, width, and height.
     *
     * @author ZiYueCommentary
     * @since beta-1
     */
    public static final class Text
    {
        private final byte[] pixels;
        private final int width;
        private final int height;
        private final int renderWidth;

        /**
         * @param width       the real width of the text
         * @param renderWidth the width when rendering the text, do not use
         */
        public Text(byte[] pixels, int width, int height, int renderWidth) {
            this.pixels = pixels;
            this.width = width;
            this.height = height;
            this.renderWidth = renderWidth;
        }

        public byte[] pixels() {
            return pixels;
        }

        public int width() {
            return width;
        }

        public int height() {
            return height;
        }

        public int renderWidth() {
            return renderWidth;
        }
    }

    /**
     * @see org.mtr.mod.client.DynamicTextureCache.DynamicResource
     */
    public static class DynamicResource
    {
        protected long expiryTime;
        protected boolean needsRefresh;
        public final int width;
        public final int height;
        public final Identifier identifier;

        protected DynamicResource(Identifier identifier, @Nullable NativeImageBackedTexture nativeImageBackedTexture) {
            this.identifier = identifier;
            if (nativeImageBackedTexture != null) {
                final NativeImage nativeImage = nativeImageBackedTexture.getImage();
                if (nativeImage != null) {
                    width = nativeImage.getWidth();
                    height = nativeImage.getHeight();
                } else {
                    width = 16;
                    height = 16;
                }
            } else {
                width = 16;
                height = 16;
            }
        }

        protected void remove() {
            MinecraftClient.getInstance().getTextureManager().destroyTexture(identifier);
            MainRenderer.cancelRender(identifier);
        }
    }

    protected enum DefaultRenderingColor
    {
        BLACK(DEFAULT_BLACK_RESOURCE),
        WHITE(DEFAULT_WHITE_RESOURCE),
        TRANSPARENT(DEFAULT_TRANSPARENT_RESOURCE);

        private final DynamicResource dynamicResource;

        DefaultRenderingColor(Identifier identifier) {
            dynamicResource = new DynamicResource(identifier, null);
        }
    }
}
