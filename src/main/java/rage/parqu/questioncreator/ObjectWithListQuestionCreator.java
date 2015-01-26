package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.QuestionCreator;
import java.util.HashMap;
import rage.parqu.domain.Question;

public class ObjectWithListQuestionCreator extends QuestionCreator{

    @Override
    protected void randomizeParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String determineRightAnswer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
