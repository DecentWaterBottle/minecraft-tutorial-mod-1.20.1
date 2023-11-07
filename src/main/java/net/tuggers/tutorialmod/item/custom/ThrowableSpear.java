package net.tuggers.tutorialmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;

public class ThrowableSpear extends Item {


    public ThrowableSpear(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide()) {
            System.out.println("USED");
            pPlayer.startUsingItem(pUsedHand);
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    public int getUseDuration(ItemStack pStack) {
        return 5400;
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        if (!pLevel.isClientSide()) {
            System.out.println("RELEASED");
            int j = EnchantmentHelper.getRiptide(pStack);
            int duration = this.getUseDuration(pStack) - pTimeCharged;
            if (duration >= 10) {
                ThrowableSpearEntity spear = new ThrowableSpearEntity(pLivingEntity, pLevel);
//                spear.shootFromRotation(pLivingEntity, pLivingEntity.getXRot(), pLivingEntity.getYRot(), 0.0F, Math.min(1.0F, duration / 40F), 1.0F);
                spear.shootFromRotation(pLivingEntity, pLivingEntity.getXRot(), pLivingEntity.getYRot(), 0.0F, 2.5F + (float)j * 0.5F, 1.0F);
                pLevel.addFreshEntity(spear);
            }
        }
    }
}
