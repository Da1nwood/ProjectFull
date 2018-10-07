package Pars;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import java.util.ArrayList;

class Regression extends Thread {
    public String name_crypto;

    Regression(String name_coin) {
        this.name_crypto = name_coin;
    }
    @Override
    public void run() {
        Test_InputStream test_inputStream = new Test_InputStream();
        SimpleRegression simpleRegression = new SimpleRegression(true);
        try {
            simpleRegression.addData(test_inputStream.get_info(name_crypto));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println("slope = " + simpleRegression.getSlope());
//        System.out.println("intercept = " + simpleRegression.getIntercept());
//        System.out.println("prediction for 1.5 = " + simpleRegression.predict(500));

    }
}
