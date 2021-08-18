package com.DZ3;

import com.DZ3.Exception.NicknameBusyException;

import java.util.*;

public class Task1 {

    public static void main(String[] args) throws NicknameBusyException {

        new ClubOfGamers().newUser("Nagibator228", new HashMap<String, Integer>() {{
            put("Apex Legends", 19);
            put("Warcraft", 55);
            put("Eve online", 34);
        }});
        new ClubOfGamers().newUser("Nagibator1337", new HashMap<String, Integer>() {{
            put("Starfiel", 26);
            put("Starcraft", 34);
            put("Eve online", 33);
        }});
        new ClubOfGamers().newUser("TaWeR", new HashMap<String, Integer>() {{
            put("Apex Legends", 30);
            put("ARK", 24);
            put("GTA online", 65);
        }});
        new ClubOfGamers().newUser("Anatoliy1986", new HashMap<String, Integer>() {{
            put("Kenshi", 54);
            put("Warcraft", 19);
            put("Rust", 25);
        }});
        new ClubOfGamers().newUser("TaWeR", new HashMap<String, Integer>());
        new ClubOfGamers().newUser("Markus", new HashMap<String, Integer>() {{
            put("Eve online", 66);
            put("Linage", 6);
            put("Forza Horizen", 10);
        }});
        new ClubOfGamers().newUser("Kesha007", new HashMap<String, Integer>() {{
            put("Apex Legends", 33);
            put("Warhammer 40000", 33);
            put("Eve online", 15);
        }});
        new ClubOfGamers().newUser("Azazello", new HashMap<String, Integer>() {{
            put("Neverwinter online", 20);
            put("ARK", 23);
            put("Sea of sea", 65);
        }});
        new ClubOfGamers().newUser("AlPachino", new HashMap<String, Integer>() {{
            put("Lost ark", 5);
            put("Resident Evil", 34);
            put("Eve online", 33);
        }});
        new ClubOfGamers().newUser("Darmoed", new HashMap<String, Integer>() {{
            put("FarCry", 15);
            put("Borderlands", 26);
            put("Kenshi", 98);
        }});
        new ClubOfGamers().newUser("Vladislav_Astakavickii", new HashMap<String, Integer>() {{
            put("Warframe", 5);
            put("Outlast", 3);
            put("Zaebalsa", 77);
        }});
        //(Arrays.asList(new HashMap<String, Integer>("Warframe", 5), new Games("Outlast", 3), new Games("Zaebalsa", 77))));
        new ClubOfGamers().newUser("Kachiko", new HashMap<String, Integer>() {{
            put("Genshi impact", 87);
            put("Skyrim", 16);
            put("Figure", 13);
        }});
        new ClubOfGamers().newUser("Chiko", new HashMap<String, Integer>() {{
            put("AFK arena", 32);
            put("Outcast", 6);
            put("Kenshi", 5);
        }});
        new ClubOfGamers().newUser("TERMINATOR", new HashMap<String, Integer>() {{
            put("Kenshi", 2);
            put("Eve online", 56);
            put("Joji", 55);
        }});
        new ClubOfGamers().newUser("Pedorator", new HashMap<String, Integer>() {{
            put("Skyrim", 96);
            put("The witcher", 70);
            put("Kean Dysso", 23);
        }});

        GameClub gamer = new ClubOfGamers().newUser("Azza", new HashMap<String, Integer>() {{
            put("ARK", 15);
        }});
        gamer.game("ARK");
        gamer.getListOfGamers();
        gamer.getGamesName();
        gamer.getRateByNickname("TaWeR", "ARK");
        System.out.println("Топ 10 по определённой игре");
        gamer.topBestOfTheBest("Eve online");
        System.out.println("Топ 10 по всем играм");
        gamer.topBestOfTheBestOfAllGame();
//        GameClub gamer1 = new ClubOfGamers().newUser("Azza", new HashMap<String, Integer>() {{
//            put("Kenshi", 2);
//            put("Eve online", 56);
//            put("Joji", 55);
//        }});  // Создание gamer1 выбивает NicknameBusyException
        gamer.topBestOfTheBest("ARK");
        gamer.getRateByNickname("TaWeR", "ARK");
    }


}


