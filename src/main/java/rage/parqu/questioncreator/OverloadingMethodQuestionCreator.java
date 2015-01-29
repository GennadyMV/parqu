package rage.parqu.questioncreator;

import java.util.Set;
import java.util.TreeSet;
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

    private String[] buildAnswers() {
        Set<String> answers = new TreeSet();

        answerPlusTwo(answers, first);
        answerPlusTwo(answers, second);

        return answers.toArray(new String[0]);
    }

    private void answerPlusTwo(Set<String> answers, int value) {
        for (int i = 0; i <= 2; i++) {
            answers.add("" + (value + i));
            answers.add("" + (value * (i + 1)) + first);
        }
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (first + second + 2);
    }

}
