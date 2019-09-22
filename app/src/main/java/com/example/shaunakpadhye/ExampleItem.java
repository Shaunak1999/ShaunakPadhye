package com.example.shaunakpadhye;

public class ExampleItem {
    private String text;
    private int align;

    public ExampleItem() { }

    public ExampleItem(String text, int asign) {
        this.text = text;
        this.align = asign;
    }

    public String getText() {
        return text;
    }

    public int getAlign() {
        return align;
    }
}
