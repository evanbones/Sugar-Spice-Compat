package com.chicken.muchmoremodcompat.datagen;

import com.lilypuree.decorative_blocks.datagen.Items;
import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.chicken.muchmoremodcompat.datagen.types.CompatWoodTypes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CompatItems extends Items {

    public CompatItems(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }



    protected void registerModels() {
        for (IWoodType wood : CompatWoodTypes.allWoodTypes()) {
                ((ItemModelBuilder) getBuilder(wood + "_beam")).parent((ModelFile) new ModelFile.UncheckedModelFile(modLoc("block/" + wood + "_beam_y")));
                ((ItemModelBuilder) getBuilder(wood + "_palisade")).parent((ModelFile) new ModelFile.UncheckedModelFile(modLoc("block/" + wood + "_palisade_inventory")));
                ((ItemModelBuilder) getBuilder(wood + "_support")).parent((ModelFile) new ModelFile.UncheckedModelFile(modLoc("block/" + wood + "_support")));
                ((ItemModelBuilder) getBuilder(wood + "_seat")).parent((ModelFile) new ModelFile.UncheckedModelFile(modLoc("block/" + wood + "_seat_inventory")));
        }
    }



    public String getName() {
        return "MuchMoreModCompat Item Models";
    }
}
