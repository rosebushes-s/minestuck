package com.mraof.minestuck.network.computer;

import com.mraof.minestuck.Minestuck;
import com.mraof.minestuck.blockentity.ComputerBlockEntity;
import com.mraof.minestuck.network.MSPacket;
import com.mraof.minestuck.skaianet.ComputerInteractions;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class ResumeSburbConnectionPacket implements MSPacket.PlayToServer
{
	public static final ResourceLocation ID = Minestuck.id("resume_sburb_connection");
	
	private final BlockPos pos;
	private final boolean isClient;
	
	private ResumeSburbConnectionPacket(BlockPos pos, boolean isClient)
	{
		this.pos = pos;
		this.isClient = isClient;
	}
	
	public static ResumeSburbConnectionPacket asClient(ComputerBlockEntity be)
	{
		return new ResumeSburbConnectionPacket(be.getBlockPos(), true);
	}
	
	public static ResumeSburbConnectionPacket asServer(ComputerBlockEntity be)
	{
		return new ResumeSburbConnectionPacket(be.getBlockPos(), false);
	}
	
	@Override
	public ResourceLocation id()
	{
		return ID;
	}
	
	@Override
	public void write(FriendlyByteBuf buffer)
	{
		buffer.writeBlockPos(pos);
		buffer.writeBoolean(isClient);
	}
	
	public static ResumeSburbConnectionPacket read(FriendlyByteBuf buffer)
	{
		BlockPos computer = buffer.readBlockPos();
		boolean isClient = buffer.readBoolean();
		return new ResumeSburbConnectionPacket(computer, isClient);
	}
	
	@Override
	public void execute(ServerPlayer player)
	{
		ComputerBlockEntity.forNetworkIfPresent(player, pos,
				computer -> {
					var interactions = ComputerInteractions.get(player.server);
					if(isClient)
						interactions.resumeClientConnection(computer);
					else
						interactions.resumeServerConnection(computer);
				});
	}
}