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
public class SocketClientV1 {

    public static void main(String[] args) throws Exception {

        SocketClientV1 client = new SocketClientV1("127.0.0.1", 7777);
        client.start();
    }

    private String ip = null;
    private Integer port = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private Scanner scanner = null;

    public SocketClientV1(String ip, Integer port) throws IOException {
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
        Socket client = new Socket(ip, port);
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