package rage.parqu.abstractquestioncreators;

import java.util.HashMap;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public abstract class TwoValueQuestionCreator extends QuestionCreator{

    protected int first;
    protected int second;

    public TwoValueQuestionCreator() {
        super.setTemplateName("simpleinsertion.mustache");
    }

    @Override
    protected void randomizeParameters() {
        first = randomSmallPositiveInteger();
        second = randomSmallPositiveInteger();
        if(first == second){
            randomizeParameters();
        }
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("first", first);
        scopes.put("second", second);
        
        return scopes;    
    }
}
