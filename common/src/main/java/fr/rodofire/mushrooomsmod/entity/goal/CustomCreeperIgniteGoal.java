package fr.rodofire.mushrooomsmod.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import fr.rodofire.mushrooomsmod.entity.custom.CustomCreeperEntity;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class CustomCreeperIgniteGoal extends Goal {
    private final CustomCreeperEntity creeper;
    @Nullable
    private LivingEntity target;

    public CustomCreeperIgniteGoal(CustomCreeperEntity creeper) {
        this.creeper = creeper;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        LivingEntity livingEntity = this.creeper.getTarget();
        return this.creeper.getFuseSpeed() > 0 || livingEntity != null && this.creeper.distanceToSqr(livingEntity) < 9.0;
    }

    @Override
    public void start() {
        this.creeper.getNavigation().stop();
        this.target = this.creeper.getTarget();
    }

    @Override
    public void stop() {
        this.target = null;
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        if (this.target == null) {
            this.creeper.setFuseSpeed(-1);
            return;
        }
        if (this.creeper.distanceToSqr(this.target) > 49.0) {
            this.creeper.setFuseSpeed(-1);
            return;
        }
        if (!this.creeper.getSensing().hasLineOfSight(this.target)) {
            this.creeper.setFuseSpeed(-1);
            return;
        }
        this.creeper.setFuseSpeed(1);
    }
}
