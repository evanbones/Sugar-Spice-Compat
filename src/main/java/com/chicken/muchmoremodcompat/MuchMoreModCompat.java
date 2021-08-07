package com.chicken.muchmoremodcompat;

import com.chicken.muchmoremodcompat.setup.*;
import com.chicken.muchmoremodcompat.setup.Registration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(MuchMoreModCompat.MODID)
public class MuchMoreModCompat
{
    public static final String MODID = "muchmoremodcompat";

    public static ModSetup setup = new ModSetup();
    public static MuchMoreModCompat instance;

    public MuchMoreModCompat() {
        instance = this;
        Registration.register();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }
}
