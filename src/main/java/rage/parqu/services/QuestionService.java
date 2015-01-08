package rage.parqu.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import rage.parqu.domain.CheckRequest;
import rage.parqu.domain.Question;
import rage.parqu.questioncreator.BankQuestionCreator;
import rage.parqu.questioncreator.ClassCalculatorQuestionCreator;
import rage.parqu.questioncreator.QuestionCreator;

@Service
public class QuestionService {
    
    private final HashMap<Integer, QuestionCreator> creators = new HashMap();
    private final Map<UUID,Question> questionsOnHold;

    public QuestionService() {
        this.questionsOnHold = new ConcurrentHashMap<>();
        creators.put(1 ,new BankQuestionCreator());
        creators.put(2 ,new ClassCalculatorQuestionCreator());
    }
    
    public Question createNewQuestion(Integer id){
        Question newQuestion = creators.get(id).createQuestion();
        
        questionsOnHold.put(newQuestion.getAnswerID(), newQuestion);
        
        return newQuestion;
    }
    
    public boolean checkAnswerFromMap(CheckRequest check){
        if(questionsOnHold.get(check.getAnswerID()) == null){
            return false;
        }
        
        if(questionsOnHold.get(check.getAnswerID()).getCorrectAnswer().equals(check.getAnswer())){
            questionsOnHold.remove(check.getAnswerID());
            return true;
        }
        return false;
    }
}
