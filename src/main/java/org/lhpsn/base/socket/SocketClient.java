package org.lhpsn.base.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket Client
 *
 * @author lh
 * @since 1.0.0
 */
public class SocketClient {

    public static void main(String[] args) throws Exception {

        // 启动客户端 请配合使用SocketAboutSingleThread
        SocketClient client = new SocketClient("localhost", 7777);
        client.startClient();
    }

    private String ip = null;
    private Integer port = null;
    private DataInputStream dis = null;
    private DataOutputStream dos = null;
    private Scanner scanner = null;

    public SocketClient(String ip, Integer port) throws IOException {
        this.ip = ip;
        this.port = port;
        init();
    }

    private void init() throws IOException {
        Socket client = new Socket(ip, port);
        dos = new DataOutputStream(client.getOutputStream());
        dis = new DataInputStream(client.getInputStream());
        scanner = new Scanner(System.in);
    }

    public void startClient() throws IOException, InterruptedException {
        while (true) {
            // 先写
            String clientMsg = scanner.nextLine();
            dos.writeUTF(clientMsg);
            dos.flush();

            // 再读
            String serverMsg = dis.readUTF();
            System.out.println(serverMsg);
        }
    }

}