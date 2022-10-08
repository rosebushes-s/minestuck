package com.mraof.minestuck.data.tag;

import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.item.crafting.alchemy.GristType;
import com.mraof.minestuck.item.crafting.alchemy.GristTypes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;
import org.jetbrains.annotations.Nullable;

import static com.mraof.minestuck.item.crafting.alchemy.GristTypes.*;

public final class MSGristTypeTagsProvider extends ForgeRegistryTagsProvider<GristType>
{
	public MSGristTypeTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(pGenerator, GristTypes.getRegistry(), Minestuck.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags()
	{
		tag(AMBER.get().getSecondaryTypesTag()).add(RUST.get(), SULFUR.get());
		tag(CAULK.get().getSecondaryTypesTag()).add(IODINE.get(), CHALK.get());
		tag(CHALK.get().getSecondaryTypesTag()).add(SHALE.get(), MARBLE.get());
		tag(IODINE.get().getSecondaryTypesTag()).add(AMBER.get(), CHALK.get());
		tag(SHALE.get().getSecondaryTypesTag()).add(MERCURY.get(), TAR.get());
		tag(TAR.get().getSecondaryTypesTag()).add(AMBER.get(), COBALT.get());
		
		tag(COBALT.get().getSecondaryTypesTag()).add(RUBY.get(), AMETHYST.get());
		tag(MARBLE.get().getSecondaryTypesTag()).add(CAULK.get(), AMETHYST.get());
		tag(MERCURY.get().getSecondaryTypesTag()).add(COBALT.get(), RUST.get());
		tag(QUARTZ.get().getSecondaryTypesTag()).add(MARBLE.get(), URANIUM.get());
		tag(SULFUR.get().getSecondaryTypesTag()).add(IODINE.get(), TAR.get());
		
		tag(AMETHYST.get().getSecondaryTypesTag()).add(QUARTZ.get(), GARNET.get());
		tag(GARNET.get().getSecondaryTypesTag()).add(RUBY.get(), GOLD.get());
		tag(RUBY.get().getSecondaryTypesTag()).add(QUARTZ.get(), DIAMOND.get());
		tag(RUST.get().getSecondaryTypesTag()).add(SHALE.get(), GARNET.get());
		
		tag(DIAMOND.get().getSecondaryTypesTag()).add(GOLD.get());
		tag(GOLD.get().getSecondaryTypesTag()).add(URANIUM.get());
		tag(URANIUM.get().getSecondaryTypesTag()).add(DIAMOND.get());
	}
	
	@Override
	public String getName()
	{
		return "Minestuck Grist Type Tags";
	}
}
