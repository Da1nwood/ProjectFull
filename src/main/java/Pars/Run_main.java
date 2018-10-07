package Pars;

import servlets.SOCKETS;

class Run_main {
    public static void main(String[] args) throws Exception {
        IWhereSet IWhereSet = new Get_info_for_db();
        Connection_to_http.iwhereSetI = IWhereSet;
        Threads threads = new Threads();
        threads.start_parsing_and_regression();
        threads.start_sockets();

    }
}

