package com.DZ3;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class NullClubOfGamers implements GameClub {

    @Override
    public GameClub newUser(String nickname, Map<String, Integer> listOfGame) {
        return null;
    }

    @Override
    public List<ClubOfGamers> getListOfGamers() {
        return null;
    }

    @Override
    public void game(String game) {

    }

    @Override
    public Set<String> getGamesName() {
        return null;
    }

    @Override
    public GameClub getRateByNickname(String nick, String game) {
        return null;
    }

    @Override
    public void topBestOfTheBest(String game) {

    }

    @Override
    public void topBestOfTheBestOfAllGame() {

    }
}
