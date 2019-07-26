package libs.apache_common;

import org.apache.commons.lang.exception.ExceptionUtils;

public class Main {

    public static void main(String[] args) {

        //ExceptionUtils
        try {
           throw new RuntimeException();
        }catch (Exception e){
            String stackTrace = ExceptionUtils.getStackTrace(e);
            System.out.println(stackTrace);
        }

    }
}
