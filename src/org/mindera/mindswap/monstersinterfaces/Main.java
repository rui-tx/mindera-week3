package org.mindera.mindswap.monstersinterfaces;

import org.mindera.mindswap.monstersinterfaces.strikeable.monsters.MonsterTypeEnum;

import static org.mindera.mindswap.monstersinterfaces.strikeable.monsters.MonsterTypeEnum.*;

public class Main {
    public static void main(String[] args) {

        int numberOfMonsters = 1;

        MonsterTypeEnum[] monsterList = {MUMMY, WEREWOLF, VAMPIRE, MUMMY, WEREWOLF, VAMPIRE};
        //Player p1 = new Player("Rui", p1MonsterList);
        Player p1 = new Player("Rui", numberOfMonsters);
        Player p2 = new Player("Sofia", numberOfMonsters);

        Game game = new Game(p1, p2);
        game.play();
    }
}
