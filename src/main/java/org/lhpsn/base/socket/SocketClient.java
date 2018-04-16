package org.lhpsn.base.socket;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Socket Client
 *
 * @author lh
 * @since 1.0.0
 */
public class SocketClient {

    public static void main(String[] args) {

        SocketClient client;
        try {
            client = new SocketClient("127.0.0.1", 7777);
            client.startClient();
        } catch (IOException e) {
            throw new RuntimeException("创建连接失败！");
        }
    }

    private static final String CLIENT_EXIT_STR = "exit";
    private static final String CLOSE_ERROR = "关闭客户端失败！";
    private static final String RECEIVE_ERROR = "接收消息错误！";
    private static final String SEND_ERROR = "发送消息错误！";

    private String ip = null;
    private Integer port = null;
    private Socket socket = null;
    private ExecutorService pool = null;

    public SocketClient(String ip, Integer port) throws IOException {
        this.ip = ip;
        this.port = port;
        init();
    }

    private void init() throws IOException {
        socket = new Socket(ip, port);
        pool = new ThreadPoolExecutor(
                2,
                2,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactoryBuilder().setNameFormat("pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    public void startClient() {
        pool.submit(new Reader());
        pool.submit(new Writer());
    }

    private void closeClient() {
        try {
            socket.close();
            System.out.println("客户端已关闭");
        } catch (IOException e) {
            throw new RuntimeException(CLOSE_ERROR);
        }
    }

    private class Reader implements Runnable {

        BufferedReader reader = null;
        BufferedReader inputReader = null;

        @Override
        public void run() {
            try {
                inputReader = new BufferedReader(new InputStreamReader(System.in));
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputContent;
                while (!(inputContent = inputReader.readLine()).isEmpty()) {
                    System.out.println(inputContent + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(RECEIVE_ERROR);
            } finally {
                closeClient();
            }
        }
    }

    private class Writer implements Runnable {

        BufferedWriter writer = null;
        BufferedReader inputReader = null;

        @Override
        public void run() {
            try {
                inputReader = new BufferedReader(new InputStreamReader(System.in));
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String inputContent;
                while (!(inputContent = inputReader.readLine()).equals(CLIENT_EXIT_STR)) {
                    writer.write(inputContent);
                    writer.flush();
                }
                closeClient();
            } catch (IOException e) {
                throw new RuntimeException(SEND_ERROR);
            } finally {
                closeClient();
            }
        }
    }

//    public void start() {
//        BufferedReader inputReader = null;
//        BufferedWriter writer = null;
//        BufferedReader reader = null;
//        Socket socket = null;
//        // Alt + Shift + z    try...catch等快捷键
//        // 从Console读取内容
//        try {
//            socket = new Socket("127.0.0.1", 7777);
//            // 从socket进行写入
//            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            inputReader = new BufferedReader(new InputStreamReader(System.in));
//            String inputContent;
//            while (!(inputContent = inputReader.readLine()).equals("bye")) {
//                writer.write(inputContent + "\n");
//                writer.flush();
////              System.out.println(inputContent);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                writer.close();
//                inputReader.close();
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}  