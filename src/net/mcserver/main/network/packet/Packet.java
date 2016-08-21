package net.mcserver.main.network.packet;

import net.mcserver.main.network.buffer.Buffer;

public abstract class Packet {

    public abstract void toBuffer(Buffer buffer);
    public abstract void fromBuffer(Buffer buffer);
}
