package gui.willhero;

public class Axe extends Weapons{

    private int level;

    Axe(){
        super("Knives", 10, 1, true);
        level = 1;
    }

    @Override
    public void setLevel() {
        level++;
    }
}
