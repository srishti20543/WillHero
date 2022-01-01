package gui.willhero;

import javafx.scene.Node;

abstract class Weapons extends GameObject{
    private String name;
    private int level;
    private boolean unlocked;
    private int damage;

    Weapons(String name, int damage){
        this.name = name;
        this.damage = damage;
        this.level = 0;
        this.unlocked = false;
    }
    public abstract void use();
    public abstract void toggle();
    public abstract Node getImg();

    public void update(){
        if(!unlocked){
            unlocked = true;
        }
        level++;
        if(level > 1){
            damage += 2;
        }
    }

    public int getDamage(){
        return this.damage;
    }

    public int getLevel(){
        return this.level;
    }
}
