package Pars;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.*;

class Connection_to_http extends Thread {
    private String name_coin;
    private String url;
    protected static WhereSet whereSet= null;

    Connection_to_http(String name_coin) {
        this.name_coin = name_coin;
        this.url = "https://min-api.cryptocompare.com/data/price?fsym="+name_coin+"&tsyms=USD";
    }



    public void run() {
        HttpURLConnection connection = null;
        while (true) {
            try {
                CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("GET");
                connection.setUseCaches(false);
                connection.setConnectTimeout(2000);
                connection.setReadTimeout(2500);
                connection.connect();
                if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        JsonReader jsonReader = new JsonReader(new StringReader(line));
                        jsonReader.setLenient(true);
                        JsonParser jsonParser = new JsonParser();
                        Object obj = jsonParser.parse(line);
                        JsonObject jsonObject = (JsonObject) obj;
                        whereSet.get_info_for(jsonObject,name_coin);

        }

                    sleep(9000);
                }

            }
            catch (UnknownHostException e){
                try { FatalityExceptions.ConnectionToInterner();
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }
            }
            catch (SocketTimeoutException e){
                try {
                    NotFatalityExceptions.ReadTimeOut();
                } catch (SocketTimeoutException e1) {
                    e1.printStackTrace();
                }

            }
            catch (MalformedJsonException e1){
                e1.printStackTrace();
                try {
                    NotFatalityExceptions.UseLineTrue();
                } catch (MalformedJsonException e) {
                    e1.printStackTrace();
                }
            }
            catch (BindException e){
                try {
                    NotFatalityExceptions.AdressInUse();
                } catch (BindException e1) {
                    e1.printStackTrace();
                }
            }
            catch (Exception cause) {
                cause.printStackTrace();

            } finally {
                if (connection != null) {
                    connection.disconnect();

                }

            }

        }


    }

}