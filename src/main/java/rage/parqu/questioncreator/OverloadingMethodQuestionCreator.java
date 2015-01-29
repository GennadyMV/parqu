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

        answers.add(first + "");
        answers.add(second + "");
        answers.add((first + 2) + "");
        answers.add((second + 2) + "");
        answers.add((first + second + 2) + "");
        answers.add((second + first) + "");

        return answers.toArray(new String[0]);
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (first + second + 2);
    }

}
