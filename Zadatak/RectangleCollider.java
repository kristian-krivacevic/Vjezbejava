package Zadatak;
public class RectangleCollider implements Collidable {
    private int x, y, w, h;
    public RectangleCollider(int x, int y, int w, int h) {
        if (w <= 0 || h <= 0) throw new IllegalArgumentException();
        this.x = x; this.y = y; this.w = w; this.h = h;
    }
    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof RectangleCollider r) {
            return x < r.x + r.w && x + w > r.x && y < r.y + r.h && y + h > r.y;
        }
        if (other instanceof CircleCollider c) return c.intersects(this);
        return false;
    }
    public int getX(){return x;} public int getY(){return y;} public int getW(){return w;} public int getH(){return h;}
}
