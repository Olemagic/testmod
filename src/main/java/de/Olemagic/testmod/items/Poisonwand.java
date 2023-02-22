package de.Olemagic.testmod.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Poisonwand extends Item {
    public Poisonwand(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        //Apply poison to clicked entity
        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 1));

        //Reduce durability on use
        ItemStack stack = player.getItemInHand(interactionHand);
        if (!player.isCreative()) stack.setDamageValue(stack.getDamageValue() + 1);

        //Break item if durability is 0
        if (stack.getDamageValue() >= stack.getMaxDamage()) stack.setCount(0);

        return super.interactLivingEntity(itemStack, player, livingEntity, interactionHand);
    }
}
