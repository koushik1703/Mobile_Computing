package com.example.calculator;

// Class to handle operation
public class Operation {

    String operation = "";
    String operand1 = "";
    String operand2 = "";
    int pos1 = 0;
    int pos2 = 0;
    int operatorIndex = 0;
    float operandOne = 0;
    float operandTwo = 0;

    public String operate(String queryText) {

        operand1 = "";
        operand2 = "";

        operatorIndex= queryText.indexOf(this.getOperation());

        for(int i = operatorIndex-1; i>=0 ; i--) {
            if(queryText.charAt(i) == '+' || queryText.charAt(i) == '-' || queryText.charAt(i) == '*' || queryText.charAt(i) == '/') {
                break;
            }
            operand1 = queryText.charAt(i) + operand1;
            pos1 = i;
        }

        for(int i = operatorIndex+1; i<queryText.length() ; i++) {
            if(queryText.charAt(i) == '+' || queryText.charAt(i) == '-' || queryText.charAt(i) == '*' || queryText.charAt(i) == '/') {
                break;
            }
            operand2 = operand2 + queryText.charAt(i);
            pos2 = i;
        }

        operandOne = Float.parseFloat(operand1);
        operandTwo = Float.parseFloat(operand2);

        return queryText;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }
}
