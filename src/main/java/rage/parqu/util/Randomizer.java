package rage.parqu.util;

import java.util.Random;

public class Randomizer {
    
    private static final Random random = new Random();
    private static final String[] strings = {"Matti", "Arto", "Leo", "Joni", "Mika", "Lassi", "Kasper", "Kenny"};
    
    public static int randomLargePositiveInteger(){
        return 1 + random.nextInt(100);
    }
    
    public static int randomSmallPositiveInteger(){
        return 1 + random.nextInt(10);
    }
    
    /**
     * Return a random value from zero to the given value. With 2, it returns 0-2.
     * 
     * @param highestValue
     * @return 
     */
    public static int randomSmallPositiveInteger(int highestValue){
        return random.nextInt(highestValue + 1);
    }
    
    public static int randomSmallNegativeInteger(){
        return 0 - random.nextInt(2);
    }

    public static Operator randomOperator() {
        return Operator.values()[random.nextInt(Operator.values().length)];
    }
    
    public static String randomString() {
        return strings[random.nextInt(strings.length)];
    } 

}
