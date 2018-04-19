package org.lhpsn.base.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket Client v2
 * 实现：
 * 支持中文
 * 自由读写
 *
 * @author lh
 * @since 1.0.0
 */
public class TcpSocketClientV2 {

    public static void main(String[] args) throws Exception {

        TcpSocketClientV2 client = new TcpSocketClientV2("127.0.0.1", 7777);
        client.start();
    }

    /**
     * IP参数
     */
    private String ip;

    /**
     * 端口参数
     */
    private Integer port;

    /**
     * Socket客户端
     */
    private Socket client;

    /**
     * 数据输出流
     */
    private DataInputStream dis;

    /**
     * 数据输入流
     */
    private DataOutputStream dos;

    /**
     * 键盘输入流
     */
    private Scanner scanner;

    /**
     * 构造客户端
     *
     * @param ip   服务器IP
     * @param port 服务器端口
     * @throws IOException
     */
    public TcpSocketClientV2(String ip, Integer port) throws IOException {
        this.ip = ip;
        this.port = port;
        init();
    }

    /**
     * Init Client
     *
     * @throws IOException IO Exception
     */
    private void init() throws IOException {
        client = new Socket(ip, port);
        dos = new DataOutputStream(client.getOutputStream());
        dis = new DataInputStream(client.getInputStream());
        scanner = new Scanner(System.in);
    }

    /**
     * Start Method
     */
    private void start() {
        new Thread(new Receive()).start();
        new Thread(new Send()).start();
    }

    /**
     * Send message inner class
     */
    class Send implements Runnable {

        @Override
        public void run() {
            while (true) {
                // write
                String clientMsg = scanner.nextLine();
                try {
                    dos.writeUTF(clientMsg);
                    dos.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Receive message inner class
     */
    class Receive implements Runnable {

        @Override
        public void run() {
            while (true) {
                // read
                try {
                    byte[] bytes = new byte[1024];
                    int length = dis.read(bytes);
                    String serverMsg = new String(bytes, 0, length);
                    System.out.println(serverMsg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}