package nl.harderFood.mixin;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(AnimalEntity.class)
public class AnimalBreedingMixin {
    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void harderBreeding(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        AnimalEntity self = (AnimalEntity)(Object)this;
        World world = self.getWorld();
        if (!world.isClient) {
            ItemStack heldItem = player.getStackInHand(hand);
            if (self.isInLove() || heldItem.isEmpty()) return;
            if (world.getRandom().nextFloat() < 0.50f) {
                cir.setReturnValue(ActionResult.PASS);
            }
        }
    }
}
