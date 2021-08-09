package com.chicken.muchmoremodcompat.datagen;

import com.chicken.muchmoremodcompat.datagen.types.CompatWoodTypes;
import com.lilypuree.decorative_blocks.datagen.types.IWoodType;
import com.lilypuree.decorative_blocks.datagen.types.WoodDecorativeBlockTypes;
import com.chicken.muchmoremodcompat.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;



public class CompatBlockStates extends BlockStateProvider {
    public CompatBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, "muchmoremodcompat", exFileHelper);
    }


    private String name(Block block) {
        return block.getRegistryName().getPath();
    }

    public void palisadeBlock(IWoodType wood) {
        palisadeInventory(wood);
        MultiPartBlockStateBuilder builder = getMultipartBuilder(Registration.getPalisadeBlock(wood));
        ModelFile postModel = palisadePostPart(wood);
        ModelFile sideModel = palisadeSidePart(wood);

        builder.part().modelFile(postModel).addModel().end()
                .part().modelFile(sideModel).uvLock(true).addModel().condition(BlockStateProperties.NORTH, Boolean.TRUE).end()
                .part().modelFile(sideModel).uvLock(true).rotationY(180).addModel().condition(BlockStateProperties.SOUTH, Boolean.TRUE).end()
                .part().modelFile(sideModel).uvLock(true).rotationY(90).addModel().condition(BlockStateProperties.EAST, Boolean.TRUE).end()
                .part().modelFile(sideModel).uvLock(true).rotationY(270).addModel().condition(BlockStateProperties.WEST, Boolean.TRUE).end();
    }

    public ModelFile palisadePostPart(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.PALISADE, "post");
        return withSideEndTextures(builder, wood + "_palisade");
    }

    public ModelFile palisadeSidePart(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.PALISADE, "side");
        return withSideEndTextures(builder, wood + "_palisade");
    }

    public ModelFile palisadeInventory(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.PALISADE, "inventory");
        return withSideEndTextures(builder, wood + "_palisade");
    }


    public void beamBlock(IWoodType wood) {
        VariantBlockStateBuilder builder = getVariantBuilder(Registration.getBeamBlock(wood));
        ModelFile beamXModel = beamModel(wood, Direction.Axis.X);
        ModelFile beamYModel = beamModel(wood, Direction.Axis.Y);
        ModelFile beamZModel = beamModel(wood, Direction.Axis.Z);

        builder.partialState().with(BlockStateProperties.AXIS, Direction.Axis.X)
                .modelForState().modelFile(beamXModel).addModel();
        builder.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Y)
                .modelForState().modelFile(beamYModel).addModel();
        builder.partialState().with(BlockStateProperties.AXIS, Direction.Axis.Z)
                .modelForState().modelFile(beamZModel).addModel();
    }

    public ModelFile beamModel(IWoodType wood, Direction.Axis axis) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.BEAM, axis.getName2());
        return withSideEndTextures(builder, wood + "_beam");
    }


    public void seatBlock(IWoodType wood) {
        seatInventory(wood);
        MultiPartBlockStateBuilder builder = getMultipartBuilder(Registration.getSeatBlock(wood));
        ModelFile seatTopModel = seatTopModel(wood);
        ModelFile seatPostModel = seatPostModel(wood);

        builder.part().modelFile(seatPostModel).addModel().condition(BlockStateProperties.ATTACHED, Boolean.TRUE).end()
                .part().modelFile(seatTopModel).addModel().condition(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).end()
                .part().modelFile(seatTopModel).rotationY(180).addModel().condition(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH).end()
                .part().modelFile(seatTopModel).rotationY(90).addModel().condition(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).end()
                .part().modelFile(seatTopModel).rotationY(270).addModel().condition(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).end();
    }

    public ModelFile seatTopModel(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.SEAT, "top");
        return withParticleTexture(builder, wood + "_seat");
    }

    public ModelFile seatPostModel(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.SEAT, "post");
        return withParticleTexture(builder, wood + "_seat");
    }

    public ModelFile seatInventory(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.SEAT, "inventory");
        return withParticleTexture(builder, wood + "_seat");
    }


    public void supportBlock(IWoodType wood) {
        ModelFile supportUpModel = supportBlockModel(wood);
        ModelFile supportDownModel = supportBlockDownModel(wood);

        horizontalBlock(Registration.getSupportBlock(wood), state ->
                state.get(BlockStateProperties.UP) ? supportUpModel : supportDownModel
        );
    }

    public ModelFile supportBlockModel(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.SUPPORT);
        return withParticleTexture(builder, wood + "_support");
    }

    public ModelFile supportBlockDownModel(IWoodType wood) {
        ModelBuilder<?> builder = createModel(wood, WoodDecorativeBlockTypes.SUPPORT, "down");
        return withParticleTexture(builder, wood + "_support");
    }

    private ModelBuilder<?> createModel(IWoodType wood, WoodDecorativeBlockTypes type) {
        return createModel(wood, type, null);
    }

    private ModelBuilder<?> createModel(IWoodType wood, WoodDecorativeBlockTypes type, String suffix) {
        String name = type + ((suffix == null) ? "" : "_" + suffix);
        return models().getBuilder(wood + "_" + name).parent(new ModelFile.UncheckedModelFile(modLoc("custom/" + name)));
    }

    private ModelBuilder<?> withParticleTexture(ModelBuilder<?> model, String name) {
        ResourceLocation texture = modLoc("block/" + name);
        return model.texture("particle", texture).texture("texture", texture);
    }

    private ModelBuilder<?> withSideEndTextures(ModelBuilder<?> model, String name) {
        ResourceLocation side = modLoc("block/" + name + "_side");
        ResourceLocation end = modLoc("block/" + name + "_end");
        return model.texture("particle", side).texture("side", side).texture("end", end);
    }

    protected void registerStatesAndModels() {
        for (IWoodType wood : CompatWoodTypes.allWoodTypes()) {
            beamBlock(wood);
            palisadeBlock(wood);
            supportBlock(wood);
        }
    }
}
