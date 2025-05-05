package TxtQuest;

/*
 * Player obj
 * the very culmination of your being
 * very important to the game, without it you cant play
 * various attributes common to RPGs are part of it's data
 */

public class Player{
    // Player attributes, if you know basic RPG terminology you'll know what these are
    // but i'll still explain if you somehow dont know
    int gold; //money
    int hp; // health points
    int ttlHp; // total health points
    int atk; // attack
    int ttlAtk; // total attack
    int def; // defense
    int ttlDef; // total defense
    int spd; // speed
    int ttlSpd; // total speed
    Item weapon;
    Item accessory;
    Item armor;
    Inventory inventory = new Inventory();

    /*
     * Player constructor
     * Paramter(s): 4 int's for the stats
     */
    Player(int hp, int atk, int def, int spd) { 
        this.hp = hp;
        this.ttlHp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
    }

    /*
     * Following 3 functions fall under the same general purpose so
     * I'll bunch the explanation here
     * 
     * Paramter(s): Weapon obj | Accessory obj | Armor obj
     * Output: None
     * 
     * Equips the item to the approporiate slot for the player
     * currently it's treated as separate from the inventory, someone
     * should realy fix that........
     */
    public void equipWeapn(Weapon newWeapn) {
            this.weapon = newWeapn;
            this.ttlAtk = atk + newWeapn.atk;
    }
    public void equipAcc(Accessory newAccsry) {
            this.accessory = newAccsry;
            this.ttlSpd = spd + newAccsry.spd;
    }
    public void equipArmr(Armor newArmr) {
            this.armor = newArmr;
            this.ttlDef = def + newArmr.def;
    }

    /*
     * heals the player
     * 
     * Paramter(s): Usable obj
     * Output: None
     * 
     * if the player's hp would go above the max, it's changed to be set to their current
     * max hp. Only items that have a heal amount > 0 will work. admittedly i think a boolean should 
     * have been used instead of checking a number
     */
    public void heal(Usable healItem) {
        if (healItem.healAmnt > 0) {
            int tmp = this.hp + healItem.healAmnt;
            if (tmp > ttlHp) {
                this.hp = this.ttlHp;
                this.inventory.rmvItem(healItem);
            }
            else {
                this.hp = tmp;
                this.inventory.rmvItem(healItem);
            }
        }
    }

    /*
     * creates a basic template for a player obj with everything initialized
     */
    public Player default_player() {
        Player newDude = new Player(50, 5, 5, 5);
        Weapon broadSwrd = new Weapon("Broad Sword", 100, 50, "A baic sword for combat. ATK +10.", 10);
        Armor chstPlate = new Armor("Chestplate", 120, 60, "Iron reinforced chest protection. DEF +8.", 8);
        Accessory bow = new Accessory("Bow", 50, 25, "A very cute bow. SPD +5.", 5);
        
        newDude.equipWeapn(broadSwrd);
        newDude.equipArmr(chstPlate);
        newDude.equipAcc(bow);

        Usable potion = new Usable("Potion", 50, 25, "A healing potion. Heals 20 HP.", 20);
        for (int i = 0; i < 3; i++) {
            newDude.inventory.addItem(potion);
        }
        Usable freebie = new Usable("Nugget", 0, 200, "Item for selling.", 0);
        newDude.inventory.addItem(freebie);

        return newDude;
    }

    /*
     * sets your inventory with an existing Inventory object
     * 
     * Paramter(s): Inventory obj
     * Output: None
     */
    public void set_invntry(Inventory inventory) {
        this.inventory = inventory;
    }

    //getters
    public int get_hp() {
        return hp;
    }
    public int get_atk() {
        return atk;
    }
    public int get_def() {
        return def;
    }
    public int get_spd() {
        return spd;
    }
    public int get_gold() {
        return gold;
    }

    /*
     * show the stats for the current player
     * currently goes unused in the actual game
     * 
     * Paramter(s): None
     * Output: None
     */
    public void showStats() {
        System.out.println("------------------");
        System.out.println("Here are your stats.");
        System.out.println("HP: " + this.hp + "/" + this.ttlHp);
        System.out.println("ATK: " + this.ttlAtk);
        System.out.println("DEF: " + this.ttlDef);
        System.out.println("SPD: " + this.ttlSpd);
        System.out.println("------------------");
    }
}
