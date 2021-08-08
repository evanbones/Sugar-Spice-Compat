package com.chicken.muchmoremodcompat.datagen.types;

import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.teamaurora.enhanced_mushrooms.core.registry.EMBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.fml.ModList;

public enum EnhancedMushroomsWoodTypes
        implements IWoodType {
    GLOWSHROOM("glowshroom") {
        public Block getLog() {
            return (Block)EMBlocks.GLOWSHROOM_STEM.get();
        }

        public Block getStrippedLog() {
            return (Block)EMBlocks.STRIPPED_GLOWSHROOM_STEM.get();
        }

        public Block getSlab() {
            return (Block)EMBlocks.GLOWSHROOM_SLAB.get();
        }

        public Block getFence() {
            return (Block)EMBlocks.GLOWSHROOM_FENCE.get();
        }

        public Block getPlanks() {
            return (Block)EMBlocks.GLOWSHROOM_PLANKS.get();
        }
    };

    private final String name;

    EnhancedMushroomsWoodTypes(String name) {
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
        return ModList.get().isLoaded("enhanced_mushrooms");
    }


    public boolean isFlammable() {
        return true;
    }
}
