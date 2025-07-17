package fr.rodofire.mushrooomsmod.entity.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import fr.rodofire.mushrooomsmod.MushrooomsModConstants;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import fr.rodofire.mushrooomsmod.MushrooomsMod;
import fr.rodofire.mushrooomsmod.entity.client.model.InventoryArmorStandModel;
import fr.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;
import software.bernie.geckolib.renderer.specialty.DynamicGeoEntityRenderer;


public class InventoryArmorStandRenderer extends DynamicGeoEntityRenderer<InventoryArmorStandEntity> {
    private static final String LEFT_BOOT = "left_foot";
    private static final String RIGHT_BOOT = "right_foot";
    private static final String LEFT_ARMOR_LEG = "left_leg";
    private static final String RIGHT_ARMOR_LEG = "right_leg";
    private static final String CHESTPLATE = "armor_body";
    private static final String RIGHT_SLEEVE = "right_arm";
    private static final String LEFT_SLEEVE = "left_arm";
    private static final String HELMET = "head";


    private static final String LEFT_HAND = "item1";
    private static final String RIGHT_HAND = "item2";

    public static ItemStack offhandItem;
    public static ItemStack mainHandItem;

    public InventoryArmorStandRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new InventoryArmorStandModel());
        addRenderLayer(new ItemArmorGeoLayer<>(this) {
            @Nullable
            @Override
            protected ItemStack getArmorItemForBone(GeoBone bone, InventoryArmorStandEntity animatable) {
                // Return the items relevant to the bones being rendered for additional rendering
                return switch (bone.getName()) {
                    case LEFT_BOOT, RIGHT_BOOT -> this.bootsStack;
                    case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> this.leggingsStack;
                    case CHESTPLATE, RIGHT_SLEEVE, LEFT_SLEEVE -> this.chestplateStack;
                    case HELMET -> this.helmetStack;
                    default -> null;
                };
            }

            // Return the equipment slot relevant to the bone we're using

            @Override
            protected @NotNull EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, InventoryArmorStandEntity animatable) {
                return switch (bone.getName()) {
                    case LEFT_BOOT, RIGHT_BOOT -> EquipmentSlot.FEET;
                    case LEFT_ARMOR_LEG, RIGHT_ARMOR_LEG -> EquipmentSlot.LEGS;
                    case CHESTPLATE -> EquipmentSlot.CHEST;
                    case HELMET -> EquipmentSlot.HEAD;
                    default -> super.getEquipmentSlotForBone(bone, stack, animatable);
                };
            }

            // Return the ModelPart responsible for the armor pieces we want to render

            @Override
            protected @NotNull ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, InventoryArmorStandEntity animatable, HumanoidModel<?> baseModel) {
                return switch (bone.getName()) {
                    case LEFT_BOOT, LEFT_ARMOR_LEG -> baseModel.leftLeg;
                    case RIGHT_BOOT, RIGHT_ARMOR_LEG -> baseModel.rightLeg;
                    case RIGHT_SLEEVE -> baseModel.rightArm;
                    case LEFT_SLEEVE -> baseModel.leftArm;
                    case CHESTPLATE -> baseModel.body;
                    case HELMET -> baseModel.head;
                    default -> super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
                };
            }
        });

        // Add some held item rendering
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            @Override
            protected ItemStack getStackForBone(GeoBone bone, InventoryArmorStandEntity animatable) {
                // Retrieve the items in the entity's hands for the relevant bone
                return switch (bone.getName()) {
                    case LEFT_HAND -> mainHandItem;
                    case RIGHT_HAND -> offhandItem;
                    default -> null;
                };
            }

            @Override
            protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, InventoryArmorStandEntity animatable) {
                // Apply the camera transform for the given hand
                return switch (bone.getName()) {
                    case LEFT_HAND, RIGHT_HAND -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
                    default -> ItemDisplayContext.NONE;
                };
            }

            // Do some quick render modifications depending on what the item is
            @Override
            protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, InventoryArmorStandEntity animatable,
                                              MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == mainHandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90f));
                    poseStack.scale(0.7f, 0.7f, 0.7f);

                } else if (stack == offhandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90f));
                    poseStack.scale(0.7f, 0.7f, 0.7f);
                }

                super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
            }
        });
    }

    @Override
    public void preRender(PoseStack poseStack, InventoryArmorStandEntity animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);

        mainHandItem = animatable.getMainHandItem();
        offhandItem = animatable.getOffhandItem();

    }

    @Override
    protected float getDeathMaxRotation(InventoryArmorStandEntity animatable) {
        return 0;
    }


    public ResourceLocation getTexture(InventoryArmorStandEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MushrooomsModConstants.MOD_ID, "textures/entity/inventory_armor_stand.png");
    }
/*
    @Override
    public boolean hasLabel(InventoryArmorStandEntity animatable) {
        return animatable.hasCustomName();
    }
    */


    @Nullable
    protected RenderType getRenderLayer(InventoryArmorStandEntity armorStandEntity, boolean bl, boolean bl2, boolean bl3) {
        /*if (!armorStandEntity.isMarker()) {
            return super.getRenderLayer(armorStandEntity, bl, bl2, bl3);
        } else {*/
            ResourceLocation identifier = this.getTexture(armorStandEntity);
            if (bl2) {
                return RenderType.entityTranslucent(identifier, false);
            } else {
                return bl ? RenderType.entityCutoutNoCull(identifier, false) : null;
            }
        //}
    }
}