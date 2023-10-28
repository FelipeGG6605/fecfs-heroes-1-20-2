package com.fecfs.heroes.particle;

import com.fecfs.heroes.FecfsHeroes;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class FecfsParticles {
    public static final DefaultParticleType SMOKE_PARTICLE =
            registerParticle("smoke_particle", FabricParticleTypes.simple());
    public static final DefaultParticleType PLACING_GEL =
            registerParticle("placing_gel", FabricParticleTypes.simple());
    private static DefaultParticleType registerParticle(String name, DefaultParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(FecfsHeroes.MOD_ID, name), particleType);
    }
    public static void registerParticles() {
        FecfsHeroes.LOGGER.info("Registering particles for "+FecfsHeroes.MOD_ID);
    }
}
