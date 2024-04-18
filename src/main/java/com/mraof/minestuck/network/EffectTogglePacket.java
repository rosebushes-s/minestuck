package com.mraof.minestuck.network;

import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.player.PlayerData;
import com.mraof.minestuck.player.PlayerSavedData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class EffectTogglePacket implements MSPacket.PlayToServer
{
	public static final ResourceLocation ID = Minestuck.id("effect_toggle");
	
	public static final String ON = "minestuck.aspect_effects.on";
	public static final String OFF = "minestuck.aspect_effects.off";
	
	@Override
	public ResourceLocation id()
	{
		return ID;
	}
	
	@Override
	public void write(FriendlyByteBuf buffer)
	{
	}
	
	public static EffectTogglePacket read(FriendlyByteBuf ignored)
	{
		return new EffectTogglePacket();
	}
	
	@Override
	public void execute(ServerPlayer player)
	{
		PlayerData data = PlayerSavedData.getData(player);
		data.effectToggle(!data.effectToggle());
		if(data.effectToggle())
		{
			player.displayClientMessage(Component.translatable(ON), true);
		} else
		{
			player.displayClientMessage(Component.translatable(OFF), true);
		}
	}
}