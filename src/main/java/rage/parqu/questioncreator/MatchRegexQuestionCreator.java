package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomRegex;

public class MatchRegexQuestionCreator extends QuestionCreator {

    private String regex;
    private Set<String> answers;

    public MatchRegexQuestionCreator() {
        super.setTemplateName("matchregex.mustache");
        answers = setupAnswers();
    }

    @Override
    protected void randomizeParameters() {
        regex = randomRegex();
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();

        scopes.put("regex", regex);
        
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mikä merkkijono hyväksytään annettuun säännölliseen lausekkeeseen?");
        question.setAnswers(answers); 
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        for (String answer : answers) {
            if(answer.matches(regex)){
                return answer;
            }
        }
        return "Ei mikään näistä";
    }

    private Set<String> setupAnswers() {
        Set<String> tempAnswers = new HashSet<>();
        
        tempAnswers.add("aaaaaaaa");
        tempAnswers.add("a");
        tempAnswers.add("bb");
        tempAnswers.add("abba");
        tempAnswers.add("ababab");
        tempAnswers.add("babab");
        tempAnswers.add("abbbbbb");
        tempAnswers.add("Ei mikään näistä");
        
        return tempAnswers;
    }


}
