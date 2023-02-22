package de.Olemagic.testmod.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class Dirtwand extends Item {
    public Dirtwand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext use) {
        BlockPos clickpos = use.getClickedPos();
        Level world = use.getLevel();
        world.setBlock(clickpos, Blocks.DIRT.defaultBlockState(), 1);
        return super.useOn(use);
    }
}
