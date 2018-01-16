public class Line {
    private String content;

    public Line(String content) {
        this.content = content;
    }

    public String removeChar(int charPos) {
        StringBuffer strBuffer = new StringBuffer(content);
        content = strBuffer.deleteCharAt(charPos).toString();
        return content;
    }

    public String toString() {
        return content;
    }
}
