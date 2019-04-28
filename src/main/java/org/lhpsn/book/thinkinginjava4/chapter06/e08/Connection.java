package org.lhpsn.book.thinkinginjava4.chapter06.e08;

class Connection {
    private Connection() {

    }

    static Connection makeConnection() {
        return new Connection();
    }
}