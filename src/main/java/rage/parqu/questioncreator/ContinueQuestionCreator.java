package rage.parqu.questioncreator;

import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.TwoValueQuestionCreator;
import rage.parqu.domain.Question;

public class ContinueQuestionCreator extends TwoValueQuestionCreator {

    public ContinueQuestionCreator() {
        super.setTemplateName("continue.mustache");
    }

    @Override
    protected void randomizeParameters() {
        super.randomizeParameters();
        if (firstModifier < startingValue) {
            int temp = startingValue;
            startingValue = firstModifier;
            firstModifier = temp;
        }
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Kuinka monta kertaa tulostetaan \"Tööt?\"");
        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (firstModifier - startingValue);
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            answers.add("" + i);
        }
        return answers;
    }
    
    @Override
    protected void addNote(Question question){
        question.setNote("Muistatko vielä %-merkinnän?");
    }

}