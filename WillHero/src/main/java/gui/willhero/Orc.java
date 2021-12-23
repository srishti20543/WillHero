package gui.willhero;

import javafx.scene.image.ImageView;

abstract class Orc extends GameObject{

    private int damage;
    private int health;
    private boolean isDead;
    private String color;
    private int displacement;

    Orc(int d, int hp, String c, int disp){
        this.isDead = false;
        this.damage = d;
        this.health = hp;
        this.color = c;
        this.displacement = disp;
    }

    public abstract void setHealth();
    public abstract void setDead();
    public abstract void getDead();
    public abstract void addOrc(ImageView orc);
    public abstract void stayOnIsland(FloatingIsland islands);
}

