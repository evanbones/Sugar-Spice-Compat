package com.chicken.muchmoremodcompat.blocks;

import com.lilypuree.decorative_blocks.blocks.BeamBlock;
import com.teamaurora.enhanced_mushrooms.common.block.IGlowshroomWood;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

import static com.chicken.muchmoremodcompat.datagen.types.EnhancedMushroomsWoodTypes.GLOWSHROOM;

public class AlphaBeamBlock
    extends BeamBlock implements IGlowshroomWood {
    public AlphaBeamBlock(Block.Properties properties) {
        super(properties, GLOWSHROOM);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isSideInvisible(BlockState bs1, BlockState bs2, Direction side) {
        return super.isSideInvisible(bs1, bs2, side) || bs2.getBlock() instanceof IGlowshroomWood;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);

        if(rand.nextInt(10) == 0)
            worldIn.addParticle(ParticleTypes.END_ROD, pos.getX() + rand.nextDouble(), pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), 0, 0, 0);
    }
}
