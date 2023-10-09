package com.github.stroganova.game;
import java.util.Random;

/*
 * Абстрактный класс Creature описывает Существ, фигурирующих в игре.
 * Содержит все общие поля и методы для классов Игрок и Монстр.
 * Сеттеры проверяют допустимость переданных значений: Здоровье от 0 до N, Атака и Защита принимают значения от 1 до 30.
 * Минимальный урон не может быть отрицательным, а максимальный - меньше минимального.
 * Было решено оставить все геттеры и сеттеры public методами в целях тестирования и возможного усложнения реализации в дальнейшем,
 * например, для изменения в процессе игры параметров атаки, защиты, максимального возможного здоровья и т.д.
 */
public abstract class Creature {
    private int currentHealth;
    private int maxHealth;
    private int attack;
    private int defense;
    private int minDamage;
    private int maxDamage;

    private boolean isAliveValue;

    public Creature(int health, int attack, int defense, int minDamage, int maxDamage) {
        isAliveValue = true;
        setCurrentHealth(health);
        setMaxHealth(health);
        setAttack(attack);
        setDefense(defense);
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);
    }

    public void attack(Creature creature) {
        int attackModifier = attack - creature.getDefense() + 1;
        if (attackModifier < 1) {
            attackModifier = 1;
        }
        while (attackModifier > 0) {
            if (Dice.roll() >= 5) {
                System.out.println("The attack is successful!");
                creature.takeDamage(getRandomDamage());
                break;
            }
            attackModifier--;
        }
    }

    public void takeDamage(int damage) {
        if (currentHealth > damage) {
            setCurrentHealth(currentHealth - damage);
        }
        else{
            setCurrentHealth(0);
        }
    }

    public boolean isAlive() {
        return isAliveValue;
    }

    public int getRandomDamage() {
        Random r = new Random();
        return r.nextInt(maxDamage - minDamage) + minDamage;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        if (currentHealth < 0) {
            throw new IllegalArgumentException("Health can't be negative.");
        }
        this.currentHealth = currentHealth;
        if (currentHealth == 0) {
            isAliveValue = false;
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        if (maxHealth < 0) {
            throw new IllegalArgumentException("Health can't be negative.");
        }
        this.maxHealth = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack > 30 || attack < 1) {
            throw new IllegalArgumentException("Attack takes values from 1 to 30 inclusive.");
        }
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        if (defense > 30 || defense < 1) {
            throw new IllegalArgumentException("Defense takes values from 1 to 30 inclusive.");
        }
        this.defense = defense;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        if (minDamage <= 0) {
            throw new IllegalArgumentException("Yhe minimal damage can only be a positive number.");
        }
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        if (maxDamage < minDamage) {
            throw new IllegalArgumentException("Maximal damage cannot be less than the minimal.");
        }
        this.maxDamage = maxDamage;
    }
}
