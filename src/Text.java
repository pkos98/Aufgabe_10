public class Text {
    private DoubleLinkedList<Line> lines;
    private Cursor cursor;

    public Text(Cursor cursor) {
        this.cursor = cursor;
        lines = new DoubleLinkedList();
    }
    public Text(Cursor cursor, String[] lines) {
        this(cursor);
        for (int i = 0; i < lines.length; i++)
            this.lines.add(new Line(lines[i]));
    }
    public Text(Cursor cursor, String text, String newLine) {
        this(cursor, text.split(newLine));
    }

    public void moveToNextLine() {
        if (cursor.getCurrentLineNumber() == lines.getLength()) {
            System.out.println("Already reached last line!");
            return;
        }
        cursor.moveNextLine();
    }
    public void moveToPreviousLine() {
        if (cursor.getCurrentLineNumber() == 1) {
            System.out.println("You already reached the first line!");
            return;
        }
        cursor.movePreviousLine();
    }

    public void moveToNextChar() {
        if (cursor.getCurrentCharPos() == getCurrentLineString().length()) {
            moveToNextLine();
        }
    }
    public String getCurrentLineString() {
        return getCurrentLine().toString();
    }

    public void removeCurrentChar() {
        getCurrentLine().removeChar(cursor.getCurrentCharPos());
    }

    public String toString() {
        String buffer = "";
        String currentOs = System.getProperty("os.name");
        String newLine = currentOs.equals("Windows") ?
                         "\r\n" : "\n";
        for (int i = 0; i <= lines.getLength(); i++) {
            buffer += lines.get(i) + newLine;
        }
        return buffer;
    }

    private Line getCurrentLine() {
        return lines.get(cursor.getCurrentLineNumber());
    }
}
