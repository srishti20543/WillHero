package gui.willhero;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class WeaponChest extends Chest{

    private ArrayList<Node> weaponChestClosed = new ArrayList<Node>();
    private ArrayList<Node> weaponChestOpen = new ArrayList<Node>();

    private Weapons weapon;

    @Override
    public int onCollision(ImageView helmet) {
        for(int i = 0; i< weaponChestClosed.size(); i++){
            if (helmet.getBoundsInParent().intersects(weaponChestClosed.get(i).getBoundsInParent())) {
                animations.toggleOpacity((ImageView) weaponChestOpen.get(i));
                animations.toggleOpacity((ImageView) weaponChestClosed.get(i));
                weaponChestClosed.remove(weaponChestClosed.get(i));
                return 1;
            }
        }
        return -1;
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

    @Override
    public void addChest(ImageView closed, ImageView open) {
        weaponChestClosed.add(closed);
        weaponChestOpen.add(open);
    }
}
