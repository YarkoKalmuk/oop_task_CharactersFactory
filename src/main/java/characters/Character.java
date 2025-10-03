package characters;

public abstract class Character{
    private int power;
    private int hp;

    public Character(int power, int hp) {
        this.power = power;
        this.hp = hp;
    }

    public Character() {
        this(0, 0);
    }

    public abstract void kick(Character c);

    public boolean isAlive(){
        return hp > 0;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + 
        "{power=" + power + ", hp=" + hp + "}";
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHp() {
        return hp;
    }
}