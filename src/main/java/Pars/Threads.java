package Pars;

class Threads {
    private static String name_coins[] = {"BTC", "LTC", "ETH"};
    private static Thread threads [] = new Thread[name_coins.length];

    void start_parsing() {

        for (int i = 0; i < name_coins.length; i++) {
            threads [i] = new Thread(name_coins[i]);
        }
        for (Thread currentThread : threads) {
            new Connection_to_http(String.valueOf(currentThread.getName())).start();
        }
    }

    public Thread[] getmThreadList() {
        return threads;
    }
}
