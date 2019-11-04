package com.example.sinapses;

public class CardModel {
    private String title;
    private int image;
    private int abstractText;
    private String id_;
    private String content;

    public CardModel(String title, int image, int abstractText, String id_, String content) {
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

    public String getId_() {
        return id_;
    }

    public String getContent() {
        return content;
    }
}
