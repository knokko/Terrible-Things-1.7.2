package terriblethings.mobs;

import terriblethings.main.R;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderBreaker extends RenderLiving {
	private static final ResourceLocation texture = new ResourceLocation(R.t + "textures/entities/breaker.png");
	protected ModelBiped modelEntity;

	public RenderBreaker(ModelBase modelbase, float par2) {
		super(modelbase, par2);
		modelEntity = ((ModelBiped) mainModel);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
	public void renderBreaker(EntityBreaker entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderBreaker((EntityBreaker)entityLiving, x, y, z, u, v);
	}
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderBreaker((EntityBreaker)entity, x, y, z, u, v);
	}
}
