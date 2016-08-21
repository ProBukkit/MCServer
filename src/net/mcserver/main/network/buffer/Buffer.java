package net.mcserver.main.network.buffer;

import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;

public class Buffer {

    private ByteBuf buffer;

    public Buffer(ByteBuf buffer){
        this.buffer = buffer;
    }

    public int readVarInt() {
        int value = 0;
        int i = 0;
        int b;
        while (((b = this.buffer.readByte()) & 0x80) != 0) {
            value |= (b & 0x7F) << i;
            i += 7;
            if (i > 35) {
                throw new IllegalArgumentException("Variable length quantity is too long");
            }
        }
        return value | (b << i);
    }

    public void writeVarInt(int value) {
        while ((value & 0xFFFFFF80) != 0L) {
            this.buffer.writeByte((value & 0x7F) | 0x80);
            value >>>= 7;
        }
        this.buffer.writeByte(value & 0x7F);
    }

    public void writeString(String s){
        byte[] b = s.getBytes(Charsets.UTF_8);
        writeVarInt(b.length);
        this.buffer.writeBytes(b);
    }
}
