package servlets;

public class Socket_start {
    public static void main(String[] args) throws Exception{
        String name_coins[] = {"BTC", "LTC", "ETH"};
        Thread threads [] = new Thread[name_coins.length];
        for (int i = 0; i < name_coins.length; i++) {
            threads [i] = new Thread(name_coins[i]);
            }
            int i = 1488;
            for (Thread currentThread : threads) {
                new Get_connection(String.valueOf(currentThread.getName()),i).start();
                i++;
            }

    }
}
