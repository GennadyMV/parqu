package rage.parqu.util;

import java.util.Random;

public class Randomizer {
    
    private static Random random = new Random();
    
    public static int randomIntegerParameter(){
        return random.nextInt(200) - 100;
    }

}
