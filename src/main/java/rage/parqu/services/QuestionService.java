package rage.parqu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.transaction.Transactional;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.CheckRequest;
import rage.parqu.domain.DbAnswer;
import rage.parqu.domain.DbRequest;
import rage.parqu.domain.Question;
import rage.parqu.questioncreator.*;
import rage.parqu.repositories.AnswerRepository;
import rage.parqu.repositories.RequestRepository;

@Service
public class QuestionService {

    private final HashMap<Integer, QuestionCreator> creators = new HashMap();
    private final Map<UUID, Question> questionsOnHold;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private RequestRepository requestRepository;
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
        creators.put(9, new ArrayListIndexQuestionCreator());
        creators.put(10, new EditValueQuestionCreator());
        creators.put(11, new EditValueAndIncrementQuestionCreator());
        creators.put(12, new CharAtQuestionCreator());
        creators.put(13, new IntegerListRemoveQuestionCreator());
        creators.put(14, new IntegerListRemoveValueQuestionCreator());
        creators.put(15, new CallObjectMethodQuestionCreator());
        creators.put(16, new ChangeObjectParameterQuestionCreator());
        creators.put(17, new DoParametersChangeQuestionCreator());
        creators.put(18, new ObjectWithListQuestionCreator());
        creators.put(19, new TimeMachineQuestionCreator());
        creators.put(20, new OverloadingMethodQuestionCreator());
        creators.put(21, new ObjectWithListAccessQuestionCreator());
        creators.put(22, new OverloadedConstructorQuestionCreator());
        creators.put(23, new CloneTimeMachineQuestionCreator());
        creators.put(24, new VariableVisibilityQuestionCreator());
        creators.put(25, new ForArrayQuestionCreator());
        creators.put(26, new ArraySwapQuestionCreator());
        creators.put(27, new ForBorderQuestionCreator());
        creators.put(28, new BiggestNumberQuestionCreator());
        creators.put(29, new MapGetQuestionCreator());
        creators.put(30, new ObjectMapQuestionCreator());
        creators.put(31, new AnimalInterfaceQuestionCreator());
        creators.put(32, new SetSizeQuestionCreator());
    }

    public Question createNewQuestion(Integer id, String studentID) {
        Question newQuestion = creators.get(id).createQuestion();

        questionsOnHold.put(newQuestion.getAnswerID(), newQuestion);
        
        requestRepository.save(new DbRequest(studentID, id, new DateTime(), newQuestion.getAnswerID()));

        return newQuestion;
    }

    @Transactional
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
        answerRepository.save(new DbAnswer(check.getStudentID(), correct, question.getParameters(), check.getQuestionID(), check.getAnswer(), new DateTime(), question.getAnswerID()));
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

    public HashMap<Integer, QuestionCreator> getCreators() {
        return creators;
    }


}
