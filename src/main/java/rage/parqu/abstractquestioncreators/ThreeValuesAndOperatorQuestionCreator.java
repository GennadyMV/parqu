package rage.parqu.abstractquestioncreators;

import java.util.HashMap;
import static rage.parqu.util.Randomizer.randomPositiveIntegerExclusive;

public abstract class ThreeValuesAndOperatorQuestionCreator extends TwoValuesAndOperatorQuestionCreator{
    
    protected int secondModifier;
    
    @Override
    protected void randomizeParameters() {
        super.randomizeParameters();
        secondModifier = randomPositiveIntegerExclusive(15);
        if(secondModifier == startingValue || secondModifier == firstModifier){
            randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = super.setUpScope();
        scopes.put("second", secondModifier);
        return scopes;    
    }

}
