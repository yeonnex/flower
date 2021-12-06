package prac_staticlogger;
import staticlogger.LogLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

// Logger 클래스를 구현해보자. 정적 메서드만 사용해서!
// static 은 '클래스에 속한 변수'라는 것을 잊지 말자!
// 정적 메서드 안에서는 정적 멤벼변수만 사용할 수 있다는 것도!

public class Logger {
    // 우선 멤버변수들을 정의한다. 멤버변수들도 모두 정적
    private static final String CONFIG_FILE_NAME =  "logger-config.txt"; // 이 파일로부터 설정을 읽어올 것임
    private static LogLevel logLevel = LogLevel.WARNING; // logLevel 멤버변수는 이 로거가 출력할 최소 LogLevel을 의미. 만약 logLevel이 WARNING이라면, 이것보다 낮은 메시지들은 출력파일에 안적힘
    private static boolean isConfigLoaded = false; // 로그 메시지를 남기려면, 그전에 설정을 읽어야 함. 따라서 이건 일단 false로 초기화
    private static BufferedWriter bufferOut;

    // 생성자는 private. 이 클래스의 인스턴스를 만드는 것을 허용하지 않겠다!
    private Logger(){

    }

    // 이름에서 알 수 있듯, 파일로부터 설정을 읽음
    public static void loadConfig(){
        try{
            String classPath = getClassPath(); // Loger 클래스가 위치한 경로를 가져옴
            Path loggerConfigPath = Paths.get(classPath, CONFIG_FILE_NAME);

            File configFile = new File(loggerConfigPath.toString());
            String outputFilename = "log.txt";

            if(configFile.isFile()){
                List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);
                for(String line : lines){
                    String[] splits = line.split("=");
                    switch (splits[0]){
                        case "loglevel":
                            logLevel = LogLevel.valueOf(splits[1]);
                            break;
                        case "output":
                            outputFilename = splits[1];
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown configuration setting " + splits[0]);

                    }
                }
            }
            Path path = Paths.get(classPath, outputFilename);
            String outputPath = path.toString();

            bufferOut = new BufferedWriter(new FileWriter(outputPath));
            isConfigLoaded = true;
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    // BufferedWriter 는 언매니지드 리소스이기 때문에 GC가 자동으로 닫아주지 않음. 따라서 이걸 직접 닫아줄 메서드 작성
    public static void close(){
        if (bufferOut != null){
            try{
                bufferOut.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    // logDebug() 메서드는 DEBUG 레벨 메시지를 작성.
    public static void logDebug(String message, Object... args){
        assert(isConfigLoaded) : "Configuration not loaded";
        writeToFile(LogLevel.DEBUG, message, args);
    }
    public static void logCritical(String message, Object... args){
        assert(isConfigLoaded) : "Configuration not loaded";
        writeToFile(LogLevel.CRITICAL, message, args);
    }
    private static String getClassPath(){
        File f = new File(Logger.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String packageName = Logger.class.getPackageName();
        packageName = packageName.replace('.', '/');
        Path p = Paths.get(f.getPath(), packageName);
        return p.toAbsolutePath().normalize().toString();
    }

    private static void writeToFile(LogLevel logLevel, String message, Object... args){
        if(!isConfigLoaded || Logger.logLevel.getLogLevel() > logLevel.getLogLevel()){
            return;
        }
        try{
            String log = String.format("[%s] %s : %s", Instant.now().toString(), logLevel.toString(), String.format(message, args));
            bufferOut.write(log);
            bufferOut.newLine();
            bufferOut.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
