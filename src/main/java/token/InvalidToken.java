package token;

public class InvalidToken extends Token {
    InvalidToken(int line, int position, String litteral) {
        super(TokenType.INVALID, line, position, litteral);
    }
}
