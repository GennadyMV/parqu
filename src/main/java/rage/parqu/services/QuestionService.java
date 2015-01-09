package rage.parqu.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
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

    public QuestionService() {
        this.questionsOnHold = new ConcurrentHashMap<>();
        creators.put(1, new BankQuestionCreator());
        creators.put(2, new ClassCalculatorQuestionCreator());
        creators.put(3, new SimplePrintQuestionCreator());
    }

    public Question createNewQuestion(Integer id) {
        Question newQuestion = creators.get(id).createQuestion();

        questionsOnHold.put(newQuestion.getAnswerID(), newQuestion);

        return newQuestion;
    }

    public boolean checkAndSave(CheckRequest check) {
        Question question = questionsOnHold.get(check.getAnswerID());
        if (question == null) {
            return false;
        }

        boolean correct = question.getCorrectAnswer().equals(check.getAnswer());
        answerRepository.save(new DbAnswer(check.getStudentNumber(), correct, question.getParameters(), check.getQuestionID(), check.getAnswer()));
        if (correct) {
            questionsOnHold.remove(check.getAnswerID());
        }
        return correct;
    }
}
