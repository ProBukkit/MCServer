package net.mcserver.main.network;

import io.netty.channel.Channel;

public class Session {
    private Channel channel;

    public Session(Channel channel){
        this.channel = channel;
    }
}
