package com.udg.edu.me;


class Player {
    private String name;
    private int x, y;
    private int width, height;
    private int health;

    public Player(String name, int x, int y, int width, int height, int health) {
        setName(name);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setHealth(health);
    }

    //nije prazno i prvo veliko slovo
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown";
        } else {
            name = name.trim().replaceAll("\\s+", " ");
            String[] words = name.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String w : words) {
                if (w.length() > 0)
                    sb.append(Character.toUpperCase(w.charAt(0)))
                      .append(w.substring(1).toLowerCase()).append(" ");
            }
            this.name = sb.toString().trim();
        }
    }

    public void setHealth(int health) {
        if (health < 0) health = 0;
        if (health > 100) health = 100;
        this.health = health;
    }

    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getHealth() { return health; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    @Override
    public String toString() {
        return "Player[" + name + "] (" + x + "," + y + ") " + width + "x" + height + " HP=" + health;
    }
}

