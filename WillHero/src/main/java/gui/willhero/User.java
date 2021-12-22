package gui.willhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

    private static int ID;
    private static int highScore = 0;
    private int health;
    private int currentScore;
    private int coinsCollected;
    private boolean isDead;
    private boolean isWinner;
    private boolean isResurrected;
    private ArrayList<Weapons> weaponsUnlocked;
    private Helmet helmetChosen;
    private Weapons curWeapon;
    private ImageView playerHelmet;


    User(ImageView player)
    {
        this.ID++;
        this.health = 100;
        this.currentScore = 0;
        this.coinsCollected = 0;
        this.isDead = false;
        this.isWinner = false;
        this.isResurrected = false;
        this.helmetChosen = new Penguin();
        this.playerHelmet = player;
        this. weaponsUnlocked = new ArrayList<>();
        weaponsUnlocked.add(new Knives());
        weaponsUnlocked.add(new Sword());
    }
    public void setCurrentScore(int score) {
        this.currentScore = score;
        highScore=Math.max(highScore,score);
    }

    public void setWinner(){
        if(currentScore >= 122) {
            this.isWinner = true;
        }
    }

    public void setDead(){
        if(health <= 0) {
            this.isDead = true;
            System.out.println("ded");
            if(isResurrected == false){
                //show resurrection menu
                isResurrected = true;
                //check conditions and set isDead = T/F
            }
            if (isResurrected == true){
                //game over
            }
        }
    }

    public void setHealth(int hp){
        this.health = hp;
        setDead();
    }

    public void setCoinsCollected(int val){
        coinsCollected += val;
    }


    public int updateWeapon(int val){
        weaponsUnlocked.get(val).update();
        return weaponsUnlocked.get(val).getLevel();
    }

    public void setWeaponImage(ImageView knife, ImageView sword){
        weaponsUnlocked.get(0).addWep(knife);
        weaponsUnlocked.get(1).addWep(sword);

    }

    public void setCurWeapon(int ind){
        if(curWeapon != null){
            curWeapon.toggle();
        }
        curWeapon = weaponsUnlocked.get(ind);
        curWeapon.toggle();
    }

    public void useCurWeapon(double pos){
        if(curWeapon == null){
            return;
        }
        curWeapon.use();

    }
}