package Zadatak;
public class Player extends GameObject {
    private String name; private int health;
    public Player(String name, int health, int x, int y, Collidable c) {
        super(x,y,c);
        if (health<0||health>100) throw new IllegalArgumentException();
        name = name.trim();
        if (name.isEmpty()) throw new IllegalArgumentException();
        name = name.substring(0,1).toUpperCase()+name.substring(1);
        this.name=name; this.health=health;
    }
    public int getHealth(){return health;}
    public void setHealth(int h){health=h;}
    @Override
    public String getDisplayName(){return name;}
    @Override
    public String toString(){return name+" ["+health+"] at ("+getX()+","+getY()+")";}
}