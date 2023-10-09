package com.github.stroganova.game;

/*
* Класс Player является насладеником класса Creature, помимо основных параметров имеет также имя игрока.
* Также реализует метод selfHeal - восстановление здоровья.
* Методы attack и takeDamage переопределены у классов Player и Monster для демонстрации процесса игры.
*/

public class Player extends Creature{
    private String name;
    private int numbersOfAvailableSelfHeals;

    public Player(String name, int health, int attack, int defense, int minDamage, int maxDamage) {
        super(health, attack, defense, minDamage, maxDamage);
        this.name = name;
        numbersOfAvailableSelfHeals = 4;
    }

    public void selfHeal() {
        if (numbersOfAvailableSelfHeals > 0) {
            int canHeal = (int) (3 * getMaxHealth() / 10);
            if ((canHeal + getCurrentHealth() > getMaxHealth())) {
                setCurrentHealth(getMaxHealth());
            } else {
                setCurrentHealth(getCurrentHealth() + canHeal);
            }
            numbersOfAvailableSelfHeals--;
            System.out.println(name + " is healed. " + name +  "'s health now is " + String.valueOf(getCurrentHealth()) + ".");
        }
        else {
            System.out.println("The number of possible heals has ended.");
        }
    }

    @Override
    public void attack(Creature creature) {
        if (creature instanceof Player) {
            System.out.println(name + " attacks " + ((Player) creature).getName() + ".");
        }
        else {
            System.out.println(name + " attacks monster.");
        }
        super.attack(creature);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println(name + " takes damage " + String.valueOf(damage) +". " + name + "'s health now is " + String.valueOf(getCurrentHealth()));
        if (!isAlive()) {
            System.out.println(name + " is dead.");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

