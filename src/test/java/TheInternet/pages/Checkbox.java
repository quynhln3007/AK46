package TheInternet.pages;

public enum Checkbox {
    CHECKBOX_1("form#checkboxes input:nth-child(1)"),

    CHECKBOX_2("form#checkboxes input:nth-child(3)");

    private final String selector;

    Checkbox(String selector) {
        this.selector = selector;
    }
    public String getSelector(){
        return this.selector;
    }

}
