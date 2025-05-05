package TxtQuest;
import java.util.Random;

/*
 * Enemy objects
 * these are what the player fights in stages
 * making them too strong may make victory impossible
 */
public class Enemy {
    // similar vars to player, needs these attributes so it can interact with player properly
    // flavor text is just for fun though
    String name;
    int hp;
    int ttlHp;
    int atk;
    int def;
    int spd;
    int goldDrop;
    String[] flavTxt;

    /*
     * contructor for Enemy obj
     * Parameter(s): String for a name, int for each stat, String array for the flavor text
     */
    Enemy(String name, int hp, int atk, int def, int spd, String[] flavTxt) { 
        this.name = name;
        this.hp = hp;
        this.ttlHp = hp;
        this.atk = atk;
        this.def = def;
        this.spd = spd;
        this.flavTxt = flavTxt;
    }

    // getters
    public String get_name() {
        return this.name;
    }
    public int get_hp() {
        return this.hp;
    }
    public int get_ttlHp() {
        return this.ttlHp;
    }
    public int get_atk() {
        return this.atk;
    }
    public int get_def() {
        return this.def;
    }
    public int get_spd() {
        return this.spd;
    }
    public String get_txt() {
        Random r = new Random();
        int r1 = r.nextInt(100);
        r1 = r1%flavTxt.length;
        return flavTxt[r1];
    }
}
