package rage.parqu.util;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Randomizer {

    private static final Random random = new Random();
    private static final String[] strings = {"Matti", "Arto", "Leo", "Joni", "Mika", "Lassi", "Kasper", "Kenny"};
    private static final String[] functions = {"opiskele", "juhli", "nuku", "syo", "liiku", "pelaa"};
    private static final String[] passengers = {"Marty", "Emmett", "Lorraine", "George", "Biff", "Tohtori", "Jennifer"};
    private static final String[] timeMachines = {"tardis", "deLorean", "aikakone"};
    private static final String[] pets = {"Trevor", "Hedwig", "Nagini", "Koukkujalka", "Hämäkäk", "Kutka", "Posityyhtynen"};
    private static final String[] variables = {"luku", "arvo", "numero", "muuttuja", "apu"};
    private static final Map<String, String> animalSounds = ImmutableMap.of("Horse", "Neigh", "Dog", "Woof", "Pig", "Oink", "Sheep", "Baa", "Frog", "Ribbit");
    private static final String[] bookObjects = {"book", "object", "o", "b", "obj", "kirja", "k"};
    private static final String[] genres = {"Jännitys", "Romantiikka", "Lastenkirja", "Tieto", "Äänikirja"};
    private static final String[] bookNames = {"Catch-22", "1984", "Fahrenheit 451", "Tuntematon Sotilas", "Kalevala"};
    
    public static int randomLargePositiveInteger() {
        return 1 + random.nextInt(100);
    }

    public static int randomSmallPositiveInteger() {
        return 1 + random.nextInt(10);
    }

    /**
     * Return a random value from zero to the given value. With 2, it returns
     * 0-2.
     *
     * @param highestValue
     * @return
     */
    public static int randomPositiveIntegerFromZero(int highestValue) {
        return random.nextInt(highestValue + 1);
    }

    /**
     * Return a random value from 1 to the given value. With 4, it returns 1-4.
     *
     * @param highestValue
     * @return
     */
    public static int randomPositiveIntegerFromOne(int highestValue) {
        return random.nextInt(highestValue) + 1;
    }

    public static int randomSmallNegativeInteger() {
        return 0 - random.nextInt(2);
    }

    public static Operator randomOperator() {
        return Operator.values()[random.nextInt(Operator.values().length)];
    }

    public static String randomString() {
        return strings[random.nextInt(strings.length)];
    }
    
    public static String randomGenre() {
        return genres[random.nextInt(genres.length)];
    }
    
    public static String randomBookObject() {
        return bookObjects[random.nextInt(bookObjects.length)];
    }

    public static String randomBookName() {
        return bookNames[random.nextInt(bookNames.length)];
    }
    
    public static String randomFunctionName() {
        return functions[random.nextInt(functions.length)];
    }

    public static String randomVariableName() {
        return variables[random.nextInt(variables.length)];
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

    public static Entry<String, String> randomAnimalSoundPair() {
        return randomEntry(animalSounds.entrySet());
    }

    public static int positiveOrNegative() {
        if (random.nextBoolean()) {
            return 1;
        } else {
            return -1;
        }
    }

    private static Entry<String, String> randomEntry(Set<Entry<String, String>> entrySet) {
        int size = entrySet.size();
        int item = random.nextInt(size);
        int i = 0;
        for (Entry<String, String> entry : entrySet) {
            if (i == item) {
                return entry;
            }
            i = i + 1;
        }
        return null;
    }
}
