public enum SeverityLevel {
    OFF(0),
    FATAL(1),
    ERROR(2),
    WARN(3),
    INFO(4),
    DEBUG(5),
    TRACE(6);

    final int value;

    SeverityLevel(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
