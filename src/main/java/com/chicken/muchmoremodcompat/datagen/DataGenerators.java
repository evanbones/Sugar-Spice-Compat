package com.chicken.muchmoremodcompat.datagen;

import com.chicken.muchmoremodcompat.MuchMoreModCompat;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
            generator.addProvider(new CompatRecipes(generator));
            generator.addProvider(new CompatLootTables(generator));

        }
        if (event.includeClient()) {

            generator.addProvider(new CompatBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new CompatItems(generator, MuchMoreModCompat.MODID, event.getExistingFileHelper()));
            generator.addProvider(new Languages(generator, "en_us"));
        }
    }

}
