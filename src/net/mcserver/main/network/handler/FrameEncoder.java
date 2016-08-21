package net.mcserver.main.network.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.mcserver.main.network.packet.Packet;

public class FrameEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf out) throws Exception {
        //Buffer buffer = new Buffer(in);
        //buffer.writeVarInt(in.readableBytes());
        //out.writeBytes(in);
        System.out.println("test2");
    }
}
