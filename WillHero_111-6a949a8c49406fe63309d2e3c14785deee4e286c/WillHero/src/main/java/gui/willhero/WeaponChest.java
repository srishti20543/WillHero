package gui.willhero;

public class WeaponChest extends Chest{

    private Weapons weapon;
    @Override
    public void onCollision(User user) {

    }

    public void generateWeapon(){
        int random = (int) (Math.random() * (2) + 1);
        if(random == 1){
            weapon = new Knives();
        }
        else if(random == 2){
            weapon = new Sword();
        }
    }
}
