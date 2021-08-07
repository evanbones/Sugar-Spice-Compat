package com.chicken.sugar_and_spice.setup;

import com.chicken.sugar_and_spice.SugarAndSpice;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SugarAndSpice.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(Registration.GLOW_BRAZIER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(Registration.ICE_CHAIN.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(Registration.GOLD_CHAIN.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(Registration.GLOW_CHANDELIER.get(), RenderType.getCutoutMipped());
    }
}
