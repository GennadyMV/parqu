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

        answers.add(first + "");
        answers.add(second + "");
        answers.add((first + 2) + "");
        answers.add((second + 2) + "");
        answers.add((first + second + 2) + "");
        answers.add((second + first) + "");
        answers.add((second * 3 + first) + "");

        return answers;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (first + second + 2);
    }

}
