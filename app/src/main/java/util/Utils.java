package util;

import java.text.DecimalFormat;

/**
 * Created by Marc on 12.02.2018.
 */

public class Utils {

    public static String formatNumber(int value){
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formatted = formatter.format(value);

        return formatted;


    }

}
