package org.lhpsn.base.socket;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * UDP客户端
 *
 * @author lh
 * @since 1.0.0
 */
public class UdpSocketClient {

    public static void main(String[] args) {

        try {
            UdpSocketClient udpSocketClient = new UdpSocketClient("127.0.0.1", 6666);
            udpSocketClient.start();
        } catch (SocketException e) {
            System.out.println("启动UDP客户端时发生异常！");
        } catch (UnknownHostException e) {
            System.out.println("端口异常！");
        }
    }

    /**
     * "退出"常量
     */
    private static final String EXIT_FLAG = "exit";

    /**
     * Server address
     */
    private InetAddress serverAddress;

    /**
     * Server port
     */
    private int serverPort;

    /**
     * Udp client
     */
    private DatagramSocket client;

    /**
     * 接收包
     */
    private DatagramPacket receivePacket;

    /**
     * 接收包
     */
    private DatagramPacket sendPacket;

    /**
     * 键盘扫描器
     */
    private Scanner scanner;

    /**
     * UDP 客户端构造器
     *
     * @param ip   服务端ip
     * @param port 服务器端口
     * @throws SocketException      Socket异常
     * @throws UnknownHostException 未知端口异常
     */
    public UdpSocketClient(String ip, int port) throws SocketException, UnknownHostException {
        this.serverAddress = InetAddress.getByName(ip);
        this.serverPort = port;
        init();
    }

    /**
     * init
     *
     * @throws SocketException Init exception
     */
    private void init() throws SocketException {
        client = new DatagramSocket();
        scanner = new Scanner(System.in);
    }

    /**
     * Start UDP client
     */
    public void start() {
        String userEnter;
        while (!EXIT_FLAG.equals(userEnter = scanner.nextLine())) {
            try {
                send(userEnter);
                String serverMsg = receive();

                // Print server message
                System.out.println(serverMsg);
            } catch (IOException e) {
                throw new RuntimeException("传输异常！");
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
        client.receive(receivePacket);
        return new String(buf, 0, receivePacket.getLength(), "UTF-8");
    }

    /**
     * 发送数据
     *
     * @param msg 需要发送的数据
     * @throws IOException 发送异常
     */
    private void send(String msg) throws IOException {
        byte[] buf = msg.getBytes("UTF-8");
        sendPacket = new DatagramPacket(buf, buf.length, serverAddress, serverPort);
        client.send(sendPacket);
    }
}
