package rage.parqu.util;

import java.util.Random;

public class Randomizer {
    
    private static final Random random = new Random();
    
    public static int randomIntegerParameter(){
        return random.nextInt(200) - 50;
    }

    public static Operator randomOperator() {
        return Operator.values()[random.nextInt(Operator.values().length)];
    }

}
