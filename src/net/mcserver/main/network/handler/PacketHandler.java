package net.mcserver.main.network.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.mcserver.main.network.packet.Packet;
import net.mcserver.main.network.packet.TestPacket;
import net.mcserver.main.network.packet.handshake.HandshakeRequestPacket;

public class PacketHandler extends SimpleChannelInboundHandler<UnresolvedPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, UnresolvedPacket unresolvedPacket)
            throws Exception {
        System.out.println(unresolvedPacket.getId()==0x00);
        /**
        JSONObject response = new JSONObject()
                .put("version", new JSONObject()
                        .put("name", "1.8.7")
                        .put("protocol", 47))
                .put("players", new JSONObject()
                        .put("max", 100)
                        .put("online", 5)
                        .put("sample", new JSONArray()
                                .put(new JSONObject()
                                        .put("name", "thinkofdeath")
                                        .put("id", "4566e69f-c907-48ee-8d71-d7ba5aa00d20"))))
                .put("description", new JSONObject()
                        .put("text", "Hello world"));
        unresolvedPacket.getBuffer().writeString(response.toString());
         **/
        ctx.writeAndFlush(new TestPacket());
    }
}
