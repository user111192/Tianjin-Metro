package ziyue.tjmetro.mod.block;

import org.mtr.mapping.holder.Item;
import org.mtr.mod.block.BlockPSDAPGGlassBase;
import ziyue.tjmetro.mod.ItemList;

import javax.annotation.Nonnull;

public class BlockPSDGlassTianjin extends BlockPSDAPGGlassBase
{
    @Nonnull
    @Override
    public Item asItem2() {
        return ItemList.PSD_GLASS_TIANJIN.get();
    }
}
