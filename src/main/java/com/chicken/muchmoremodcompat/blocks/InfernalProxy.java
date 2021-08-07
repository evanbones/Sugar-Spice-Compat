package com.chicken.muchmoremodcompat.blocks;

import org.infernalstudios.infernalexp.init.IEParticleTypes;
import net.minecraft.particles.IParticleData;

public class InfernalProxy
{
    public static IParticleData getGlowFlameParticle() {
        return IEParticleTypes.GLOWSTONE_SPARKLE.get();
    }
}
