package characters;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.reflections.Reflections;

import lombok.SneakyThrows;

public class CharacterFactory{
    private static final Random RANDOM = new Random();
    @SneakyThrows
    public static Character createCharacter()throws
        NoSuchMethodException,
        InstantiationException,
        IllegalAccessException,
        InvocationTargetException {
        Reflections reflections = new Reflections("characters");
        Set<Class<? extends Character>> subTypes = reflections.getSubTypesOf(Character.class);
        Class<? extends Character>[] subTypesArray = subTypes.toArray(new Class[0]);
        int choice = RANDOM.nextInt(subTypesArray.length);
        Class<? extends Character> chosenClass = subTypesArray[choice];
        return chosenClass.getDeclaredConstructor().newInstance();
    }
}