package TxtQuest;
public class Weapon extends Item {
    int atk;
    ItemTypes type = ItemTypes.WEAPON;

    Weapon(String itemName, int price, int sellPrice, String descrptn, int atk) {
        super(itemName, price, sellPrice, descrptn);
        this.atk = atk;
    }
    public int get_atk() {
        return this.atk;
    }
}
