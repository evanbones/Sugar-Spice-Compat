package com.chicken.muchmoremodcompat.setup;

import com.chicken.muchmoremodcompat.MuchMoreModCompat;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = MuchMoreModCompat.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static final ItemGroup ITEM_GROUP = new ItemGroup("muchmoremodcompat") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registration.GLOW_BRAZIER.get());
        }
    };

    @SubscribeEvent
    public static void onServerSetUp(FMLServerStartingEvent event) {
    }

}
