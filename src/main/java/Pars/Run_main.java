package Pars;

class Run_main {
        public static void main(String[] args){
            WhereSet whereSet = new Get_info_for_db();
            Connection_to_http.whereSet = whereSet;
            Threads threads = new Threads();
            threads.start_parsing();


        }

    }

