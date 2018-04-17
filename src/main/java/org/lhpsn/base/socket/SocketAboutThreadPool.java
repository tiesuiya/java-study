package org.lhpsn.base.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 关于多线程（线程池）服务器
 *
 * @author lh
 * @since 1.0.0
 */
public class SocketAboutThreadPool {

    public static void main(String[] args) throws IOException {
        new ThreadPoolServer().run();
    }
}

/**
 * 多线程（线程池）服务器
 */
class ThreadPoolServer implements Runnable {

    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            String serverAddress = serverSocket.getLocalSocketAddress().toString();
            System.out.println(String.format("Server Start with %s", serverAddress));

            while (true) {
                Socket clientSocket = serverSocket.accept();

                pool.submit(new ClientHandle(clientSocket));
            }
        } catch (IOException e) {
            System.out.println("Server Exception:" + e.getLocalizedMessage());
            throw new RuntimeException(e);
        } finally {
            pool.shutdown();
        }
    }
}


/**
 * 客户端处理
 */
class ClientHandle implements Runnable {

    private Socket clientSocket;

    public ClientHandle(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        String clientAddress = clientSocket.getRemoteSocketAddress().toString();
        System.out.println(String.format("Client connected from %s", clientAddress));

        try (DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream())) {
            while (true) {
                String clientMessage = dataInputStream.readUTF();
                System.out.println(String.format("Request from %s ‘%s’", clientAddress, clientMessage));

                if ("exit".equals(clientMessage)) {
                    break;
                }

                // write message to client
                String serverMessage = "Hello " + clientMessage;
                dataOutputStream.write(serverMessage.getBytes());
                dataOutputStream.flush();
                System.out.println(String.format("Response to %s ’%s’", clientAddress, serverMessage));
            }
        } catch (IOException e) {
            System.out.println("Client Exception:" + e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }
}
