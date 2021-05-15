package at.ac.tuwien.tiss.ep2;

public class Text implements Body {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String getValue() {
        return text;
    }

    @Override
    public String getString() {
        return text;
    }
}
