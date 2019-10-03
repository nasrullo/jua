package ast;

import evaluator.Evaluator;
import evaluator.IllegalCastException;
import objects.LuaBoolean;
import token.TokenOperator;

public class ExpressionAnd extends ExpressionBinary {
  ExpressionAnd(TokenOperator token, Expression lhs, Expression rhs) {
    super(token, lhs, rhs);
  }

  @Override
  public LuaBoolean evaluate(Evaluator evaluator) throws IllegalCastException {
    return new LuaBoolean(
        LuaBoolean.valueOf(lhs.evaluate(evaluator)).getValue()
            && LuaBoolean.valueOf(rhs.evaluate(evaluator)).getValue());
  }
}
