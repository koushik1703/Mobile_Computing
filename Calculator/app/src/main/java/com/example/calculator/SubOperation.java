package com.example.calculator;

// Class to handle subtraction Operation
public class SubOperation extends Operation {

    static SubOperation subOperation = null;

    static SubOperation getInstance() {
        if(subOperation == null) {
            subOperation = new SubOperation();
        }
        return subOperation;
    }

    @Override
    public String operate(String queryText) {
        super.setOperation("-");
        super.operate(queryText);
        float r = operandOne - operandTwo;
        queryText = queryText.substring(0, pos1) + r + queryText.substring(pos2 + 1, queryText.length());
        return queryText;
    }
}
