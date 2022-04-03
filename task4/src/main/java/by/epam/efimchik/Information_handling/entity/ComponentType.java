package by.epam.efimchik.Information_handling.entity;

public enum ComponentType {
    TEXT("", "\n"),
    PARAGRAPH("\s\s", ""),
    SENTENCE("", ""),
    LEXEME("", ""),
    WORD("\s", ""),
    LETTER("", ""),
    PUNCTUATION("","");

    private String before;
    private String after;

    ComponentType() {
    }

    ComponentType(String before, String after) {
        this.before = before;
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }
}
