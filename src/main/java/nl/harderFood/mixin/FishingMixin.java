package nl.harderFood.mixin;
import net.minecraft.entity.projectile.FishingBobberEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
@Mixin(FishingBobberEntity.class)
public class FishingMixin {
    @ModifyVariable(method = "tickFishingLogic", at = @At("STORE"), ordinal = 0)
    private int longerFishingWait(int original) {
        return original * 2;
    }
}
