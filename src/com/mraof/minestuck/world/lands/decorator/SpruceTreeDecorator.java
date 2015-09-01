package com.mraof.minestuck.world.lands.decorator;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class SpruceTreeDecorator extends TreeDecoratorBase
{
	protected WorldGenTaiga1 tree1 = new WorldGenTaiga1();
	protected WorldGenTaiga2 tree2 = new WorldGenTaiga2(false);
	
	@Override
	protected int getTreesPerChunk(Random rand)
	{
		return Math.max(0, rand.nextInt(10) - 7);
	}

	@Override
	protected WorldGenAbstractTree getTreeToGenerate(World world, BlockPos pos, Random rand)
	{
		return rand.nextBoolean() ? tree1 : tree2;
	}

}
