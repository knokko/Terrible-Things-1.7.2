
package terriblethings.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMinotaur extends ModelBase
{
  //fields
    ModelRenderer RightLeg;
    ModelRenderer LeftLeg;
    ModelRenderer Body;
    ModelRenderer LeftShoulder;
    ModelRenderer RightShoulder;
    ModelRenderer LeftArm;
    ModelRenderer RightArm;
    ModelRenderer Head;
    ModelRenderer RightHorn;
    ModelRenderer LeftHorn;
  
  public ModelMinotaur()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      RightLeg = new ModelRenderer(this, 0, 0);
      RightLeg.addBox(0F, 0F, 0F, 8, 24, 8);
      RightLeg.setRotationPoint(0F, 0F, -4F);
      RightLeg.setTextureSize(256, 128);
      RightLeg.mirror = true;
      setRotation(RightLeg, 0F, 0F, 0F);
      LeftLeg = new ModelRenderer(this, 8, 40);
      LeftLeg.addBox(0F, 0F, 0F, 8, 24, 8);
      LeftLeg.setRotationPoint(-8F, 0F, -4F);
      LeftLeg.setTextureSize(256, 128);
      LeftLeg.mirror = true;
      setRotation(LeftLeg, 0F, 0F, 0F);
      Body = new ModelRenderer(this, 188, 39);
      Body.addBox(0F, 0F, 0F, 16, 24, 8);
      Body.setRotationPoint(-8F, -24F, -4F);
      Body.setTextureSize(256, 128);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      LeftShoulder = new ModelRenderer(this, 0, 88);
      LeftShoulder.addBox(0F, 0F, 0F, 10, 8, 10);
      LeftShoulder.setRotationPoint(-18F, -24F, -5F);
      LeftShoulder.setTextureSize(256, 128);
      LeftShoulder.mirror = true;
      setRotation(LeftShoulder, 0F, 0F, 0F);
      RightShoulder = new ModelRenderer(this, 48, 88);
      RightShoulder.addBox(0F, 0F, 0F, 10, 8, 10);
      RightShoulder.setRotationPoint(8F, -24F, -5F);
      RightShoulder.setTextureSize(256, 128);
      RightShoulder.mirror = true;
      setRotation(RightShoulder, 0F, 0F, 0F);
      LeftArm = new ModelRenderer(this, 36, 0);
      LeftArm.addBox(0F, 0F, 0F, 8, 16, 8);
      LeftArm.setRotationPoint(-17F, -16F, -4F);
      LeftArm.setTextureSize(256, 128);
      LeftArm.mirror = true;
      setRotation(LeftArm, 0F, 0F, 0F);
      RightArm = new ModelRenderer(this, 76, 0);
      RightArm.addBox(0F, 0F, 0F, 8, 16, 8);
      RightArm.setRotationPoint(9F, -16F, -4F);
      RightArm.setTextureSize(256, 128);
      RightArm.mirror = true;
      setRotation(RightArm, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 180, 0);
      Head.addBox(0F, 0F, 0F, 16, 16, 16);
      Head.setRotationPoint(-8F, -40F, -8F);
      Head.setTextureSize(256, 128);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      RightHorn = new ModelRenderer(this, 139, 0);
      RightHorn.addBox(0F, 0F, 0F, 4, 8, 4);
      RightHorn.setRotationPoint(8F, -44F, -2F);
      RightHorn.setTextureSize(256, 128);
      RightHorn.mirror = true;
      setRotation(RightHorn, 0F, 0F, 0F);
      LeftHorn = new ModelRenderer(this, 120, 0);
      LeftHorn.addBox(0F, 0F, 0F, 4, 8, 4);
      LeftHorn.setRotationPoint(-12F, -44F, -2F);
      LeftHorn.setTextureSize(256, 128);
      LeftHorn.mirror = true;
      setRotation(LeftHorn, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    RightLeg.render(f5);
    LeftLeg.render(f5);
    Body.render(f5);
    LeftShoulder.render(f5);
    RightShoulder.render(f5);
    LeftArm.render(f5);
    RightArm.render(f5);
    Head.render(f5);
    RightHorn.render(f5);
    LeftHorn.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity){
	  this.RightLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.LeftLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.RightLeg.rotateAngleY = 0.0F;
      this.LeftLeg.rotateAngleY = 0.0F;
      
      this.RightArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      this.LeftArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.RightArm.rotateAngleZ = 0.0F;
      this.LeftArm.rotateAngleZ = 0.0F;
  }
  
 

}
