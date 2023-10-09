package com.github.stroganova.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void healthArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Monster(-20, 5, 10, 2, 7);
        }, "IllegalArgumentException was expected.");
    }

    @Test
    void attackArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Monster(20, 40, 10, 2, 7);
        }, "IllegalArgumentException was expected.");
    }

    @Test
    void anotherAttackArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Monster(20, 0, 10, 2, 7);
        }, "IllegalArgumentException was expected.");
    }

    @Test
    void defenseArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Monster(20, 5, 100, 2, 7);
        }, "IllegalArgumentException was expected.");
    }

    @Test
    void anotherDefenseArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Monster(20, 5, -10, 2, 7);
        }, "IllegalArgumentException was expected.");
    }

    @Test
    void minimalDamageArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Monster(20, 5, 10, -1, 7);
        }, "IllegalArgumentException was expected.");
    }


    @Test
    void maximalDamageArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Monster(20, 5, 10, 7, 3);
        }, "IllegalArgumentException was expected.");
    }

    @Test
    void takeDamageTest() {
        Monster monster = new Monster(20, 5, 10, 7, 9);
        monster.takeDamage(20);
        Assertions.assertEquals(0, monster.getCurrentHealth());
    }

    @Test
    void selfHealTest() {
        Player player = new Player("A", 100, 5, 5, 2, 7);
        player.setCurrentHealth(50);
        player.selfHeal();
        Assertions.assertEquals(80, player.getCurrentHealth());
    }

}
