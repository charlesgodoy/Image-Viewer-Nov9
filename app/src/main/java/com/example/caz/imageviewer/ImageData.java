package com.example.caz.imageviewer;

import java.io.Serializable;

public class ImageData implements Serializable {

    private String uri;

    // Constructor

    public ImageData(String uri) {
        this.uri = uri;
    }

    // Getters

    public String getUri() {

        return uri;
    }

    // Setters

    public void setUri(String uri) {
        this.uri = uri.toString();
    }
}
