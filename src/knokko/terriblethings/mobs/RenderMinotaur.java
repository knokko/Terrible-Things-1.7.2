package terriblethings.mobs;

import terriblethings.main.R;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderMinotaur extends RenderLiving{

	private static final ResourceLocation texture = new ResourceLocation(R.t + "textures/entities/minotaur.png");
	protected ModelMinotaur modelEntity;

	public RenderMinotaur(ModelBase modelbase, float par2) {
		super(modelbase, par2);
		modelEntity = ((ModelMinotaur) mainModel);
	}
	public void renderMinotaur(EntityMinotaur entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderMinotaur((EntityMinotaur)entityLiving, x, y, z, u, v);
	}
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderMinotaur((EntityMinotaur)entity, x, y, z, u, v);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
