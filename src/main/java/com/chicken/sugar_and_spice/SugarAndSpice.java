package com.chicken.sugar_and_spice;

import com.chicken.sugar_and_spice.setup.*;
import com.chicken.sugar_and_spice.setup.Registration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(SugarAndSpice.MODID)
public class SugarAndSpice
{
    public static final String MODID = "sugar_and_spice";

    public static ModSetup setup = new ModSetup();
    public static SugarAndSpice instance;

    public SugarAndSpice() {
        instance = this;
        Registration.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
}
