package rage.parqu.services;

import org.springframework.stereotype.Service;
import rage.parqu.domain.Question;
import rage.parqu.questioncreator.BankQuestionCreator;
import rage.parqu.questioncreator.QuestionCreator;

@Service
public class QuestionService {
    
    private final QuestionCreator creator = new BankQuestionCreator();
    
    public Question createNewQuestion(Long id){
        return creator.createQuestion();
    }
}
