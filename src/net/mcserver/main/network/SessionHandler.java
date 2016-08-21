package net.mcserver.main.network;

import java.util.HashMap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SessionHandler extends ChannelInboundHandlerAdapter {
	static final HashMap<Channel,Session> sessions = new HashMap<>();

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    	Session s = new Session(ctx.channel());
        sessions.put(ctx.channel(),s);
        System.out.println("Session connected [" +sessions.size() + "]: " + ctx.channel().remoteAddress());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        sessions.remove(ctx.channel());
        System.out.println("Session disconnected [" + sessions.size() + "]: " + ctx.channel().remoteAddress());
    }

    static Session getSession(Channel channel){
        return sessions.get(channel);
    }

}