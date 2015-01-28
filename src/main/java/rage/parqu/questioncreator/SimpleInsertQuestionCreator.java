package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.abstractquestioncreators.TwoValueQuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallPositiveInteger;

public class SimpleInsertQuestionCreator extends TwoValueQuestionCreator{

    public SimpleInsertQuestionCreator() {
        super.setTemplateName("simpleinsertion.mustache");
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä numero tulostetaan?");
        question.setAnswers("" + (first + second), "" + (first - second), "" + first, "" + second);
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return "" + second;
    }
    
}
