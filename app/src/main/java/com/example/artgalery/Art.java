package com.example.artgalery;

public class Art {
    private String description;
    private String genre;
    private String img;
    private String title;
    private String year;

    public Art() {
        // Порожній конструктор потрібний для Firebase
    }

    public Art(String description, String genre, String img, String title, String year) {
        this.description = description;
        this.genre = genre;
        this.img = img;
        this.title = title;
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }
}
