package rage.parqu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rage.parqu.domain.CheckRequest;
import rage.parqu.domain.Question;
import rage.parqu.services.QuestionService;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("questions/{id}")
    public Question getQuestion(@PathVariable Integer id) {
        return questionService.createNewQuestion(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "questions")
    public boolean checkAnswer(@RequestBody CheckRequest check) {
        return questionService.checkAndSave(check);
    }
}
