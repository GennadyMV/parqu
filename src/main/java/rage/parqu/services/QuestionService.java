package rage.parqu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rage.parqu.domain.CheckRequest;
import rage.parqu.domain.DbAnswer;
import rage.parqu.domain.Question;
import rage.parqu.questioncreator.*;
import rage.parqu.repositories.AnswerRepository;

@Service
public class QuestionService {

    private final HashMap<Integer, QuestionCreator> creators = new HashMap();
    private final Map<UUID, Question> questionsOnHold;
    @Autowired
    private AnswerRepository answerRepository;
    private int cleanupCounter = 0;

    public QuestionService() {
        this.questionsOnHold = new ConcurrentHashMap<>();
        creators.put(1, new BankQuestionCreator());
        creators.put(2, new ClassCalculatorQuestionCreator());
        creators.put(3, new SimpleInsertQuestionCreator());
        creators.put(4, new SimpleCalculationQuestionCreator());
        creators.put(5, new StringsAndNumbersQuestionCreator());
        creators.put(6, new SimpleWhileQuestionCreator());
        creators.put(7, new WhileMethodQuestionCreator());
        creators.put(8, new WhileMethodPrintVersionQuestionCreator());
    }

    public Question createNewQuestion(Integer id) {
        Question newQuestion = creators.get(id).createQuestion();

        questionsOnHold.put(newQuestion.getAnswerID(), newQuestion);

        return newQuestion;
    }

    public boolean checkAndSave(CheckRequest check) {
        cleanupCounter++;
        if(cleanupCounter > 10){
            removeUnansweredQuestions();
            cleanupCounter = 0;
        }
        
        Question question = questionsOnHold.get(check.getAnswerID());
        if (question == null) {
            return false;
        }

        boolean correct = question.getCorrectAnswer().equals(check.getAnswer());
        answerRepository.save(new DbAnswer(check.getStudentID(), correct, question.getParameters(), check.getQuestionID(), check.getAnswer(), question.getTimeStamp()));
        if (correct) {
            questionsOnHold.remove(check.getAnswerID());
        }
        
        return correct;
    }

    private void removeUnansweredQuestions() {
        List<UUID> toRemove = new ArrayList();
        DateTime now = new DateTime();
        for (Question question : questionsOnHold.values()) {
            if(questionIsOld(question.getTimeStamp(), now)){
                toRemove.add(question.getAnswerID());
            }
        }
        for (UUID uuid : toRemove) {
            questionsOnHold.remove(uuid);
        }
    }
    
    private boolean questionIsOld(DateTime timeStamp, DateTime now) {
        Hours hours = Hours.hoursBetween(timeStamp, now);
        
        return hours.getHours() > 24;
    }
}
