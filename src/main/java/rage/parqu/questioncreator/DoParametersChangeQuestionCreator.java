package rage.parqu.questioncreator;

public class DoParametersChangeQuestionCreator extends ClassCalculatorQuestionCreator{
    
    public DoParametersChangeQuestionCreator(){
        super.setTemplateName("doparameterschange.mustache");
    }

    public String determineRightAnswer(){
        return "" + super.modifier;
    }
}
