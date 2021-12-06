package prac_staticlogger;

// LogLevel은 열거형으로 각 로그 메시지가 얼마나 긴급한지를 나타냄
// 모든 로그 메시지에는 LogLevel이 같이 들어옴
// CRITICAL은 가장 급한 로그레벨, 가장 안 긴급한 것은 DEBUG
public enum LogLevel {
    DEBUG(0),
    INFORMATION(1),
    WARNING(2),
    ERROR(3),
    CRITICAL(4);
    private int level;
    public int getLogLevel(){
        return level;
    }
    private LogLevel(int level){
        this.level = level;
    }
}
