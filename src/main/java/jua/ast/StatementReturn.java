package jua.ast;

import jua.evaluator.Evaluator;
import jua.evaluator.LuaRuntimeException;
import jua.objects.LuaObject;
import jua.token.Token;

public class StatementReturn extends Statement {
  private Expression value;

  public StatementReturn(Token token, Expression value) {
    super(token);
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    StatementReturn that = (StatementReturn) o;

    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + value.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("return %s", value);
  }

  @Override
  public LuaObject evaluate(Evaluator evaluator) throws LuaRuntimeException {
    return value.evaluate(evaluator);
  }
}
