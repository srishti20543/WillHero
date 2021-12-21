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

    abstract public void setHealth();
    abstract public void setDead();
    abstract public void getDead();
    public abstract void addOrc(ImageView orc);
}

