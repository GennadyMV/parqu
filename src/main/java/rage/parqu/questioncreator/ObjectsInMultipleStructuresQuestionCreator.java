package rage.parqu.questioncreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomGenre;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class ObjectsInMultipleStructuresQuestionCreator extends QuestionCreator {

    private List<String> genres;
    private List<Integer> IDs;
    private List<String> bookNames;

    
    public ObjectsInMultipleStructuresQuestionCreator() {
        super.setTemplateName("objectsinmultipleplaces.mustache");
    }

    @Override
    protected void randomizeParameters() {
        IDs = new ArrayList();
        genres = new ArrayList();
        while (IDs.size() < 2) {
            int newNumber = randomPositiveIntegerFromZero(60);
            if (!IDs.contains(newNumber)) {
                IDs.add(newNumber);
            }
        }
        while (genres.size() < 2) {
            String newName = randomGenre();
            if (!genres.contains(newName)) {
                genres.add(newName);
            }
        }
        bookNames.add("Pride and Prejudice");
        bookNames.add("Catch-22");
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        for (int i = 0; i < IDs.size(); i++) {
            scopes.put("identifier" + (i+1), IDs.get(i));
            scopes.put("genre" + (i + 1), genres.get(i));
            scopes.put("bookName" + (i + 1), bookNames.get(i));
        }
        return scopes;
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Millä genresanalla kirja " + bookNames.get(0) + " löytyy hajautustaulusta?");
        question.setAnswers(setupAnswers()); 
        return question;
    }

    @Override
    protected String determineRightAnswer() {
        return genres.get(0);
    }

    private Set<String> setupAnswers() {
        Set<String> answers = new HashSet<>();
        
        for (int i = 0; i < genres.size(); i++) {
            answers.add(genres.get(i));
            answers.add(bookNames.get(i));
        }
        answers.add("Ei millään");
        
        return answers;
    }


}
