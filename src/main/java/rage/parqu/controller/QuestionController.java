package rage.parqu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rage.parqu.domain.Question;
import rage.parqu.services.QuestionService;

@RestController
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;
    
    @RequestMapping("questions/{id}")
    public Question getQuestion(@PathVariable Integer id){
        return questionService.createNewQuestion(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="questions/{id}/{questionID}")
    public boolean checkAnswer(@PathVariable Integer id, @PathVariable Integer questionID){
        System.out.println(id);
        System.out.println(questionID);
        
        return true;
    }
}
