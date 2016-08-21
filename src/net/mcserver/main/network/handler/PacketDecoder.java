package net.mcserver.main.network.handler;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.mcserver.main.network.buffer.Buffer;

public class PacketDecoder extends MessageToMessageDecoder<Buffer> {
	@Override
	protected void decode(ChannelHandlerContext ctx, Buffer buffer, List<Object> out) throws Exception {
		int id = buffer.readVarInt();
		UnresolvedPacket packet = new UnresolvedPacket(id, buffer);
		out.add(packet);
	}

}