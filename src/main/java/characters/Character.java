package characters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public abstract class Character{
    @Getter @Setter
    private int power;
    @Getter
    private int hp;


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
}