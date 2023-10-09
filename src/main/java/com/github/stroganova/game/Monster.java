package com.github.stroganova.game;

/*
* Класс Monster является насладеником абстрактного класса Creature.
* Методы attack и takeDamage переопределены у классов Player и Monster для демонстрации процесса игры.
*/


public class Monster extends Creature {
    public Monster(int health, int attack, int defense, int minDamage, int maxDamage) {
        super(health, attack, defense, minDamage, maxDamage);
    }

    @Override
    public void attack(Creature creature) {
        if (creature instanceof Player) {
            System.out.println("Monster attacks " + ((Player) creature).getName() + ".");
        }
        else {
            System.out.println("Monster attacks another monster.");
        }
        super.attack(creature);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("Monster takes damage " + String.valueOf(damage) +". " + "Monster's health now is " + String.valueOf(getCurrentHealth()) + ".");
        if (!isAlive()) {
            System.out.println("Monster is dead.");
        }
    }
}
