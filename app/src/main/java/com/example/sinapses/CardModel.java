package com.example.sinapses;

public class CardModel {
    private String title;
    private int image;
    private int abstractText;
    private int id_;
    private int content;

    public CardModel(String title, int image, int abstractText, int id_, int content) {
        this.title = title;
        this.image = image;
        this.abstractText = abstractText;
        this.id_=id_;
        this.content=content;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public int getAbstractText() {
        return abstractText;
    }

    public int getId_() {
        return id_;
    }

    public int getContent() { return content;
    }
}
