package com.chicken.sugar_and_spice.setup;


import com.chicken.sugar_and_spice.SugarAndSpice;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = SugarAndSpice.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static final ItemGroup ITEM_GROUP = new ItemGroup("sugar_and_spice") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.GLOW_BRAZIER.get());
        }
    };

    @SubscribeEvent
    public static void onServerSetUp(FMLServerStartingEvent event) {
    }

}
