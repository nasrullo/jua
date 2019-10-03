package jua.ast;

import jua.evaluator.Evaluator;
import jua.evaluator.IllegalCastException;
import jua.objects.LuaBoolean;
import jua.token.Operator;
import jua.token.TokenFactory;
import jua.token.TokenOperator;

public class ExpressionNot extends ExpressionUnary {

  ExpressionNot(TokenOperator token, Expression value) {
    super(TokenFactory.create(Operator.NOT, token.getLine(), token.getPosition()), value);
  }

  @Override
  public LuaBoolean evaluate(Evaluator evaluator) throws IllegalCastException {
    return new LuaBoolean(!LuaBoolean.valueOf(value.evaluate(evaluator)).getValue());
  }
}