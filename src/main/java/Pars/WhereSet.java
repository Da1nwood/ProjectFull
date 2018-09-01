package Pars;

import com.google.gson.JsonObject;

public interface WhereSet{
    void get_info_for(JsonObject jsonObject, String name_coin) throws Exception;
}
