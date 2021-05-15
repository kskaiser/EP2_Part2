package at.ac.tuwien.tiss.ep2;

public class Number implements Body {

    private Integer number;

    public Number(Integer number) {
        this.number = number;
    }

    @Override
    public String getValue() {
        return number.toString();
    }

    @Override
    public String getString() {
        return number.toString();
    }
}
