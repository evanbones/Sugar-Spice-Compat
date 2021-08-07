package com.chicken.sugar_and_spice.datagen.types;

import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;

public class CompatWoodTypes
{
    public static Set<Pair<String, IWoodType>> woodTypes = new HashSet<>();

    static {
        addModWoodTypes("atmospheric", (IWoodType[])AtmosphericWoodTypes.values());
        addModWoodTypes("enhanced_mushrooms", (IWoodType[])EnhancedMushroomsWoodTypes.values());
        addModWoodTypes("environmental", (IWoodType[])EnvironmentalWoodTypes.values());
    }


    private static void addModWoodTypes(String modid, IWoodType[] modWood) {
        Arrays.<IWoodType>stream(modWood).forEach(woodType -> woodTypes.add(Pair.of(modid, woodType)));
    }


    public static Collection<IWoodType> allWoodTypes() {
        return (Collection<IWoodType>)woodTypes.stream().map(Pair::getValue).collect(Collectors.toList());
    }
}
