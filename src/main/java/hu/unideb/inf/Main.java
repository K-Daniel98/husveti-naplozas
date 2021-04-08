package hu.unideb.inf;

import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getRootLogger();//LogManager.getLogger(Main.class);

    private static final Marker kerdesMarker = MarkerManager.getMarker("KERDES");
    private static final Marker kijelentesMarker = MarkerManager.getMarker("KIJELENTES");

    public static void main(String [] args) throws InterruptedException {
        String vers = """
                Zöld erdőben jártam,
                Kék ibolyát láttam,
                El akart hervadni,
                Szabad-e locsolni?""";

        var splitted = vers.split("\n");

        int iterationCount = Integer.parseInt(args[0]);

        for(int j=0;j<iterationCount;j++)
        {
            for(int i=0;i<splitted.length;i++)
            {
                ThreadContext.put("iterationIndex", String.valueOf(i));

                if(i == 0)
                {
                    logger.warn(splitted[i]);
                    continue;
                }

                if(splitted[i].endsWith("?"))
                    logger.error(kerdesMarker,splitted[i]);
                else
                    logger.info(kijelentesMarker,splitted[i]);
            }
            Thread.sleep(1000);
        }

    }
}
