package com.mraof.minestuck.player;

import com.mojang.serialization.Codec;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;

import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

/**
 * An aspect version of <code>EnumClass</code> that works pretty much the same way as the <code>EnumClass</code> except
 * that it doesn't have any special types.
 * The <code>toString()</code> method is overridden and returns a lower cased version of the aspect name.
 * @author kirderf1
 */
public enum EnumAspect implements StringRepresentable    //TODO This could potentially be changed to a registry. However note difficulties with the title land aspect registry
{
	BLOOD,BREATH,DOOM,HEART,HOPE,LIFE,LIGHT,MIND,RAGE,SPACE,TIME,VOID;
	
	public static final Codec<EnumAspect> CODEC = StringRepresentable.fromEnum(EnumAspect::values);
	
	/**
	 * This method generates one of the 12 aspects that is not specified in the
	 * <code>unavailableAspects</code> array. Beware that this method is not compatible with duplicates in the array.
	 * @param unavailableAspects An <code>EnumSet&#60;EnumAspect&#62;</code> that includes the aspects that it won't choose from.
	 * Compatible with the value null.
	 * @return null if <code>unavailableAspects</code> contains 12 or more aspects or
	 * an <code>EnumAspect</code> of the chosen aspect.
	 */
	public static EnumAspect getRandomAspect(EnumSet<EnumAspect> unavailableAspects, RandomSource rand)
	{
		if(unavailableAspects == null)
			unavailableAspects = EnumSet.noneOf(EnumAspect.class);
		if(unavailableAspects.size() == 12)
			return null;	//No aspect available to generate
		int aspectInt = rand.nextInt(12 - unavailableAspects.size());
		EnumAspect[] list = values();
		for(EnumAspect aspect : list)
			if(!unavailableAspects.contains(aspect))
			{
				if(aspectInt == 0)
					return aspect;
				aspectInt--;
			}
		return null;
	}
	
	/**
	 * Used to get a title-aspect based on index. Used when reading a title-aspect from nbt.
	 * The index value is matched with the return of <code>getIntFromAspect</code>
	 * @param i The index number.
	 * @return the title-aspect
	 */
	public static EnumAspect getAspectFromInt(int i)
	{
		if(i < 0 || i >= EnumAspect.values().length)
			return null;
		return EnumAspect.values()[i];
	}
	
	/**
	 * Gives the index for the aspect. Used when writing a title-aspect to nbt.
	 * When reading a title-aspect from nbt, <code>getAspectFromInt</code> should be used to return the index to a title-aspect.
	 * @param e The title-aspect to convert.
	 * @return an index number that matches this title-aspect
	 */
	public static int getIntFromAspect(EnumAspect e)
	{
		return e.ordinal();
	}
	
	/**
	 * Takes the enum name for this title-aspect and returns a lowercase version.
	 * @return the name of this title-aspect
	 */
	@Override
	public String getSerializedName()
	{
		return this.name().toLowerCase(Locale.ROOT);
	}
	
	@Override
	public String toString()
	{
		return this.getSerializedName();
	}
	
	public static EnumAspect fromString(String string)
	{
		for(EnumAspect a : values())
		{
			if(a.getSerializedName().equalsIgnoreCase(string))
				return a;
		}
		return null;
	}
	
	/**
	 * Creates a text component for this title-aspect that will be translated client-side.
	 * Used for messages from the mod that for example will be sent trough chat.
	 * @return a text component that will translate into the name of the title-aspect
	 */
	public Component asTextComponent()
	{
		return Component.translatable(getTranslationKey());
	}
	
	public String getTranslationKey()
	{
		return "title.aspect." + this.getSerializedName();
	}
	
	public static Set<EnumAspect> valuesSet()
	{
		return EnumSet.allOf(EnumAspect.class);
	}
}
