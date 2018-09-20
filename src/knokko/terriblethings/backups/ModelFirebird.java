package terriblethings.backups;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFirebird extends ModelBase{
	//fields
	ModelRenderer body;
	ModelRenderer leftWing;
	ModelRenderer rightWing;
	ModelRenderer LeftLeg;
	ModelRenderer RightLeg;
	ModelRenderer head;
	
	public ModelFirebird(){
		textureWidth = 256;
	    textureHeight = 128;
	    
	    
	    body = new ModelRenderer(this, 188, 39);
	      body.addBox(0F, 10F, 0F, 40, 20, 80);
	      body.setRotationPoint(-8F, -24F, -4F);
	      body.setTextureSize(256, 128);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      
	      head = new ModelRenderer(this, 100, 50);
	      head.addBox(7, 10, -30, 25, 15, 30);
	      head.setRotationPoint(-8F, -24F, -4F);
	      head.setTextureSize(256, 128);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      
	      leftWing = new ModelRenderer(this, 100, 150);
	      leftWing.addBox(40F, -38F, 0F, 60, 10, 30);
	      leftWing.setRotationPoint(-8F, 24F, -4F);
	      leftWing.setTextureSize(256, 128);
	      leftWing.mirror = true;
	      setRotation(leftWing, 0F, 0F, 0F);
	      
	      rightWing = new ModelRenderer(this, 100, 150);
	      rightWing.addBox(0F, -38F, 0F, -60,  10,  30);
	      rightWing.setRotationPoint(-8F, 24F, -4F);
	      rightWing.setTextureSize(256, 128);
	      rightWing.mirror = true;
	      setRotation(rightWing, 0F, 0F, 0F);
	      
	      RightLeg = new ModelRenderer(this, 200, 188);
	      RightLeg.addBox(25F, 6F, 20F, 8, 50, 8);
	      RightLeg.setRotationPoint(0F, 0F, -4F);
	      RightLeg.setTextureSize(256, 128);
	      RightLeg.mirror = true;
	      setRotation(RightLeg, 0F, 0F, 0F);
	      
	      LeftLeg = new ModelRenderer(this,200, 188);
	      LeftLeg.addBox(0F, 6F, 20F, 8, 50, 8);
	      LeftLeg.setRotationPoint(-8F, 0F, -4F);
	      LeftLeg.setTextureSize(256, 128);
	      LeftLeg.mirror = true;
	      setRotation(LeftLeg, 0F, 0F, 0F);
	    	  
	      
	}
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    body.render(f5);
	    head.render(f5);
	    leftWing.render(f5);
	    rightWing.render(f5);
	    RightLeg.render(f5);
	    LeftLeg.render(f5);
	  }
	private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }

}

