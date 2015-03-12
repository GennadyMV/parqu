package rage.parqu.questioncreator;

import java.util.HashMap;
import java.util.Map.Entry;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import static rage.parqu.util.Randomizer.randomAnimalSoundPair;
import static rage.parqu.util.Randomizer.randomPositiveIntegerFromZero;

public class AnimalInterfaceQuestionCreator extends QuestionCreator {

    private int index;
    private Entry<String, String> animalSoundPair1;
    private Entry<String, String> animalSoundPair2;
    
    public  AnimalInterfaceQuestionCreator() {
        super.setTemplateName("animalinterface.mustache");
    }

    @Override
    protected void randomizeParameters() {
        animalSoundPair1 = randomAnimalSoundPair();
        animalSoundPair2 = randomAnimalSoundPair();
        if(animalSoundPair1.getKey().equals(animalSoundPair2.getKey())){
            this.randomizeParameters();
        }
        index = randomPositiveIntegerFromZero(3);
    }

    @Override
    protected HashMap<String, Object> setUpScope() {
        HashMap<String, Object> scopes = new HashMap<>();
        scopes.put("index", index);
        scopes.put("animalName1", animalSoundPair1.getKey());
        scopes.put("animalName2", animalSoundPair2.getKey());
        scopes.put("animalSound1", animalSoundPair1.getValue());
        scopes.put("animalSound2", animalSoundPair2.getValue());
        
        return scopes;    
    }

    @Override
    protected Question setUpQuestionAndAnswers() {
        Question question = new Question();
        question.setQuestionText("Mitä tulostetaan?");
        question.setAnswers("Ohjelma ei tulosta mitään", animalSoundPair1.getValue() + "!", animalSoundPair2.getValue() + "!");
        return question;       
    }

    @Override
    protected String determineRightAnswer() {
        if(index % 2 == 0){
            return animalSoundPair1.getValue() + "!";
        } else {
            return animalSoundPair2.getValue() + "!";
        }
    }
    
}
