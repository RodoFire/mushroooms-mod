package fr.rodofire.mushrooomsmod.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class FlickeringStatusEffect extends MobEffect {
    protected FlickeringStatusEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide()) {
            return false;
        }
        ServerLevel world = (ServerLevel) entity.level();
        Vec3 vec3d = entity.position();
        for (int i = 0; i < 400; ++i) {
            Vec3 vec3d2 = vec3d.add((float) RandomSource.create().nextIntBetweenInclusive(-200, 200) / 10, (float) RandomSource.create().nextIntBetweenInclusive(-200, 200) / 10, (float) RandomSource.create().nextIntBetweenInclusive(-200, 200) / 10);
            Vec3 vec3d3 = vec3d.add((float) RandomSource.create().nextIntBetweenInclusive(-20, 20) / 10, (float) RandomSource.create().nextIntBetweenInclusive(-20, 20) / 10, (float) RandomSource.create().nextIntBetweenInclusive(-20, 20) / 10);
            world.sendParticles(ParticleTypes.GLOW_SQUID_INK, vec3d2.x, vec3d2.y, vec3d2.z, 0, vec3d3.x, vec3d3.y, vec3d3.z, 0.00001f);
        }
        super.applyEffectTick(entity, amplifier);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

}
