package slf4j;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    //logback.xml
    public static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOG.info("SOME MESSAGE");

    }
}
