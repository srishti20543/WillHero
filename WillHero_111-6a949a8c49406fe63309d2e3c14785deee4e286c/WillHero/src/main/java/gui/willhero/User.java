package gui.willhero;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

    private static int ID;
    private static int highScore = 0;
//    private int location;
    private int health;
    private int currentScore;
    private int coinsCollected;
    private boolean isDead;
    private boolean isWinner;
    private boolean isResurrected;
    private ArrayList<Weapons> weaponsUnlocked;
    private Helmet helmetChosen;


    User(String name)
    {
        this.ID++;
        this.health = 100;
        this.currentScore = 0;
        this.coinsCollected = 0;
        this.isDead = false;
        this.isWinner = false;
        this.isResurrected = false;
        this.helmetChosen = new Penguin();
        this. weaponsUnlocked = new ArrayList<>();
    }
    public void setCurrentScore(int score) {
        this.currentScore = score;
        highScore=Math.max(highScore,score);
    }

    public void setWinner(){
        if(currentScore == 122) {
            this.isWinner = true;
        }
    }

    public void setDead(){
        if(health <= 0) {
            this.isDead = true;
        }
        if(isResurrected == false){

        }
        if (isResurrected == true){

        }
    }

    public void setHealth(){
        this.health-=10;
    }

    public void setCoinsCollected(){
        this.coinsCollected++;
    }

    public void setWeaponsUnlocked(Weapons wep){
        weaponsUnlocked.add(wep);
    }

    public void setAll(int score){
        setWinner();
        setDead();
        setCurrentScore(score);
    }
}