package com.DZ3;

import com.DZ3.Exception.GameNotFoundException;
import com.DZ3.Exception.NicknameBusyException;

import java.util.*;

public class ClubOfGamers implements GameClub {
    private String nickname; //Имя пользователя
    private Map<String, Integer> listOfGame = new HashMap<>(); //Список игр для каждого пользователя
    private static List<ClubOfGamers> gamers = new LinkedList<>(); //Списко всех пользователей

    private ClubOfGamers(String nickname, Map<String, Integer> listOfGame) {
        this.nickname = nickname;
        this.listOfGame = listOfGame;
    }


    public ClubOfGamers() {

    }

    public GameClub newUser(String nickname, Map<String, Integer> listOfGame) {

        try {
            for (ClubOfGamers cog : gamers) { //Проверка на занятость ника
                if (cog.getNickname().equals(nickname)) {
                    throw new NicknameBusyException();
                }
            }
            gamers.add(new ClubOfGamers(nickname, listOfGame)); //Добавляем нового пользователя в список всех пользователей
            return new ClubOfGamers(nickname, listOfGame);
        } catch (NicknameBusyException e) {
            e.printStackTrace();
        }
        return new NullClubOfGamers();

    }

    public List<ClubOfGamers> getListOfGamers() {
        gamers.forEach(System.out::println);
        return gamers;
    }

    public void game(String game) {
        try {
            checker(game);//Проверяем игру в списке игр пользователя
            if (new Random().nextInt(2) == 1) {
                winRate(game);
                System.out.println("Игра выиграна");
            } else {
                System.out.println("Игра проиграна");
            }
        } catch (GameNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void checker(String game) throws GameNotFoundException { //Проверка на наличие игры в списке
        for (Map.Entry<String, Integer> games : listOfGame.entrySet()) {
            if (games.getKey().equals(game)) {
                return;
            }
        }
        throw new GameNotFoundException();
    }

    private void winRate(String game) {
        for (Map.Entry<String, Integer> games : listOfGame.entrySet()) {
            if (games.getKey().equals(game)) {//Поиск игры по списку всех игр
                games.setValue(games.getValue() + 1);
                return;
            }
        }
    }

    public Set<String> getGamesName() {
        List<Map<String, Integer>> ls = new ArrayList<>(); //Список для хранения игр и рейтингов всех пользователей
        for (ClubOfGamers cog : gamers) {
            if (cog.getListOfGame().isEmpty())
                continue;
            ls.add(cog.getListOfGame());
        }
        Set<String> finalSetList = new HashSet<>();//Коллекция для хранения названий игр
        for (int i = 0; i < ls.size(); i++) {
            ls.get(i).entrySet().stream().forEach(el -> finalSetList.add(el.getKey()));
        }
        finalSetList.forEach(System.out::println);
        return finalSetList;
    }

    public GameClub getRateByNickname(String nick, String game) {
        //gamers.stream().filter(el -> el.getNickname().equals(nick)).forEach(fe -> fe.getListOfGame().entrySet().stream().filter(fil -> fil.getKey().equals(game)).findFirst());
        // Не даёт вызвать терминальную операцию...
        for (ClubOfGamers cog : gamers) {
            if (cog.getNickname().equals(nick)) {
                // Здесь нужно совпадение не только имени но и чтобы играть такая у пользователя присутсовала
                //System.out.println(cog.getListOfGame().entrySet().stream().filter(el -> el.getKey().equals(game)).findFirst());
                for (Map.Entry<String, Integer> games : cog.getListOfGame().entrySet()) {
                    if (games.getKey().equals(game)) {
                        System.out.println(games.getValue());
                        return cog; //Возвращаем пользователя
                    }
                }

            }
        }
        return new NullClubOfGamers(); // nullObject pattern
    }


    public void topBestOfTheBest(String game) {
        Map<String, Integer> map = new HashMap<>(); //Сохраняем ник и рейтинг в определённой игре
        gamers.forEach(el -> el.getListOfGame().entrySet().stream().filter(fil -> fil.getKey().equals(game)).forEach(fe -> map.put(el.getNickname(), fe.getValue())));
        // ↑ такое нормально? Или лучше делать как ↓?
        // эти записи эквивалентны
//        for (ClubOfGamers cog : gamers) {
//            cog.getListOfGame().entrySet().stream().filter(el -> el.getKey().equals(game)).forEach(el -> map.put(cog.getNickname(), el.getValue()));
//        }
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10).forEach(System.out::println);
        //Сортировка по значению и вывод первых 10 элементов
    }

    public void topBestOfTheBestOfAllGame() {
        Map<String, Integer> map = new HashMap<>(); //Сохраняем ник и рейтинг во всех играх
        for (ClubOfGamers cog : gamers) {
            int count = 0;
            for (Map.Entry<String, Integer> games : cog.getListOfGame().entrySet()) {
                count += games.getValue();
            }
            map.put(cog.getNickname(), count);
        }
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10).forEach(System.out::println);
        //Сортировка по значению и вывод первых 10 элементов
    }

    public void addGame(String game, Integer rating) {
        this.listOfGame.put(game, rating);
    }

    public static List<ClubOfGamers> getGamers() {
        return gamers;
    }

    public static void setGamers(List<ClubOfGamers> gamers) {
        ClubOfGamers.gamers = gamers;
    }

    public String getNickname() {
        return nickname;
    }

    public Map<String, Integer> getListOfGame() {
        return listOfGame;
    }

    public void setListOfGame(Map<String, Integer> listOfGame) {
        this.listOfGame = listOfGame;
    }

    @Override
    public String toString() {
        return "Член клуба игроманов: " +
                "ник: " + nickname +
                ", список игр: " + listOfGame;
    }
}