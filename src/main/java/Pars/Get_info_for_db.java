package Pars;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import static Pars.Connect_To_Data.mysql_connection;

public class Get_info_for_db implements WhereSet {
    @Override
    public void get_info_for(JsonObject jsonObject, String name_coin) throws Exception {
        long timestamp = System.currentTimeMillis() / 1000;
        JsonElement usd_crypto = jsonObject.get("USD");
        if (usd_crypto != null) {
            mysql_connection(new Crypto_info(name_coin, String.valueOf(usd_crypto), String.valueOf(timestamp)));
        } else FatalityExceptions.ErrorOfRightUrl();
    }
}