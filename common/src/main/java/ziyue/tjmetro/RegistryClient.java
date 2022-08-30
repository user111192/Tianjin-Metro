package ziyue.tjmetro;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;

/**
 * Register for some methods that have different implement ways.
 *
 * @see mtr.RegistryClient
 * @since 1.0b
 */

public class RegistryClient
{
    /**
     * Register block that can custom block color.
     *
     * @author ZiYueCommentary
     * @since 1.0b
     */
    @ExpectPlatform
    public static void registerCustomColorBlock(Block block) {
        throw new AssertionError();
    }

    /**
     * Register a boolean value game rule.
     *
     * @param name         Name of game rule.
     * @param category     Category of game rule in <b>Create New World</b>'s <b>Edit Game Rules</b>.
     * @param defaultValue Default value of game rule.
     * @return A boolean value game rule.
     * @author ZiYueCommentary
     * @since 1.0b
     */
    @ExpectPlatform
    public static GameRules.Key<GameRules.BooleanValue> registerBooleanGameRule(String name, GameRules.Category category, boolean defaultValue) {
        throw new AssertionError();
    }

    /**
     * Register a integer value game rule.
     *
     * @param name         Name of game rule.
     * @param category     Category of game rule in <b>Create New World</b>'s <b>Edit Game Rules</b>.
     * @param defaultValue Default value of game rule.
     * @return A integer value game rule.
     * @author ZiYueCommentary
     * @since 1.0b
     */
    @ExpectPlatform
    public static GameRules.Key<GameRules.IntegerValue> registerIntegerGameRule(String name, GameRules.Category category, int defaultValue) {
        throw new AssertionError();
    }

    /**
     * @author ZiYueCommentary
     * @see #registerBooleanGameRule(String, GameRules.Category, boolean)
     * @since 1.0b
     */
    public static GameRules.Key<GameRules.BooleanValue> registerBooleanGameRule(String name, boolean defaultValue) {
        return registerBooleanGameRule(name, GameRules.Category.MISC, defaultValue);
    }

    /**
     * @author ZiYueCommentary
     * @see #registerIntegerGameRule(String, GameRules.Category, int)
     * @since 1.0b
     */
    public static GameRules.Key<GameRules.IntegerValue> registerIntegerGameRule(String name, int defaultValue) {
        return registerIntegerGameRule(name, GameRules.Category.MISC, defaultValue);
    }
}
