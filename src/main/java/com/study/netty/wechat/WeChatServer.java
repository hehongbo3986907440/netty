package com.study.netty.wechat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class WeChatServer {
    public static void main(String[] args) throws  Exception{
        EventLoopGroup boosLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workLoopGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosLoopGroup,workLoopGroup);
            serverBootstrap.channel(NioServerSocketChannel.class).childHandler(new WeCharInitHandler());

            ChannelFuture future = serverBootstrap.bind(8899).sync();

            future.channel().closeFuture().sync();
        }finally {
            boosLoopGroup.shutdownGracefully();
            workLoopGroup.shutdownGracefully();
        }
    }
}
