package Pars;

import servlets.SOCKETS;

class Threads {
    private static String name_coins[] = {"BTC", "LTC", "ETH"};
    private static Thread threads [] = new Thread[name_coins.length];

    void start_parsing_and_regression() {
        try{

            for (int i = 0; i < name_coins.length; i++) {
                threads[i] = new Thread(name_coins[i]);
            }
            for (Thread currentThread : threads) {
                new Connection_to_http(String.valueOf(currentThread.getName())).start();
                new Regression(String.valueOf(currentThread.getName())).start();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    void start_sockets() throws Exception{
        Thread threads1[] = new Thread[name_coins.length];
        for (int i = 0; i < threads1.length; i++) {
            threads1[i] = new Thread(name_coins[i]);
        }
        int port = 1488;
        for (Thread thread : threads1) {
            new SOCKETS(port, String.valueOf(thread.getName())).Server_socket();
            port++;
        }

    }
}
