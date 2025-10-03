package characters;
public class Elf extends Character{
    public Elf(){
        super(10, 10);
    }
    public void kick(Character c){
        if(getPower()>c.getPower()){
            c.setHp(0);
        } else{
            setHp(getHp()-1);
        }
    }
}
