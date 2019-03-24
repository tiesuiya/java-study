//package org.lhpsn.base.multithread;
//
///**
// * 关于多线程的信号量
// *
// * @author http://redspider.group:4000/article/01/5.html
// * @since 1.0.0
// */
//public class MultiThreadAboutVolatile {
// 感觉有问题
//    public static void main(String[] args) {
//        new Thread(new ThreadA()).start();
//        new Thread(new ThreadB()).start();
//    }
//
//    private static int signal = 0;
//
//    static class ThreadA implements Runnable {
//        @Override
//        public void run() {
//            while (signal < 5) {
//                if (signal % 2 == 0) {
//                    System.out.println("ThreadA:" + signal);
//                    synchronized (this) {
//                        signal++;
//                    }
//                }
//            }
//        }
//    }
//
//    static class ThreadB implements Runnable {
//        @Override
//        public void run() {
//            while (signal < 5) {
//                if (signal % 2 == 1) {
//                    System.out.println("ThreadB:" + signal);
//                    synchronized (this) {
//                        signal++;
//                    }
//                }
//            }
//        }
//    }
//}
