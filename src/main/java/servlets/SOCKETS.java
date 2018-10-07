package servlets;

import Pars.Properties;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class SOCKETS {
    public int PORT;
    public String name_crypto;
    public LinkedList<Socket_threads> serverList = new LinkedList<>();

    public SOCKETS(int PORT, String name_crypto) {
        this.PORT = PORT;
        this.name_crypto = name_crypto;
    }

    public void Server_socket() throws Exception{
            ServerSocket server = new ServerSocket(PORT);
            try {
                while (true) {
                    Socket socket = server.accept();
                    try {
                        serverList.add(new Socket_threads(socket,name_crypto));
                    } catch (IOException e) {
                        socket.close();
                    }
                }
            } finally {
                server.close();
            }
        }
}

