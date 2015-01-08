package rage.parqu.util;

public enum Operator {
    
    PLUS ("+="),
    MINUS ("-=");
    
    private final String operatorSign;
    
    private Operator(String s) {
        operatorSign = s;
    }

    @Override
    public String toString(){
       return operatorSign;
    }
    
}
