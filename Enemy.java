package com.udg.edu.me;

class Enemy {
    private String type;
    private int x, y;
    private int width, height;
    private int damage;

    public Enemy(String type, int x, int y, int width, int height, int damage) {
        setType(type);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setDamage(damage);
    }

    public void setType(String type) {
        if (type == null || type.trim().isEmpty()) {
            this.type = "Unknown";
        } else {
            this.type = type.trim().toLowerCase();
        }
    }

    public void setDamage(int damage) {
        if (damage < 0) damage = 0;
        if (damage > 100) damage = 100;
        this.damage = damage;
    }

    public String getType() { return type; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getDamage() { return damage; }

    @Override
    public String toString() {
        String t = type.substring(0,1).toUpperCase() + type.substring(1);
        return "Enemy[" + t + "] @ (" + x + "," + y + ") " + width + "x" + height + " DMG=" + damage;
    }
}



