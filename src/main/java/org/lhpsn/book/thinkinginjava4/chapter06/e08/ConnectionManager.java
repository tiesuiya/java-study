package org.lhpsn.book.thinkinginjava4.chapter06.e08;

/**
 * @author tsy
 * @version 1.0
 */
public class ConnectionManager {

    private ConnectionManager() {
    }

    private static Connection[] connections;

    private static int number = 10;

    private static int index = number;

    static {
        connections = new Connection[number];
        for (int i = 0; i < number; i++) {
            connections[i] = Connection.makeConnection();
        }
    }

    public static Connection get() {
        if (index > 0) {
            return connections[--index];
        }
        return null;
    }
}
