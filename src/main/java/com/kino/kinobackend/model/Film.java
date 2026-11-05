package com.kino.kinobackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genres;
    private Double rating;

    // Геттеры и сеттеры (чтобы не писать руками, нажми Alt+Insert -> Getter and Setter)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenres() { return genres; }
    public void setGenres(String genres) { this.genres = genres; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
}