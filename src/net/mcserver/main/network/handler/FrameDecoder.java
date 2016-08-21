package net.mcserver.main.network.handler;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import net.mcserver.main.network.buffer.Buffer;

import java.util.List;

public class FrameDecoder extends ReplayingDecoder<Buffer> {

    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        Buffer in = new Buffer(buf);
        int length = in.readVarInt();
        Buffer buffer = new Buffer(buf.readBytes(length));
        out.add(buffer);
    }
}
