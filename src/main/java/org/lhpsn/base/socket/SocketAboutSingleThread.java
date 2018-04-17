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
public class SocketAboutSingleThread {

    public static void main(String[] args) throws IOException {

        // test please call : telnet localhost 7777

        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            String serverAddress = serverSocket.getLocalSocketAddress().toString();
            System.out.println(String.format("Server Start with %s", serverAddress));

            while (true) {
                Socket clientSocket = serverSocket.accept();
                String clientAddress = clientSocket.getLocalSocketAddress().toString();
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
                        dataOutputStream.writeUTF(serverMessage);
                        System.out.println(String.format("Response to %s ’%s’", clientAddress, serverMessage));
                    }
                }
            }
        }
    }
}
