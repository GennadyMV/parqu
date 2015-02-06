package rage.parqu.abstractquestioncreators;

import java.util.HashMap;
import static rage.parqu.util.Randomizer.randomPositiveIntegerExclusive;

public abstract class ThreeValueQuestionCreator extends ValuesAndOperatorQuestionCreator{
    
    protected int startingValue;
    
    @Override
    protected void randomizeParameters() {
        super.randomizeParameters();
        startingValue = randomPositiveIntegerExclusive(15);
        if(startingValue == first || startingValue == second){
            randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = super.setUpScope();
        scopes.put("value", startingValue);
        return scopes;    
    }

}
