package Zadatak;
public abstract class GameObject {
    private int x, y;
    private Collidable col;
    public GameObject(int x, int y, Collidable col) {
        this.x = x; this.y = y;
        if (col == null) throw new IllegalArgumentException();
        this.col = col;
    }
    public int getX(){return x;} public int getY(){return y;}
    public void setX(int x){this.x = x;} public void setY(int y){this.y = y;}
    public Collidable getCollider(){return col;}
    public boolean intersects(GameObject other){return col.intersects(other.col);}    
    public abstract String getDisplayName();
    @Override
    public String toString(){return getDisplayName()+" ("+x+","+y+")";}
    }