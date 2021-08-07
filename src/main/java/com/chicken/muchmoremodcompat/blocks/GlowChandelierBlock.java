package com.chicken.muchmoremodcompat.blocks;

import com.lilypuree.decorative_blocks.blocks.ChandelierBlock;
import java.util.Random;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GlowChandelierBlock
    extends ChandelierBlock {
    public GlowChandelierBlock(AbstractBlock.Properties properties){
        super(properties, false);
    }

    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.7D;
        double d2 = (double)pos.getZ() + 0.5D;
        double off1 = 0.1875;
        double off2 = 0.3125;
        double off3 = 0.0625;
        worldIn.addParticle(ParticleTypes.SMOKE, d0-off1, d1, d2-off2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleTypes.SMOKE, d0-off2-off3, d1, d2+off1-off3, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleTypes.SMOKE, d0+off1-off3, d1, d2+off2+off3, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(ParticleTypes.SMOKE, d0+off2, d1, d2-off1, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(InfernalProxy.getGlowFlameParticle(), d0-off1, d1, d2-off2, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(InfernalProxy.getGlowFlameParticle(), d0-off2-off3, d1, d2+off1-off3, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(InfernalProxy.getGlowFlameParticle(), d0+off1-off3, d1, d2+off2+off3, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(InfernalProxy.getGlowFlameParticle(), d0+off2, d1, d2-off1, 0.0D, 0.0D, 0.0D);
      }
}
