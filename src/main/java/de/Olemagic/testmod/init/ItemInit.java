package de.Olemagic.testmod.init;

import de.Olemagic.testmod.TestmodMain;
import de.Olemagic.testmod.items.FuelItem;
import de.Olemagic.testmod.items.TeleportStaff;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    //Get the item register
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestmodMain.MODID);

    //Register Ruby
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(RubyCreativeTab.ruby)));

    //Register Mango
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().tab(OtherCreativeTab.other)
                    .food(new FoodProperties.Builder().nutrition(4).saturationMod(3)
                    .effect(()  -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1F)
                    .build())));

    //Register coke
    public static final RegistryObject<Item> COKE = ITEMS.register("coke",
            () -> new FuelItem(new Item.Properties().tab(OtherCreativeTab.other), 3200));

    //Register Teleport staff
    public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("teleport_staff",
            () -> new TeleportStaff(new Item.Properties().tab(OtherCreativeTab.other)
                    .durability(100)));

    public static class RubyCreativeTab extends CreativeModeTab {
        private RubyCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RUBY.get());
        }

        public static final RubyCreativeTab ruby = new RubyCreativeTab(CreativeModeTab.TABS.length, "ruby");


    }

    public static class OtherCreativeTab extends CreativeModeTab {
        private OtherCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(MANGO.get());
        }

        public static final OtherCreativeTab other = new OtherCreativeTab(CreativeModeTab.TABS.length, "other");


    }
}