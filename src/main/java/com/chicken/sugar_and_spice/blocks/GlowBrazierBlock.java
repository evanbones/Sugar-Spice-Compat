package com.chicken.sugar_and_spice.blocks;

import com.lilypuree.decorative_blocks.blocks.BrazierBlock;
import java.util.Random;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GlowBrazierBlock extends BrazierBlock {
    public GlowBrazierBlock(AbstractBlock.Properties properties) {
        super(properties, false);
    }


    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (stateIn.get(LIT)) {
            if (rand.nextInt(10) == 0) {
                worldIn.playSound((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F), SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.6F, false);
            }

            if (rand.nextInt(5) == 0) {
                for (int i = 0; i < rand.nextInt(1) + 1; ++i) {
                    worldIn.addParticle(InfernalProxy.getGlowFlameParticle(), pos.getX() + 0.5f, pos.getY() + 0.8f, pos.getZ() + 0.5f, ((rand.nextFloat() - 0.5F) / 10.0F), (rand.nextFloat() / 5.0F), (rand.nextFloat() - 0.5D) / 10.0D);
                }
            }

        }
    }
}