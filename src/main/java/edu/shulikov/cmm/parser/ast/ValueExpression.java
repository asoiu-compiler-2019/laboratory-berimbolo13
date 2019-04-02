package edu.shulikov.cmm.parser.ast;

import edu.shulikov.cmm.lib.NumberValue;
import edu.shulikov.cmm.lib.StringValue;
import edu.shulikov.cmm.lib.Value;

public final class ValueExpression implements Expression {

    private final Value value;

    public ValueExpression(double value) {
        this.value = new NumberValue(value);
    }

    public ValueExpression(String value) {
        this.value = new StringValue(value);
    }

    @Override
    public Value eval() {
        return value;
    }

    @Override
    public String toString() {
        return value.asString();
    }
}
