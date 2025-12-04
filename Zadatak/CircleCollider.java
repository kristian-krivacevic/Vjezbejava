package Zadatak;
public class CircleCollider implements Collidable {
    private int cx, cy, r;
    public CircleCollider(int cx, int cy, int r) {
        if (r <= 0) throw new IllegalArgumentException();
        this.cx = cx; this.cy = cy; this.r = r;
    }
    private int clamp(int v, int min, int max){return Math.max(min, Math.min(v,max));}
    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof CircleCollider c) {
            int dx = cx - c.cx, dy = cy - c.cy;
            return dx*dx + dy*dy <= (r + c.r)*(r + c.r);
        }
        if (other instanceof RectangleCollider rc) {
            int nx = clamp(cx, rc.getX(), rc.getX()+rc.getW());
            int ny = clamp(cy, rc.getY(), rc.getY()+rc.getH());
            int dx = cx - nx, dy = cy - ny;
            return dx*dx + dy*dy <= r*r;
        }
        return false;
    }
}