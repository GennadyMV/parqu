package rage.parqu.questioncreator;

import java.util.HashMap;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.*;

public class TimeMachineQuestionCreator extends QuestionCreator {

    private int startingYear;
    private int modifier;
    private String passenger;
    private String timeMachineName;

    public TimeMachineQuestionCreator() {
        super.setTemplateName("timemachine.mustache");
    }

    @Override
    protected void randomizeParameters() {
        startingYear = 1985 + randomPositiveIntegerInclusive(30) * positiveOrNegative();
        modifier = randomPositiveIntegerExclusive(30) * positiveOrNegative();
        passenger = randomPassenger().toLowerCase();
        timeMachineName = randomTimeMachine();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("startingYear", startingYear);
        scopes.put("modifier", modifier);
        scopes.put("name", passenger);
        scopes.put("timemachinename", timeMachineName);
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä tulostetaan?");
        question.setAnswers("" + (startingYear + modifier), "" + startingYear, "" + modifier, "" + (startingYear - modifier), "" + (modifier - startingYear));
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (startingYear + modifier);
    }
    
}