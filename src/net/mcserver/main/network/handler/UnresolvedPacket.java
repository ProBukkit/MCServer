package net.mcserver.main.network.handler;

import net.mcserver.main.network.buffer.Buffer;

public class UnresolvedPacket {
    private int id;
    private Buffer buffer;

    public UnresolvedPacket(int id, Buffer buffer){
        this.id = id;
        this.buffer = buffer;
    }

    public int getId(){
        return this.id;
    }

    public Buffer getBuffer(){
        return this.buffer;
    }
}
