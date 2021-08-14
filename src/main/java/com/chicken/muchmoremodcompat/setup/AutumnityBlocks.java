package com.chicken.muchmoremodcompat.setup;

import com.chicken.muchmoremodcompat.MuchMoreModCompat;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.autumnity.common.block.*;
import com.minecraftabnormals.autumnity.core.Autumnity;
import com.minecraftabnormals.autumnity.core.other.AutumnityProperties;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MuchMoreModCompat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AutumnityBlocks {
    public static final BlockSubRegistryHelper HELPER = Autumnity.REGISTRY_HELPER.getBlockSubHelper();
    public static final RegistryObject<Block> GLOW_JACK_O_LANTERN = HELPER.createCompatBlock("infernalexp", "glow_jack_o_lantern", () -> new AutumnityJackOLanternBlock(Block.Properties.from(Blocks.PUMPKIN).setLightLevel(AutumnityProperties.getMaxLightValue())), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> LARGE_GLOW_JACK_O_LANTERN_SLICE = HELPER.createCompatBlock("infernalexp", "large_glow_jack_o_lantern_slice", () -> new CarvedLargePumpkinSliceBlock(Block.Properties.from(Blocks.PUMPKIN).setLightLevel(AutumnityProperties.getMaxLightValue())), ItemGroup.BUILDING_BLOCKS);
}