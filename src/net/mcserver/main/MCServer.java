package net.mcserver.main;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import net.mcserver.main.network.SessionHandler;
import net.mcserver.main.network.handler.*;

public class MCServer {
	
	private int port;
	
	public MCServer(int port) {
		this.port = port;
	}

	public void run() throws Exception {
    	
    	EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    	EventLoopGroup workerGroup = new NioEventLoopGroup();
    	 try {
    		 ServerBootstrap b = new ServerBootstrap();
    		 b.group(bossGroup, workerGroup)
    		 .channel(NioServerSocketChannel.class)
    		 .option(ChannelOption.SO_KEEPALIVE, true)
    		 .option(ChannelOption.TCP_NODELAY, true)
                     .handler(new LoggingHandler(LogLevel.ERROR))
			 .childHandler(new ChannelInitializer<SocketChannel>() {
				 @Override
				 public void initChannel(SocketChannel ch) throws Exception {
					 ChannelPipeline pipeline = ch.pipeline();
					 pipeline
                             .addLast(new LoggingHandler(LogLevel.ERROR))
							 .addLast("FrameDecoder", new FrameDecoder())
					         .addLast("PacketDecoder", new PacketDecoder())
					         .addLast("PacketHandler", new PacketHandler())
					         .addLast("SessionHandler", new SessionHandler())
                             .addLast("FrameEncoder", new FrameEncoder())
                             .addLast("PacketEncoder", new PacketEncoder());
				 }
			 });
    		 
    		 
    		 ChannelFuture f = b.bind(port).sync(); 
    		 
    		 f.channel().closeFuture().sync();
    		 f.channel().close().awaitUninterruptibly();
    	 } finally {
    		 bossGroup.shutdownGracefully();
    		 workerGroup.shutdownGracefully();
    	 }
	}
	
	public static void main(String[] args) throws Exception {
		new MCServer(25551).run();
	}
}
