package com.chicken.muchmoremodcompat.datagen.types;

import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.minecraftabnormals.atmospheric.core.registry.AtmosphericBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.fml.ModList;

public enum AtmosphericWoodTypes
        implements IWoodType {
    KOUSA("kousa")
            {
                public Block getLog() {
                    return (Block)AtmosphericBlocks.KOUSA_WOOD.get();
                }


                public Block getStrippedLog() {
                    return (Block)AtmosphericBlocks.STRIPPED_KOUSA_WOOD.get();
                }


                public Block getSlab() {
                    return (Block)AtmosphericBlocks.KOUSA_SLAB.get();
                }


                public Block getFence() {
                    return (Block)AtmosphericBlocks.KOUSA_FENCE.get();
                }


                public Block getPlanks() {
                    return (Block)AtmosphericBlocks.KOUSA_PLANKS.get();
                }
            };

    private final String name;

    AtmosphericWoodTypes(String name) {
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
        return ModList.get().isLoaded("atmospheric");
    }


    public boolean isFlammable() {
        return true;
    }
}
