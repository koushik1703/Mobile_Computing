package com.example.calculator;

//Class for calculation
public class Calculation {

    String result = "";
    static Calculation calc = null;

    public static Calculation getInstance() {
        if(calc == null)
        {
            calc = new Calculation();
        }
        return calc;
    }

    public String calculate(String queryText) {

        if(!(queryText.contains("+") || queryText.contains("-") || queryText.contains("*") || queryText.contains("/") )) {
            return queryText;
        }

        Operation operation;

        if(queryText.contains("/")) {
            operation = DivOperation.getInstance();
            queryText = operation.operate(queryText);
            result = calculate(queryText);
        } else if (queryText.contains("*")) {
            operation = MulOperation.getInstance();
            queryText = operation.operate(queryText);
            result = calculate(queryText);
        } else if (queryText.contains("-")) {
            operation = SubOperation.getInstance();
            queryText = operation.operate(queryText);
            result = calculate(queryText);
        } else if (queryText.contains("+")) {
            operation = AddOperation.getInstance();
            queryText = operation.operate(queryText);
            result = calculate(queryText);
        }

        return result;
    }
}
