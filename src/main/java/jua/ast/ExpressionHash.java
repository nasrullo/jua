package jua.ast;

import jua.evaluator.Evaluator;
import jua.evaluator.IllegalTypeException;
import jua.evaluator.LuaRuntimeException;
import jua.objects.LuaNumber;
import jua.objects.LuaObject;
import jua.objects.LuaString;
import jua.objects.LuaTable;
import jua.token.Operator;
import jua.token.TokenFactory;
import jua.token.TokenOperator;

public class ExpressionHash extends ExpressionUnary {

  ExpressionHash(TokenOperator token, Expression value) {
    super(TokenFactory.create(Operator.HASH, token.getLine(), token.getPosition()), value);
  }

  @Override
  public LuaNumber evaluate(Evaluator evaluator) throws LuaRuntimeException {
    LuaObject o = value.evaluate(evaluator);

    if (o instanceof LuaString) {
      return new LuaNumber((double) ((LuaString) o).getValue().length());
    }

    if (o instanceof LuaTable) {
      // TODO
      return new LuaNumber(0.0);
    }

    throw new IllegalTypeException(
        String.format("Can't apply operator # on %s of type %s", o, o.getClass()));
  }
}