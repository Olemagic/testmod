package de.Olemagic.testmod.items;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class Dirtwand extends Item {
    public Dirtwand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext use) {
        //Set Block used on to dirt
        BlockPos clickpos = use.getClickedPos();
        Level world = use.getLevel();
        world.setBlock(clickpos, Blocks.DIRT.defaultBlockState(), 1);

        //Reduce durability on use
        Player player = use.getPlayer();
        InteractionHand interactionHand = use.getHand();
        ItemStack stack = player.getItemInHand(interactionHand);
        if (!player.isCreative()) stack.setDamageValue(stack.getDamageValue() + 1);

        //Break item if durability is 0
        if (stack.getDamageValue() >= stack.getMaxDamage()) stack.setCount(0);

        return super.useOn(use);
    }
}
