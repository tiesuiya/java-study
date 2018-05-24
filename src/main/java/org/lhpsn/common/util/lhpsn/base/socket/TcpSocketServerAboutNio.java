package org.lhpsn.common.util.lhpsn.base.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 关于NIO服务器
 *
 * @author lh
 * @since 1.0.0
 */
public class TcpSocketServerAboutNio {

    public static void main(String[] args) throws IOException {

        System.out.println("使用Nio实现异步服务器");

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置阻塞为false
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(7777));
        System.out.println(String.format("Server Start with %s", serverSocketChannel.getLocalAddress()));

        // 注册selector为accept
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer;

        while (true) {
            int selected = selector.select();
            if (selected == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = serverChannel.accept();
                    System.out.println(String.format("Client connected from %s", clientChannel.getRemoteAddress()));

                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    // TODO 改为清空对象
                    buffer = ByteBuffer.allocate(1024);
                    clientChannel.read(buffer);
                    String request = new String(buffer.array(), "UTF-8").trim();
                    System.out.println(String.format("Request from %s ‘%s’", clientChannel.getRemoteAddress(), request));
                    String response = "Hello " + request;
                    clientChannel.write(ByteBuffer.wrap((response).getBytes()));
                }
                // remove
                keyIterator.remove();
            }
        }

    }
}
