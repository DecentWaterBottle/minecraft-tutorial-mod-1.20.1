package net.tuggers.tutorialmod.item.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.tuggers.tutorialmod.entity.ModEntities;


// WAS: ThrowableProjectile
public class ThrowableSpearEntity extends AbstractArrow {
//    protected ThrowableSpearEntity(EntityType<? extends ThrowableProjectile> pEntityType, Level pLevel) {
//        super(pEntityType, pLevel);
//    }
private float clientSideRotation = 0;
    private boolean counterClockwiseBounce = true;

    private int maxLife = 300;
    private float gravityVelocity = 0.03F;
    private ItemStack item = ItemStack.EMPTY;
    public float rotation;
    public float prevRotation;

    public ThrowableSpearEntity(EntityType<? extends AbstractArrow> pEntityType, double pX, double pY, double pZ, Level pLevel, int maxLife, float gravityVelocity) {
        super(pEntityType, pX, pY, pZ, pLevel);
        this.maxLife = maxLife;
        this.gravityVelocity = gravityVelocity;
    }


    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    public ItemStack getItem()
    {
        return this.item;
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        System.out.println("Hit Enemy");
    }

    @Override
    protected ItemStack getPickupItem() {
        return new ItemStack(Items.EMERALD);
    }

    public ThrowableSpearEntity(EntityType<? extends AbstractArrow> pEntityType, LivingEntity pShooter, Level pLevel, int maxLife, float gravityVelocity) {
        super(pEntityType, pShooter, pLevel);
        this.maxLife = maxLife;
        this.gravityVelocity = gravityVelocity;
    }

    public ThrowableSpearEntity(EntityType<ThrowableSpearEntity> throwableSpearEntityEntityType, Level level) {
        super(throwableSpearEntityEntityType, level);

    }

    public ThrowableSpearEntity(LivingEntity pLivingEntity, Level pLevel) {
        super(ModEntities.THROWABLE_SPEAR.get(), pLivingEntity, pLevel);
        this.setGravityVelocity(0.05F);
    }


//    @Override
//    protected void defineSynchedData() {
//
//    }


    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    protected void setGravityVelocity(float gravity) {
        this.gravityVelocity = gravity;
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.level().isClientSide) {
            if (this.tickCount >= this.maxLife) {
                this.remove(RemovalReason.DISCARDED);
            }
        }
    }

    public float getRotationAnimation(float partialTicks) {
        if(!this.inGround) {
//            clientSideRotation = (this.counterClockwiseBounce? 1:-1)*(this.tickCount+partialTicks) * 20F;
            clientSideRotation = (this.tickCount + partialTicks) * 50;
            System.out.println(clientSideRotation);
        }
        return this.clientSideRotation;
    }


    @Override
    public boolean isNoGravity() {
        return false;
    }

    public boolean isFoil() {
        return false;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
