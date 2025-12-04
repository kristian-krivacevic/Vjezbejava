package Zadatak;
public class Enemy extends GameObject implements Attacker {
    private String type; private int dmg; private int hp;
    public Enemy(String t, int x, int y, Collidable c, int dmg, int hp) {
        super(x,y,c);
        if (dmg<0||dmg>100||hp<0||hp>100) throw new IllegalArgumentException();
        this.type=t; this.dmg=dmg; this.hp=hp;
    }
    @Override
    public int getEffectiveDamage(){return dmg;}
    @Override
    public String getDisplayName(){return type;}
}