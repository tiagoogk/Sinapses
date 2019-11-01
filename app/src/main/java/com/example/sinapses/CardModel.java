package com.example.sinapses;

public class CardModel {
    private String title;
    private int image;
    private int abstractText;
    private String id_;

    public CardModel(String title, int image, int abstractText, String id_) {
        this.title = title;
        this.image = image;
        this.abstractText = abstractText;
        this.id_=id_;
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


}
