package staticlogger;
// LogLevel 은 열거형으로 각 로그 메시지가 얼마나 긴급한지를 나타냄
// 모든 로그 메시지에는 LogLevel 이 같이 들어옴(긴급도. 이건 에러야, 이건 정보야 등등)
// CRITICAL 은 가장 긴급한 로그레벨, 가장 안 긴급한 것은 DEBUG
public enum LogLevel {
    DEBUG(0),
    INFORMATION(1),
    WARNING(2),
    ERROR(3),
    CRITICAL(4);
    private int level;
    public int getLogLevel(){
        return this.level;
    }
    private LogLevel(int level){
        this.level = level;
    }

}
