package prac_staticlogger;

import staticlogger.Logger;

public class Program {
    public static void main(String[] args){
        try{
            Logger.loadConfig(); // 우선 설정을 읽어옴. 설정을 읽어야 코드가 동작

            // 뭔가 로그를 남겨보자
            Logger.logDebug("Printed if the minimun log level is DEBUG");
            Logger.logInformation("Printed if the minimum log level is INFORMATION of lower");
            Logger.logWarning("Printed if the minimum log level is WARNING");

            int x = 10;
            int y = 20;
            Logger.logWarning("%d * %d = %d", x,y,x*y);
            Logger.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
