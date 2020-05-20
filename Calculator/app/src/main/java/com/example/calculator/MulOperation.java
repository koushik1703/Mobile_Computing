package com.example.calculator;

//Class for Mulplication Operation
public class MulOperation extends Operation {

    static MulOperation mulOperation = null;

    static MulOperation getInstance() {
        if(mulOperation == null) {
            mulOperation = new MulOperation();
        }
        return mulOperation;
    }

    @Override
    public String operate(String queryText) {
        super.setOperation("*");
        super.operate(queryText);
        float r = operandOne * operandTwo;
        queryText = queryText.substring(0, pos1) + r + queryText.substring(pos2 + 1, queryText.length());
        return queryText;
    }
}
