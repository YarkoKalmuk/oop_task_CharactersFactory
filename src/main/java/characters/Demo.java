package characters;

import java.lang.reflect.InvocationTargetException;

import lombok.SneakyThrows;

public class Demo {
    @SneakyThrows
    public static void main(String[] args)throws
        NoSuchMethodException,
        InstantiationException,
        IllegalAccessException,
        InvocationTargetException{ 
        Character randomCharacter = CharacterFactory.createCharacter();
        System.out.println(randomCharacter);

    }
}
