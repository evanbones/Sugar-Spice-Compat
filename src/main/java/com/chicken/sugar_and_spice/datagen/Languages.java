package com.chicken.sugar_and_spice.datagen;

import com.chicken.sugar_and_spice.SugarAndSpice;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Languages extends LanguageProvider {

    public Languages(DataGenerator gen, String locale) {
        super(gen, SugarAndSpice.MODID, locale);
    }

    @Override
    protected void addTranslations() {

    }
}