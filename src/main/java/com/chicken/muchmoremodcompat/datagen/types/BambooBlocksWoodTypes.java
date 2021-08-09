package com.chicken.muchmoremodcompat.datagen.types;

import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.minecraftabnormals.bamboo_blocks.core.registry.BBBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.fml.ModList;

public enum BambooBlocksWoodTypes
        implements IWoodType {
    BAMBOO("bamboo")
            {

                public Block getSlab() {
                    return (Block)BBBlocks.BAMBOO_SLAB.get();
                }


                public Block getFence() {
                    return (Block)BBBlocks.BAMBOO_FENCE.get();
                }


                public Block getPlanks() {
                    return (Block)BBBlocks.BAMBOO_PLANKS.get();
                }
            };

    private final String name;

    BambooBlocksWoodTypes(String name) {
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
        return ModList.get().isLoaded("bamboo_blocks");
    }


    public boolean isFlammable() {
        return true;
    }
}
