package com.example.calculator;

//Class for Add Operation
public class AddOperation extends Operation {

    static AddOperation addOperation = null;

    static AddOperation getInstance() {
        if(addOperation == null) {
            addOperation = new AddOperation();
        }
        return addOperation;
    }

    @Override
    public String operate(String queryText) {
        super.setOperation("+");
        super.operate(queryText);
        float r = operandOne + operandTwo;
        queryText = queryText.substring(0, pos1) + r + queryText.substring(pos2 + 1, queryText.length());
        return queryText;
    }
}
