package characters;
import java.util.Random;

public abstract class Noble extends Character {
    protected static final Random rand = new Random();

    public Noble(int minPower, int maxPower, int minHp, int maxHp) {
        super(minPower + rand.nextInt(maxPower - minPower + 1),
              minHp + rand.nextInt(maxHp - minHp + 1));
    }

    @Override
    public void kick(Character c) {
        int damage = rand.nextInt(getPower() + 1);
        c.setHp(Math.max(0, c.getHp() - damage));
    }
}
