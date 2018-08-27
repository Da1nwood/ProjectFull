package Pars;

import com.google.gson.stream.MalformedJsonException;

import java.net.SocketTimeoutException;

class NotFatalityExceptions extends Exception {
   static void ReadTimeOut() throws SocketTimeoutException{
       throw new SocketTimeoutException("Not Fatality: Server is trying to read data from the request, but its taking longer " +
               "than the timeout value for the data to arrive from the client");
    }
    static void  UseLineTrue() throws MalformedJsonException {
       throw new  MalformedJsonException("Not Fatality: Exception on server, use line");
    }
    static void AdressInUse() throws java.net.BindException{
       throw new java.net.BindException("Address already in use, wait time");
    }
}
