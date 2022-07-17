// Date: 1/8/2017 8:40:00 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package com.mraof.minestuck.client.model;

import com.mraof.minestuck.entity.consort.ConsortEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class TurtleModel<T extends ConsortEntity> extends HierarchicalModel<T>
{
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart leg1, leg2;
	private final ModelPart tail;
	private final ModelPart body;
	private final ModelPart shell, shellRim;
	private final ModelPart nose;
	
	public TurtleModel(ModelPart root)
	{
		this.root = root;
		head = root.getChild("head");
		leg1 = root.getChild("leg1");
		leg2 = root.getChild("leg2");
		tail = root.getChild("tail");
		body = root.getChild("body");
		shell = root.getChild("shell");
		shellRim = root.getChild("shell_rim");
		nose = root.getChild("nose");
	}
	
	public static LayerDefinition createBodyLayer()
	{
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		
		root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2, -4, -4, 4, 4, 5),
				PartPose.offset(-0.5F, 12, 1));
		root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(32, 0)
						.addBox(-1, 0, -1, 2, 4, 2),
				PartPose.offset(1, 20, 1));
		root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(32, 6)
						.addBox(-1, 0, -1, 2, 4, 2),
				PartPose.offset(-2, 20, 1));
		root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(48, 0)
						.addBox(-1, -1, 0, 3, 4, 1),
				PartPose.offsetAndRotation(-1, 20, 2, 0.2974289F, 0, 0));
		root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 52)
						.addBox(-3, -1, -2, 5, 4, 8),
				PartPose.offsetAndRotation(0, 18, -1, 1.570796F, 0, 0));
		root.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 18)
						.addBox(-2, -1, -4, 5, 2, 7),
				PartPose.offsetAndRotation(-1, 15, 4, 1.570796F, 0, 0));
		root.addOrReplaceChild("shell_rim", CubeListBuilder.create().texOffs(0, 34)
						.addBox(-3, -1, -3, 6, 1, 8),
				PartPose.offsetAndRotation(-0.5F, 16.5F, 3, 1.570796F, 0, 0));
		root.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(48, 5)
						.addBox(-1, -1, -1, 3, 2, 1),
				PartPose.offset(-1.1F, 10.5F, -3));
		
		return LayerDefinition.create(mesh, 64, 64);
	}
	
	@Override
	public ModelPart root()
	{
		return root;
	}
	
	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}