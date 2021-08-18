package com.DZ3;

import java.util.*;

public interface GameClub {
    public GameClub newUser(String nickname, Map<String, Integer> listOfGame);

    public List<ClubOfGamers> getListOfGamers();

    public void game(String game);

    public Set<String> getGamesName();

    public GameClub getRateByNickname(String nick, String game);

    public void topBestOfTheBest(String game);

    public void topBestOfTheBestOfAllGame();
}
