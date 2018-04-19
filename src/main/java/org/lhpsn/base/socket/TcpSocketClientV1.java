package org.lhpsn.base.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket Client v1
 * 实现：
 * 一读一写
 * 支持中文
 *
 * @author lh
 * @since 1.0.0
 */
public class TcpSocketClientV1 {

    public static void main(String[] args) throws Exception {

        TcpSocketClientV1 client = new TcpSocketClientV1("127.0.0.1", 7777);
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

    public TcpSocketClientV1(String ip, Integer port) throws IOException {
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
     * Start Client
     *
     * @throws IOException IO Exception
     */
    public void start() throws IOException {
        while (true) {
            // write
            String clientMsg = scanner.nextLine();
            dos.writeUTF(clientMsg);
            dos.flush();

            // read
            byte[] bytes = new byte[1024];
            int length = dis.read(bytes);
            String serverMsg = new String(bytes, 0, length);
            System.out.println(serverMsg);
        }
    }
}