package com.example.healgaren.myapplication;

public class Profile {
    private String name;
    private String statusMessage;
    private String imageURL;

    public Profile(String name, String statusMessage, String imageURL) {
        this.name = name;
        this.statusMessage = statusMessage;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
