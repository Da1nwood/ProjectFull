package Pars;

import com.google.gson.JsonObject;

public interface IWhereSet {
    void get_info_for(JsonObject jsonObject, String name_coin) throws Exception;
}
