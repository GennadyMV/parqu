
package rage.parqu;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import rage.parqu.domain.Question;
import rage.parqu.services.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class QuestionCreatorTest {
    
    @Autowired
    private QuestionService questionService;
    
    public QuestionCreatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void questionServiceIsNotNull(){
        assertNotNull(questionService);
    }
    
    @Test
    public void questionsHaveTheRightAnswerInOptions(){
        for (int i = 1; i <= 23; i++) {
            assertTrue(rightAnswerExists(questionService.createNewQuestion(i, "testimies")));  
        }
    }
    
    @Test
    public void firstTenQuestionsHaveRightAnswerInOptions(){
        for (int i = 1; i <= 10; i++) {
            assertTrue(rightAnswerExists(questionService.createNewQuestion(i, "testimies")));  
        }
    }
    
    @Test
    public void elevenToTwentyQuestionsHaveRightAnswerInOptions(){
        for (int i = 11; i <= 20; i++) {
            assertTrue(rightAnswerExists(questionService.createNewQuestion(i, "testimies")));  
        }
    }
    
    @Test
    public void twentyToThirtyQuestionsHaveRightAnswerInOptions(){
        for (int i = 21; i <= 23; i++) {
            assertTrue(rightAnswerExists(questionService.createNewQuestion(i, "testimies")));  
        }
    }
    
    @Test
    public void objectWithListAccessQuestionHasRightAnswerInOptions(){
        assertTrue(rightAnswerExists(questionService.createNewQuestion(21, "testimies")));  
    }
    
    @Test
    public void overloadedConstructorQuestionHasRightAnswerInOptions(){
        assertTrue(rightAnswerExists(questionService.createNewQuestion(22, "testimies")));  
    }
    
    @Test
    public void variableVisibilityQuestionHasRightAnswerInOptions(){
        assertTrue(rightAnswerExists(questionService.createNewQuestion(23, "testimies")));  
    }
    
    @Test
    public void bankQuestionHasRightAnswerInOptions(){
        assertTrue(rightAnswerExists(questionService.createNewQuestion(1, "testimies")));  
    }
    
    @Test
    public void parametersAreInTheQuestionCode(){
        for (int i = 1; i <= 23; i++) {
            assertTrue(parametersAreInTheCode(questionService.createNewQuestion(i, "testimies")));  
        }
    }
    
        @Test
    public void firstTenQuestionsParametersAreInTheQuestionCode(){
        for (int i = 1; i <= 10; i++) {
            assertTrue(parametersAreInTheCode(questionService.createNewQuestion(i, "testimies")));  
        }
    }
    
    @Test
    public void elevenToTwentyQuestionsParametersAreInTheQuestionCode(){
        for (int i = 11; i <= 20; i++) {
            assertTrue(parametersAreInTheCode(questionService.createNewQuestion(i, "testimies")));  
        }
    }
    
    @Test
    public void twentyToThirtyQuestionsParametersAreInTheQuestionCode(){
        for (int i = 21; i <= 23; i++) {
            assertTrue(parametersAreInTheCode(questionService.createNewQuestion(i, "testimies")));  
        }
    }

    private boolean rightAnswerExists(Question question) {
        for (String string : question.getAnswers()) {
            if(string.equals(question.getCorrectAnswer())){
                return true;
            }
        }
        return false;
    }

    private boolean parametersAreInTheCode(Question question) {
        for (Object object : question.getParameters()) {
            if(!question.getCode().contains(object.toString())){
                return false;
            }
        }
        return true;
    }
}
