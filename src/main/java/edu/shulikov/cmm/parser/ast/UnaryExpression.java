package edu.shulikov.cmm.parser.ast;

import edu.shulikov.cmm.lib.NumberValue;
import edu.shulikov.cmm.lib.Value;

public final class UnaryExpression implements Expression {

    private final Expression expr1;
    private final char operation;

    public UnaryExpression(char operation, Expression expr1) {
        this.operation = operation;
        this.expr1 = expr1;
    }

    @Override
    public Value eval() {
        switch (operation) {
            case '-':
                return new NumberValue(-expr1.eval().asNumber());
            case '+':
            default:
                return expr1.eval();
        }
    }

    @Override
    public String toString() {
        return String.format("%c %s", operation, expr1);
    }
}
