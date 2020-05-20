package com.example.calculator;

//Class for division Operation
public class DivOperation extends Operation {

    static DivOperation divOperation = null;

    static DivOperation getInstance() {
        if(divOperation == null) {
            divOperation = new DivOperation();
        }
        return divOperation;
    }

    @Override
    public String operate(String queryText) {
        super.setOperation("/");
        super.operate(queryText);
        float r = operandOne / operandTwo;
        queryText = queryText.substring(0, pos1) + r + queryText.substring(pos2 + 1, queryText.length());
        return queryText;
    }
}
