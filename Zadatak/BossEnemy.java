package Zadatak;
public class BossEnemy extends Enemy {
    public BossEnemy(String t,int x,int y,Collidable c,int d,int h){super(t,x,y,c,d,h);}    
    @Override
    public int getEffectiveDamage(){return super.getEffectiveDamage()*2;}
    @Override
    public String toString(){return "BOSS: "+getDisplayName();}
}