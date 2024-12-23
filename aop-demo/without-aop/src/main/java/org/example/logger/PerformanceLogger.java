package org.example.logger;
//inner class have 4 type
// 1. normal inner class
// 2. static inner class
// 3. method inner class
// 4. Idk

public class PerformanceLogger {

    public PerformanceLoggerInfo startTime(String methodName) {
        return new PerformanceLoggerInfo(methodName, System.currentTimeMillis());
    }

    public void endTime(PerformanceLoggerInfo performanceLoggerInfo) {
        long startTime = performanceLoggerInfo.getStartTime();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println(performanceLoggerInfo.getMethodName() + " took " + elapsedTime + " milliseconds");
    }



    public static class PerformanceLoggerInfo {
        private String methodName;
        private long startTime;

        public PerformanceLoggerInfo() {}

        public PerformanceLoggerInfo(String methodName, long startTime) {
            this.methodName = methodName;
            this.startTime = startTime;
        }

        public String getMethodName() {
            return methodName;
        }

        public long getStartTime() {
            return startTime;
        }
    }
}
