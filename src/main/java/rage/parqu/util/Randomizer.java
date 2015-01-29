package rage.parqu.util;

import java.util.Random;

public class Randomizer {
    
    private static final Random random = new Random();
    private static final String[] strings = {"Matti", "Arto", "Leo", "Joni", "Mika", "Lassi", "Kasper", "Kenny"};
    private static final String[] functions = {"opiskele", "juhli", "nuku", "syo", "liiku", "pelaa"};
    private static final String[] passengers = {"Marty", "Emmett", "Lorraine", "George", "Biff", "Tohtori", "Jennifer"};
    private static final String[] timeMachines = {"tardis", "deLorean", "aikakone"};
    private static final String[] pets = {"Trevor", "Hedwig", "Nagini", "Koukkujalka", "Hämäkäk", "Kutka", "Posityyhtynen"};

    
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
    public static int randomPositiveIntegerInclusive(int highestValue){
        return random.nextInt(highestValue + 1);
    }
    
    public static int randomPositiveIntegerExclusive(int highestValue){
        return random.nextInt(highestValue) + 1;
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
    
    public static String randomFunctionName() {
        return functions[random.nextInt(functions.length)];
    }
    
    public static String randomPassenger() {
        return passengers[random.nextInt(passengers.length)];
    }
    
    public static String randomPet() {
        return pets[random.nextInt(pets.length)];
    }
    
    public static String randomTimeMachine() {
        return timeMachines[random.nextInt(timeMachines.length)];
    }
    
    public static int positiveOrNegative(){
        if(random.nextBoolean()){
            return 1;
        } else {
            return -1;
        }
    }
}
