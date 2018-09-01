package Pars;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.*;

public class Get_info_for_file implements WhereSet {
    public static PrintWriter printWriter = null;


    @Override
    public void get_info_for(JsonObject jsonObject, String name_coin) throws Exception {
        String name_file = name_coin + ".txt";
        File file = new File(name_file);
        if (!(file.exists())) {
            file.createNewFile();
        }
            try {
                printWriter = new PrintWriter(new FileOutputStream(name_file, true));
                long timestamp = System.currentTimeMillis() / 1000;
                JsonElement usd_crypto = jsonObject.get("USD");
                if (usd_crypto != null) {
                    printWriter.println(name_coin + " " + usd_crypto + " " + timestamp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                printWriter.close();

            }
        }
    }

