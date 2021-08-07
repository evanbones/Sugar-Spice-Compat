package com.chicken.muchmoremodcompat.datagen.types;

import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.minecraftabnormals.environmental.core.registry.EnvironmentalBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.fml.ModList;

public enum EnvironmentalWoodTypes
        implements IWoodType {
    WISTERIA("wisteria")
            {
                public Block getLog() {
                    return (Block)EnvironmentalBlocks.WISTERIA_LOG.get();
                }


                public Block getStrippedLog() {
                    return (Block)EnvironmentalBlocks.STRIPPED_WISTERIA_LOG.get();
                }


                public Block getSlab() {
                    return (Block)EnvironmentalBlocks.WISTERIA_SLAB.get();
                }


                public Block getFence() {
                    return (Block)EnvironmentalBlocks.WISTERIA_FENCE.get();
                }


                public Block getPlanks() {
                    return (Block)EnvironmentalBlocks.WISTERIA_PLANKS.get();
                }
            };

    private final String name;

    EnvironmentalWoodTypes(String name) {
        this.name = name;
    }

    public String toString() {
        return getName();
    }


    public Block getLog() {
        return null;
    }


    public Block getStrippedLog() {
        return null;
    }


    public Block getSlab() {
        return null;
    }


    public Block getFence() {
        return null;
    }


    public Block getPlanks() {
        return null;
    }

    public String getName() {
        return this.name;
    }



    public boolean isAvailable() {
        return ModList.get().isLoaded("environmental");
    }


    public boolean isFlammable() {
        return true;
    }
}
