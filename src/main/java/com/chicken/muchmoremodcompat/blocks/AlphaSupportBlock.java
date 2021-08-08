package com.chicken.muchmoremodcompat.blocks;

import com.lilypuree.decorative_blocks.blocks.SupportBlock;
import com.teamaurora.enhanced_mushrooms.common.block.IGlowshroomWood;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

import static com.chicken.muchmoremodcompat.datagen.types.EnhancedMushroomsWoodTypes.GLOWSHROOM;

public class AlphaSupportBlock
    extends SupportBlock {
    public AlphaSupportBlock(Properties properties) {
        super(properties, GLOWSHROOM);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);

        if(rand.nextInt(10) == 0)
            worldIn.addParticle(ParticleTypes.END_ROD, pos.getX() + rand.nextDouble(), pos.getY() + rand.nextDouble(), pos.getZ() + rand.nextDouble(), 0, 0, 0);
    }
}
