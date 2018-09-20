package terriblethings.mobs;

import terriblethings.main.R;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderFirebird extends RenderLiving{

	private static final ResourceLocation texture = new ResourceLocation(R.t + "textures/entities/firebird.png");
	protected ModelFirebird modelEntity;


	public RenderFirebird(ModelBase modelbase, float a) {
		super(modelbase, a);
		modelEntity = ((ModelFirebird) mainModel);
	}
	public void renderFirebird(EntityFirebird entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
		
	}
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderFirebird((EntityFirebird)entityLiving, x, y, z, u, v);
	}
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderFirebird((EntityFirebird)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}
