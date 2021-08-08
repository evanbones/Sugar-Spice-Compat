package com.chicken.muchmoremodcompat.setup;

import com.chicken.muchmoremodcompat.blocks.*;
import com.google.common.collect.ImmutableMap;
import com.lilypuree.decorative_blocks.blocks.*;
import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.lilypuree.decorative_blocks.datagen.types.WoodDecorativeBlockTypes;
import com.lilypuree.decorative_blocks.items.BurnableBlockItem;
import com.chicken.muchmoremodcompat.datagen.types.CompatWoodTypes;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.ModList;
import net.minecraft.item.Item;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.chicken.muchmoremodcompat.MuchMoreModCompat.MODID;

public class Registration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
    }

    public static final AbstractBlock.Properties goldChainProperties = Block.Properties.create(Material.IRON, MaterialColor.GOLD).hardnessAndResistance(4.3F).sound(SoundType.METAL).notSolid();
    public static final RegistryObject<ChainBlock> GOLD_CHAIN = BLOCKS.register("gold_chain", () -> new ChainBlock(goldChainProperties));
    public static final AbstractBlock.Properties iceChainProperties = Block.Properties.create(Material.ICE, MaterialColor.BLUE).hardnessAndResistance(0.99F).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS).notSolid();
    public static final RegistryObject<ChainBlock> ICE_CHAIN = BLOCKS.register("ice_chain", () -> new ChainBlock(iceChainProperties));
    public static final RegistryObject<ChandelierBlock> GLOW_CHANDELIER = BLOCKS.register("glow_chandelier", () -> new GlowChandelierBlock(Block.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.3F).sound(SoundType.WOOD).notSolid().setLightLevel(state -> 11)));
    public static final RegistryObject<BrazierBlock> GLOW_BRAZIER = BLOCKS.register("glow_brazier", () -> new GlowBrazierBlock(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0F).sound(SoundType.METAL).setLightLevel(state -> state.get(BlockStateProperties.LIT) ? 10 : 0).notSolid()));

    public static final RegistryObject<PalisadeBlock> GLOWSHROOM_PALISADE = BLOCKS.register("glowshroom_palisade", () -> new AlphaPalisadeBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 4.0F).notSolid().sound(SoundType.WOOD).setLightLevel(state -> 14)));
    public static final RegistryObject<BeamBlock> GLOWSHROOM_BEAM = BLOCKS.register("glowshroom_beam", () -> new AlphaBeamBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.2F).sound(SoundType.WOOD).notSolid().setLightLevel(state -> 14)));
    public static final RegistryObject<SupportBlock> GLOWSHROOM_SUPPORT = BLOCKS.register("glowshroom_support", () -> new AlphaSupportBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.2F).sound(SoundType.WOOD).notSolid().setLightLevel(state -> 14)));

    public static final Item.Properties modItemProperties = new Item.Properties().group(ModSetup.ITEM_GROUP);
    public static final Item.Properties dummyProperty = new Item.Properties();

    public static final RegistryObject<Item> GLOWSHROOM_SUPPORT_ITEM = ITEMS.register("glowshroom_support", () -> new BlockItem(GLOWSHROOM_SUPPORT.get(), modItemProperties));
    public static final RegistryObject<Item> GLOWSHROOM_BEAM_ITEM = ITEMS.register("glowshroom_beam", () -> new BlockItem(GLOWSHROOM_BEAM.get(), modItemProperties));
    public static final RegistryObject<Item> GLOWSHROOM_PALISADE_ITEM = ITEMS.register("glowshroom_palisade", () -> new BlockItem(GLOWSHROOM_PALISADE.get(), modItemProperties));
    public static final RegistryObject<Item> GLOW_CHANDELIER_ITEM = ITEMS.register("glow_chandelier", () -> new BurnableBlockItem(GLOW_CHANDELIER.get(), modItemProperties, 1600));
    public static final RegistryObject<Item> GLOW_BRAZIER_ITEM = ITEMS.register("glow_brazier", () -> new BlockItem(GLOW_BRAZIER.get(), modItemProperties));
    public static final RegistryObject<Item> GOLD_CHAIN_ITEM = ITEMS.register("gold_chain", () -> new BlockItem(GOLD_CHAIN.get(), modItemProperties));
    public static final RegistryObject<Item> ICE_CHAIN_ITEM = ITEMS.register("ice_chain", () -> new BlockItem(ICE_CHAIN.get(), modItemProperties));

    public static final ImmutableMap<String, RegistryObject<Block>> muchmoremodcompat;
    public static final ImmutableMap<String, RegistryObject<Item>> DECORATIVE_ITEMBLOCKS;

    static {
        ImmutableMap.Builder<String, RegistryObject<Block>> decorativeBlockBuilder = ImmutableMap.builder();
        ImmutableMap.Builder<String, RegistryObject<Item>> itemBuilder = ImmutableMap.builder();

        for (WoodDecorativeBlockTypes type : WoodDecorativeBlockTypes.values()) {
            for (IWoodType wood : CompatWoodTypes.allWoodTypes()) {
                String name = wood + "_" + type;
                decorativeBlockBuilder.put(name, BLOCKS.register(name, () -> createDecorativeBlock(wood, type)));
            }
        }
        muchmoremodcompat = decorativeBlockBuilder.build();

        for (WoodDecorativeBlockTypes type : WoodDecorativeBlockTypes.values()) {
            for (IWoodType wood : CompatWoodTypes.allWoodTypes()) {
                String name = wood + "_" + type;

                itemBuilder.put(name, ITEMS.register(name, () ->
                {
                    if (wood.isFlammable()) {
                        return new BurnableBlockItem(muchmoremodcompat.get(name).get(), wood.isAvailable() ? modItemProperties : dummyProperty, 300);
                    } else {
                        return new BlockItem(muchmoremodcompat.get(name).get(), wood.isAvailable() ? modItemProperties : dummyProperty);
                    }
                }));
            }
        }

        DECORATIVE_ITEMBLOCKS = itemBuilder.build();

    }

    public static Block getWoodDecorativeBlock(IWoodType wood, WoodDecorativeBlockTypes decorativeBlockType) {
        String name = wood + "_" + decorativeBlockType;
        return muchmoremodcompat.get(name).get();
    }

    public static RotatedPillarBlock getBeamBlock(IWoodType wood) {
        return (RotatedPillarBlock) getWoodDecorativeBlock(wood, WoodDecorativeBlockTypes.BEAM);
    }

    public static PalisadeBlock getPalisadeBlock(IWoodType wood) {
        return (PalisadeBlock) getWoodDecorativeBlock(wood, WoodDecorativeBlockTypes.PALISADE);
    }

    public static SupportBlock getSupportBlock(IWoodType wood) {
        return (SupportBlock) getWoodDecorativeBlock(wood, WoodDecorativeBlockTypes.SUPPORT);
    }

    private static Block createDecorativeBlock(IWoodType wood, WoodDecorativeBlockTypes woodDecorativeBlockType) {
        Block.Properties woodProperty = AbstractBlock.Properties.create(wood.getMaterial(), wood.getMaterialColor()).hardnessAndResistance(1.2F).sound(wood.getSoundType());
        Block.Properties palisadeProperty = AbstractBlock.Properties.create(wood.getMaterial(), wood.getMaterialColor()).hardnessAndResistance(2.0F, 4.0F).sound(wood.getSoundType());

        switch (woodDecorativeBlockType) {
            default:
            case BEAM:
                return new BeamBlock(woodProperty, wood);
            case SUPPORT:
                return new SupportBlock(woodProperty, wood);
            case PALISADE:
                return new PalisadeBlock(palisadeProperty, wood);
        }
    }
}

