public enum LevelEnum {
    FIRST(10), SECOND(10), THIRD(10);
    private final int weight;

    private LevelEnum(int weight) {
        this.weight = weight;
    }
}
