package Pars;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test_InputStream implements InterGetInfoForRegression{
    public double[][] get_info(String crypto) throws Exception {
        File file = new File(crypto+".txt");
        Scanner input = new Scanner(file);
        String line;
        ArrayList arrayList = new ArrayList<double[]>();
        while (input.hasNextLine()) {
            line = input.nextLine();
            String[] str = line.split(" ");
            double price = Double.valueOf(str[1]);
            double time = Long.valueOf(str[2]);
            double massive[] = {time, price};
            arrayList.add(massive);
        }
            double result [][] = new double[arrayList.size()][];
            for (int i = 0; i < arrayList.size(); i++) {
               result[i] = (double[]) arrayList.get(i);
            }
            return result;
        }
    }
