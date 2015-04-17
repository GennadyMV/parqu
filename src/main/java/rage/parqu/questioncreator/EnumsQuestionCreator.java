package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomGenre;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromOne;

public class EnumsQuestionCreator extends QuestionCreator {

    private String genre;
    private int amount;

    public EnumsQuestionCreator() {
        super.setTemplateName("enums.mustache");
    }

    @Override
    protected void randomizeParameters() {
        genre = randomGenre();
        amount = randomPositiveIntegerFromOne(100);
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();

        scopes.put("genre", genre);
        scopes.put("amount", amount);
        
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä put-lause saa lisättyä halutun asian Mappiin?");
        question.setAnswers(setupAnswers()); 
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return "kirjojenMaarat.put" + "(Genre." + genre +", " + amount + ");";
    }

    private Set<String> setupAnswers() {
        Set<String> answers = new HashSet<>();
        
        answers.add("kirjojenMaarat.put" + "(Genre." + genre +", " + amount + ");");
        answers.add("kirjojenMaarat.put" + "(genre." + genre +", " + amount + ");");
        answers.add("kirjojenMaarat.put" + "(" + genre +", " + amount + ");");
        answers.add("kirjojenMaarat.put" + "((Genre)" + genre +", " + amount + ");");
        
        return answers;
    }


}
