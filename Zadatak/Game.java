package Zadatak;
import java.util.*;
import java.nio.file.*;
public class Game {
    private Player p;
    private ArrayList<Enemy> list=new ArrayList<>();
    private ArrayList<String> log=new ArrayList<>();
    public Game(Player p){this.p=p;}
    public void addEnemy(Enemy e){list.add(e);log.add("Added: "+e.getDisplayName());}
    public boolean checkCollision(Player p, Enemy e){return p.intersects(e);}    
    public void decreaseHealth(Player p, Enemy e){
        int nh=Math.max(0,p.getHealth()-e.getEffectiveDamage());
        p.setHealth(nh);
        log.add("Hit by "+e.getDisplayName()+" now "+nh);
    }
    public List<Enemy> findByType(String q){
        ArrayList<Enemy> r=new ArrayList<>();
        for(Enemy e:list) if(e.getDisplayName().toLowerCase().contains(q.toLowerCase())) r.add(e);
        return r;
    }
    public List<Enemy> collidingWithPlayer(){
        ArrayList<Enemy> r=new ArrayList<>();
        for(Enemy e:list) if(checkCollision(p,e)) r.add(e);
        return r;
    }
    public void resolveCollisions(){
        for(Enemy e:list) if(checkCollision(p,e)) decreaseHealth(p,e);
    }
    public static ArrayList<Enemy> loadEnemiesFromCSV(String path){
        try {
            ArrayList<Enemy> r=new ArrayList<>();
            for(String s:Files.readAllLines(Path.of(path))){
                String[] a=s.split(",");
                if(a.length<9) throw new IllegalArgumentException();
                String type=a[0]; String cls=a[1];
                int x=Integer.parseInt(a[2]); int y=Integer.parseInt(a[3]);
                String shape=a[4]; int d1=Integer.parseInt(a[5]); int d2=Integer.parseInt(a[6]); int dmg=Integer.parseInt(a[7]); int hp=Integer.parseInt(a[8]);
                Collidable c;
                if(shape.equals("rect")) c=new RectangleCollider(x,y,d1,d2);
                else c=new CircleCollider(x,y,d1);
                Enemy e = cls.equals("melee")? new MeleeEnemy(type,x,y,c,dmg,hp): new BossEnemy(type,x,y,c,dmg,hp);
                r.add(e);
            }
            return r;
        } catch(Exception e){throw new IllegalArgumentException();}
    }
}