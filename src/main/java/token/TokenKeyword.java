package token;

import java.util.Objects;

public class TokenKeyword extends Token {
  private Keyword keyword;

  protected TokenKeyword(Keyword keyword, int line, int position) {
    super(TokenType.KEYWORD, keyword.toString(), line, position);
    this.keyword = keyword;
  }

  public Keyword getKeyword() {
    return keyword;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    TokenKeyword that = (TokenKeyword) o;
    return keyword == that.keyword;
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyword);
  }
}
