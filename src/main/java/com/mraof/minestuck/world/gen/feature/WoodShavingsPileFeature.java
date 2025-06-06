package com.mraof.minestuck.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mraof.minestuck.Minestuck;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class WoodShavingsPileFeature extends Feature<NoneFeatureConfiguration>
{
	private static final ResourceLocation WOOD_SHAVINGS_PILE = ResourceLocation.fromNamespaceAndPath(Minestuck.MOD_ID, "wood_shavings_pile");
	
	public WoodShavingsPileFeature(Codec<NoneFeatureConfiguration> codec)
	{
		super(codec);
	}
	
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context)
	{
		WorldGenLevel level = context.level();
		StructureTemplate template = level.getLevel().getStructureManager().getOrCreate(WOOD_SHAVINGS_PILE);
		BlockPos centerPos = context.origin();
		TemplatePlacement placement = TemplatePlacement.centeredWithRandomRotation(template, centerPos, context.random());
		
		int y = placement.minHeight(Heightmap.Types.WORLD_SURFACE_WG, level);
		placement.placeAt(y, context);
		
		return true;
	}
}