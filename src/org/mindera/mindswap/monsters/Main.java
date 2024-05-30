package org.mindera.mindswap.monsters;

import static org.mindera.mindswap.monsters.MonsterTypeEnum.*;

public class Main {
    public static void main(String[] args) {

        int numberOfMonsters = 4;

        MonsterTypeEnum[] monsterList = {MUMMY, WEREWOLF, VAMPIRE, MUMMY, WEREWOLF, VAMPIRE};
        //Player p1 = new Player("Rui", p1MonsterList);
        Player p1 = new Player("Rui", monsterList);
        Player p2 = new Player("Sofia", monsterList);

        Game game = new Game(p1, p2);

        game.play();


    }
}
