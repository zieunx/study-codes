package netty.basic.netty.echo;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

	private final int port = 8080;

	public static void main(String[] args) throws Exception {
		new EchoServer().start();
	}

	private void start() throws Exception {
		final EchoServerHandler serverHandler = new EchoServerHandler();
		EventLoopGroup group = new NioEventLoopGroup(); // EventLoopGroup 생성

		try {
			ServerBootstrap bootstrap = new ServerBootstrap(); // ServerBootstrap
			bootstrap.group(group)
				.channel(NioServerSocketChannel.class) // Nio 전송 채널을 이용하도록 지정
				.localAddress(new InetSocketAddress(port)) // 지정된 포트로 소캣 주소 설정
				.childHandler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel socketChannel) throws Exception { // EchoServerHandler 하나를 채널의 Channel Pipeline 으로 추가
						socketChannel.pipeline().addLast(serverHandler);
					}
				});
			ChannelFuture future = bootstrap.bind().sync(); // 서버를 비동기식으로 바인딩
			future.channel().closeFuture().sync(); // 채널의 closeFuture 를 얻고 완료될 때 까지 현재 스레드를 블로킹
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}
