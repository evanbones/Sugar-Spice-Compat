package com.chicken.sugar_and_spice.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lilypuree.decorative_blocks.datagen.BlockLootTableAccessor;
import com.lilypuree.decorative_blocks.datagen.LootTables;
import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.lilypuree.decorative_blocks.datagen.types.WoodDecorativeBlockTypes;
import com.chicken.sugar_and_spice.datagen.types.CompatWoodTypes;
import com.chicken.sugar_and_spice.setup.Registration;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

public class CompatLootTables
        extends LootTables
{
    private final DataGenerator generator;

    public CompatLootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
        this.generator = dataGeneratorIn;
    }


    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();


    public void act(DirectoryCache cache) {
        for (IWoodType wood : CompatWoodTypes.allWoodTypes()) {
            for (WoodDecorativeBlockTypes type : WoodDecorativeBlockTypes.values()) {
                addBlockLoot(Registration.getWoodDecorativeBlock(wood, type));
            }
        }
        addBlockLoot(Registration.GLOW_BRAZIER.get());
        addBlockLoot(Registration.GLOW_BRAZIER.get());

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParameterSet(LootParameterSets.BLOCK).build());        }
        writeTables(cache, tables);
    }

    public void addBlockLoot(Block block) {
        this.lootTables.put(block, BlockLootTableAccessor.dropping(block));
    }
}
