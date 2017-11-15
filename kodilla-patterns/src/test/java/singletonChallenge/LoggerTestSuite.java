package singletonChallenge;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getLoggerInstance().log("Opening programme");
        Logger.getLoggerInstance().log("Connecting with database");
        Logger.getLoggerInstance().log("Generating files");
        Logger.getLoggerInstance().log("Closing connection");
        //When
        String lastLog = Logger.getLoggerInstance().getLastLog();
        //Then
        Assert.assertEquals("Closing connection",lastLog);
    }
}
