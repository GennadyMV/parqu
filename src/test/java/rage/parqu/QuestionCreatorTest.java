package rage.parqu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
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
import rage.parqu.abstractquestioncreators.QuestionCreator;
import rage.parqu.domain.Question;
import rage.parqu.services.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class QuestionCreatorTest {

    private static final int N = 1000;
    
    
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
    public void questionServiceIsNotNull() {
        assertNotNull(questionService);
    }

    @Test
    public void questionsHaveTheRightAnswerInOptions() {
        for (int i = 0; i < QuestionCreatorTest.N; i++) {
            for (Entry<Integer, QuestionCreator> entry : questionService.getCreators().entrySet()) {
                assertTrue("QuestionCreator " + entry.getValue().getClass().getName() + " failed to generate correct test results", rightAnswerExists(questionService.createNewQuestion(entry.getKey(), "testimies")));
            }
        }
    }
    
    @Test
    public void questionsHaveParametersInQuestionCode() {
        for (int i = 0; i < QuestionCreatorTest.N; i++) {
            for (Entry<Integer, QuestionCreator> entry : questionService.getCreators().entrySet()) {
                assertTrue("QuestionCreator " + entry.getValue().getClass().getName() + " failed to generate correct test results", parametersAreInTheCode(questionService.createNewQuestion(entry.getKey(), "testimies")));
            }
        }
    }

    private boolean rightAnswerExists(Question question) {
        for (String string : question.getAnswers()) {
            if (string.equals(question.getCorrectAnswer())) {
                return true;
            }
        }
        System.out.println("ANSWERS:");
        for (String answer : question.getAnswers()) {
            System.out.println(answer);
        }
        System.out.println("RIGHT:");
        System.out.println(question.getCorrectAnswer());
        return false;
    }

    private boolean parametersAreInTheCode(Question question) {
        for (Object object : question.getParameters()) {
            if (!question.getCode().contains(object.toString())) {
                if(object instanceof List){
                    if(listObjectsAreInTheCode(object, question)){
                        continue;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean listObjectsAreInTheCode(Object object, Question question) {
        List<Object> objects = (List<Object>) object;
        for (Object object1 : objects) {
            if (!question.getCode().contains(object1.toString())) {
                return false;
            }
        }
        return true;
    }
}
