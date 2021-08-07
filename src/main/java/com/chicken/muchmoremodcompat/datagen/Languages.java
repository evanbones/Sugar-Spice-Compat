package com.chicken.muchmoremodcompat.datagen;

import com.chicken.muchmoremodcompat.MuchMoreModCompat;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Languages extends LanguageProvider {

    public Languages(DataGenerator gen, String locale) {
        super(gen, MuchMoreModCompat.MODID, locale);
    }

    @Override
    protected void addTranslations() {

    }
}