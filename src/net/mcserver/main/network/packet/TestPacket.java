package net.mcserver.main.network.packet;

import net.mcserver.main.network.buffer.Buffer;

public class TestPacket extends Packet {
    @Override
    public void toBuffer(Buffer buffer) {
        buffer.writeVarInt(0x00);
    }

    @Override
    public void fromBuffer(Buffer buffer) {

    }
}
