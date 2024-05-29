package org.mindera.mindswap.monsters;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.*;

public class Main {
    public static void main(String[] args) {

        int numberOfMonsters = 4;

        MonsterTypeEnum[] p1MonsterList = {MUMMY, WEREWOLF, VAMPIRE, MUMMY};
        Player p1 = new Player("player 1", p1MonsterList);
        Player p2 = new Player("player 2", numberOfMonsters); // random monsters

        Game game = new Game(p1, p2);

        game.play();


    }
}
