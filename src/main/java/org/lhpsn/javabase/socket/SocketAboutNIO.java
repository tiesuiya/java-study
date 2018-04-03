package org.lhpsn.javabase.socket;

import java.io.IOException;
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
public class SocketAboutNIO {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(7777));
        System.out.println(String.format("Server Start with %s", serverSocketChannel.getLocalAddress()));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

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
                    clientChannel.read(buffer);
                    String request = new String(buffer.array()).trim();
                    System.out.println(String.format("Request from %s ‘%s’", clientChannel.getRemoteAddress(), request));
                    buffer.clear();
                    String response = "Hello " + request;
                    clientChannel.write(ByteBuffer.wrap((response + "\n").getBytes()));
                }
                // remove
                keyIterator.remove();
            }
        }

    }
}
