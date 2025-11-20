package Projekat4;
public abstract class Enemy extends GameObject implements Attacker {
    protected String type;
    protected int damage;
    protected int health;

    public Enemy(String type, int x, int y, Collidable c, int damage, int health) {
        super(x, y, c);
        if (type == null || type.trim().isEmpty()) throw new IllegalArgumentException();
        this.type = type.trim();
        if (damage < 0 || damage > 100) throw new IllegalArgumentException();
        if (health < 0 || health > 100) throw new IllegalArgumentException();
        this.damage = damage;
        this.health = health;
    }

    public int getHealth() { return health; }

    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + type + "] (" + x + "," + y + ") DMG=" + damage + " HP=" + health;
    }
}
 