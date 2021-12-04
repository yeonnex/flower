package staticlogger;

// 이 예제에서 logLevel은 INFORMATION, 출력 파일명은 static-log.txt 로 되어있음( 못믿겠으면 config 파일 열어보셈 )
public class Program {
    public static void main(String[] args){
        try{
            Logger.loadConfig(); // 우선 설정을 읽어옴. 설정을 읽어야 로그가 동작하게 코드짰음

            // 뭔가 로그를 남겨보자
            Logger.logDebug("Printed if the minimun log level is DEBUG");
            Logger.logInformation("Printed if the minimum log level is INFORMATION or lower");

            Logger.logWarning("Printed if the minimum log level is WARNING or lower");

            Logger.logError("Printed if the minimum log level is ERROR or lower");

            Logger.logCritical("Printed if the minimum log level is CRITICAL or lower");
            int x = 10;
            int y = 20;

            Logger.logDebug("%d * %d = %d",
                    x, y, x * y);

            Logger.logInformation("%d * %d = %d",
                    x, y, x * y);

            Logger.logWarning("%d * %d = %d",
                    x, y, x * y);

            Logger.logError("%d * %d = %d",
                    x, y, x * y);

            Logger.logCritical("%d * %d = %d",
                    x, y, x * y);

            Logger.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
