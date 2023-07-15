public class AdditionMain {

    public int sum(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        LevelEnum chk = LevelEnum.FIRST;
        for(LevelEnum l1:LevelEnum.values())
            System.out.println(l1.ordinal());
    }

}
