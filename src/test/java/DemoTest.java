import org.junit.jupiter.api.Test;

import characters.Character;
import characters.CharacterFactory;
import characters.Elf;
import characters.Hobbit;
import characters.King;
import characters.Knight;
import lombok.SneakyThrows;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

class DemoTest {
    @Test
    void hobbitAlwaysCries() {
        Character hobbit = new Hobbit();
        Character enemy = new Elf();

        hobbit.kick(enemy);
        assertEquals(3, hobbit.getHp());
        assertEquals(10, enemy.getHp());
    }

    @Test
    void elfKillsWeakerEnemy() {
        Character elf = new Elf();
        Character weak = new Hobbit();

        elf.kick(weak);
        assertEquals(0, weak.getHp());
        assertTrue(elf.getHp() > 0);
    }

    @Test
    void elfLosesHpAgainstStrongerEnemy() {
        Character elf = new Elf();
        Character stronger = new King();

        int before = elf.getHp();
        elf.kick(stronger);

        assertTrue(elf.getHp() <= before);
    }    
    
    @Test
    void kingHpAndPowerInRange() {
        Character king = new King();

        assertTrue(king.getPower() >= 5 && king.getPower() <= 15);
        assertTrue(king.getHp() >= 5 && king.getHp() <= 15);
    }

    @Test
    void knightHpAndPowerInRange() {
        Character knight = new Knight();

        assertTrue(knight.getPower() >= 2 && knight.getPower() <= 12);
        assertTrue(knight.getHp() >= 2 && knight.getHp() <= 12);
    }

    @Test
    void factoryCreatesDifferentCharacters()throws
        NoSuchMethodException,
        InstantiationException,
        IllegalAccessException,
        InvocationTargetException {
        Character c = CharacterFactory.createCharacter();
        assertNotNull(c);
        assertTrue(c instanceof Character);
    }


    @Test
    void charactersAreAliveWhenHpPositive() {
        Character c = new Knight();
        c.setHp(5);
        assertTrue(c.isAlive());

        c.setHp(0);
        assertFalse(c.isAlive());

        c.setHp(-1);
        assertFalse(c.isAlive());
    }
}