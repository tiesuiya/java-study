package org.lhpsn.base.socket;

import java.io.IOException;
import java.net.*;

/**
 * UDP服务器
 *
 * @author lh
 * @since 1.0.0
 */
public class UdpSocketServer {

    public static void main(String[] args) {

        UdpSocketServer udpSocketServer = new UdpSocketServer(6666);
        udpSocketServer.start();
    }

    /**
     * Server port
     */
    private int serverPort;

    /**
     * Udp server
     */
    private DatagramSocket server;

    /**
     * 接收包
     */
    private DatagramPacket receivePacket;

    /**
     * 接收包
     */
    private DatagramPacket sendPacket;

    /**
     * Client address
     */
    private InetAddress clientAddress;

    /**
     * Client port
     */
    private int clientPort;

    /**
     * UDP 服务端构造器
     *
     * @param port 服务器端口
     * @throws SocketException Socket异常
     */
    public UdpSocketServer(int port) {
        this.serverPort = port;
        init();
    }

    /**
     * init
     *
     * @throws SocketException Init exception
     */
    private void init() {
        try {
            server = new DatagramSocket(serverPort);
        } catch (SocketException e) {
            System.out.println("启动UDP服务端时发生异常！");
            throw new RuntimeException(e);
        }
    }

    /**
     * Start UDP server
     */
    public void start() {

        while (true) {
            String receiveMsg;
            try {
                receiveMsg = receive();
                send(receiveMsg);
            } catch (IOException e) {
                System.out.println("传输异常！");
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 接收数据
     *
     * @return 收到的数据
     * @throws IOException 接收异常
     */
    private String receive() throws IOException {
        byte[] buf = new byte[1024];
        receivePacket = new DatagramPacket(buf, buf.length);
        server.receive(receivePacket);
        String data = new String(buf, 0, receivePacket.getLength(), "UTF-8");

        // 记录用户address和ip，用于发送
        clientAddress = receivePacket.getAddress();
        clientPort = receivePacket.getPort();
        return data;
    }

    /**
     * 发送数据
     *
     * @param msg 需要发送的数据
     * @throws IOException 发送异常
     */
    private void send(String msg) throws IOException {
        byte[] buf = msg.getBytes("UTF-8");
        sendPacket = new DatagramPacket(buf, buf.length, clientAddress, clientPort);
        server.send(sendPacket);
    }
}
