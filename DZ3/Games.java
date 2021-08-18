package com.DZ3;

import java.util.List;

public class Games {
    private String gameName;
    private int rating;

    public Games(String gameName, int rating) {
        this.gameName = gameName;
        this.rating = rating;
    }

    public Games() {
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Название игры: " + gameName +
                ", рейтинг: " + rating;
    }
}
