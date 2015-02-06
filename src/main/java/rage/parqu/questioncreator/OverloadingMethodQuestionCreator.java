package rage.parqu.questioncreator;

import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.TwoValueQuestionCreator;
import rage.parqu.domain.Question;

public class OverloadingMethodQuestionCreator extends TwoValueQuestionCreator {

    public OverloadingMethodQuestionCreator() {
        super.setTemplateName("overloadingmethods.mustache");
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä arvo tulostetaan?");
        question.setAnswers(buildAnswers());
        return question;
    }

    private Set<String> buildAnswers() {
        Set<String> answers = new HashSet();

        answers.add(startingValue + "");
        answers.add(firstModifier + "");
        answers.add((startingValue + 2) + "");
        answers.add((firstModifier + 2) + "");
        answers.add((startingValue + firstModifier + 2) + "");
        answers.add((firstModifier + startingValue) + "");
        answers.add((firstModifier * 3 + startingValue) + "");

        return answers;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (startingValue + firstModifier + 2);
    }

}
