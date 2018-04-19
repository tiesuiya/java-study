package org.lhpsn.base.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 关于单线程服务器
 *
 * @author lh
 * @since 1.0.0
 */
public class TcpSocketServerAboutSingleThread {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println(String.format("Server Start with %s", serverSocket.getLocalSocketAddress()));

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println(String.format("Client connected from %s", clientSocket.getLocalSocketAddress()));

                try (DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream())) {

                    while (true) {
                        // read
                        String clientMessage = dataInputStream.readUTF();
                        System.out.println(String.format("Request from %s ‘%s’", clientSocket.getLocalSocketAddress(), clientMessage));

                        if ("exit".equals(clientMessage)) {
                            break;
                        }

                        // write
                        String serverMessage = "Hello " + clientMessage;
                        dataOutputStream.write(serverMessage.getBytes());
                        dataOutputStream.flush();
                        System.out.println(String.format("Response to %s ’%s’", clientSocket.getLocalSocketAddress(), serverMessage));
                    }
                }
            }
        }
    }
}
