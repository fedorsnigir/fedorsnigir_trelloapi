package enums;

public enum ColorsEnum {

    GREEN("green"),
    YELLOW("yellow"),
    ORANGE("orange"),
    RED("red"),
    PURPLE("Purple"),
    BLUE("blue"),
    SKY("sky"),
    LIME("lime"),
    PINK("pink"),
    BLACK("black");

    public String value;

    ColorsEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
