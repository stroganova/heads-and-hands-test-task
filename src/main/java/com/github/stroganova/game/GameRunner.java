package com.github.stroganova.game;

/*
* Небольшой пример использования классов
*/    

public class GameRunner {
public static void main (String[] args) {
    Player player = new Player("Arthur", 100, 10, 15, 1, 6);
    Monster monster = new Monster(20, 17, 3, 3, 9);
    player.attack(monster);
    monster.attack(player);
    player.selfHeal();
}
}
