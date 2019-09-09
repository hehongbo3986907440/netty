package com.study.netty.wechat;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class WeCharClient {
    public static void main(String[] args) throws Exception{
        EventLoopGroup boosLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(boosLoopGroup);
            bootstrap.channel(NioSocketChannel.class).handler(new MyClientInitHandler());

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1",8899).sync();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                channelFuture.channel().writeAndFlush(br.readLine());
            }

        }finally {
            boosLoopGroup.shutdownGracefully();
        }
    }
}
