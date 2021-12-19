package gui.willhero;

public class FloatingIsland extends GameObject{

    private int width;
    private int length;

    FloatingIsland(int w, int l){
        this.width = w;
        this.length = l;
    }
    @Override
    public void onCollision(User user) {

    }
}
