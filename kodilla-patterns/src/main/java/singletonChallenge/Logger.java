package singletonChallenge;

public class Logger {
        private static Logger loggerInstance = null;
        private String lastLog = "";

        private Logger() {}

        public static Logger getLoggerInstance() {
            if(loggerInstance==null) {
                loggerInstance = new Logger();
            }
                return  loggerInstance;

        }

        public void log(String log) {
            lastLog = log;
            System.out.println("Log: [" + log + "]");
        }

        public String getLastLog() {
            return lastLog;
        }

}
