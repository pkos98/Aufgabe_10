public class Cursor {
    private int currentLineNumber = 1;
    private int currentCharPos = 1;

    public void movePreviousLine() { currentLineNumber--; }
    public void moveNextLine() {
        currentLineNumber++;
    }
    public void moveNextChar() {
        currentCharPos++;
    }

    public int getCurrentLineNumber() {
        return currentLineNumber;
    }
    public int getCurrentCharPos() {
        return currentCharPos;
    }



}
