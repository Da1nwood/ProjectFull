package Pars;

import servlets.Get_connection;

class Run_main {
        public static void main(String[] args){
            IWhereSet IWhereSet = new Get_info_for_db();
            Connection_to_http.iwhereSetI = IWhereSet;
            Threads threads = new Threads();
            threads.start_parsing();
            String name_coins[] = {"BTC", "LTC", "ETH"};
            Thread threads1 [] = new Thread[name_coins.length];
            for (int i = 0; i < name_coins.length; i++) {
                threads1 [i] = new Thread(name_coins[i]);
            }
            int i = 1488;
            for (Thread currentThread : threads1) {
                new Get_connection(String.valueOf(currentThread.getName()),i).start();
                i++;
            }


        }

    }

