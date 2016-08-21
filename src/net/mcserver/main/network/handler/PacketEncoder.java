package net.mcserver.main.network.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.mcserver.main.network.buffer.Buffer;

public class PacketEncoder extends MessageToByteEncoder<ByteBuf> {
        @Override
        protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf in, ByteBuf out) throws Exception {
            System.out.println("debug");
            Buffer buffer = new Buffer(out);
            buffer.writeVarInt(0x00);
        }
    }
