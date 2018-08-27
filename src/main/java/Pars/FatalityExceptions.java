package Pars;
import java.sql.SQLException;

class FatalityExceptions extends Exception {
         static void ErrorOfRightUrl() throws Exception {
            throw new Exception("Fatal error : Error_of_right_url");
        }
        static void SqlTableNotFound() throws java.sql.SQLSyntaxErrorException{
            throw new java.sql.SQLSyntaxErrorException("Fatal error : SQL TABLE DON'T FOUND");
        }
         static void SqlConnectingProblems() throws SQLException {
            throw new SQLException("Fatal error : You give wrong information about port or url database");
        }
         static void WrongNameOrPassword() throws SQLException {
            throw new SQLException("Wrong Name Or Password");
        }
         static void ConnectionToInterner() throws java.net.UnknownHostException{
            throw new java.net.UnknownHostException("You don't have connection to internet or your website is wrong");
        }

    }

