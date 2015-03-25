package rage.parqu.questioncreator;

import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.TwoValueQuestionCreator;
import rage.parqu.domain.Question;

public class OverrideQuestionCreator extends TwoValueQuestionCreator {

    public OverrideQuestionCreator() {
        super.setTemplateName("override.mustache");
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä tulostetaan?");

        question.setAnswers(buildAnswers());
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (startingValue + firstModifier);
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet<>();

        answers.add("" + (startingValue + firstModifier - 1));
        answers.add("" + (startingValue));
        answers.add("" + (startingValue + firstModifier));
        answers.add("" + (startingValue + firstModifier + 1));
        answers.add("" + (startingValue - 1));
        answers.add("" + (startingValue + 1));
        answers.add("Ohjelma ei printtaa mitään.");

        return answers;
    }
}
