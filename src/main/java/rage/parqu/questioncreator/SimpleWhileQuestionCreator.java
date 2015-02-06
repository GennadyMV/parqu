package rage.parqu.questioncreator;

import rage.parqu.abstractquestioncreators.TwoValueQuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomSmallNegativeInteger;

public class SimpleWhileQuestionCreator extends TwoValueQuestionCreator {

    public SimpleWhileQuestionCreator() {
        super.setTemplateName("simplewhile.mustache");
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
        int range = randomSmallNegativeInteger();
        question.setAnswers("" + ((firstModifier - startingValue) + (range + 4)), "" + ((firstModifier - startingValue) + range), "" + ((firstModifier - startingValue) + (range + 2)), "" + ((firstModifier - startingValue) + (range + 1)), "" + ((firstModifier - startingValue) + (range + 3)));
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "" + (firstModifier - startingValue);
    }

}
