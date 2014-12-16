package rage.parqu.services;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import rage.parqu.domain.Question;
import rage.parqu.questioncreator.BankQuestionCreator;
import rage.parqu.questioncreator.ClassCalculatorQuestionCreator;
import rage.parqu.questioncreator.QuestionCreator;

@Service
public class QuestionService {
    
    private final HashMap<Integer, QuestionCreator> creators = new HashMap();

    public QuestionService() {
        creators.put(1 ,new BankQuestionCreator());
        creators.put(2 ,new ClassCalculatorQuestionCreator());
    }
    
    public Question createNewQuestion(Integer id){
        return creators.get(id).createQuestion();
    }
}
