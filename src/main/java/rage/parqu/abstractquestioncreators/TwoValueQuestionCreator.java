package rage.parqu.abstractquestioncreators;

import java.util.HashMap;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public abstract class TwoValueQuestionCreator extends QuestionCreator{

    protected int startingValue;
    protected int firstModifier;

    @Override
    protected void randomizeParameters() {
        startingValue = randomSmallPositiveInteger();
        firstModifier = randomSmallPositiveInteger();
        if(startingValue == firstModifier){
            randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("value", startingValue);
        scopes.put("first", firstModifier);
        
        return scopes;    
    }
}
