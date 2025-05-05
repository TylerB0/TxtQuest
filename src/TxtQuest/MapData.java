package TxtQuest;

import java.util.ArrayList;
    /*
     * This is for creating areas
     * 
     * Uses a list of enemies from the user
     * 
     * You need at least 2 enemies, one for regular encounters and one
     * for the boss
     * 
     * The size has to be at least 2 as well
     * 
     * variables are fairly self-explanatory
     */
    
public class MapData {

    ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    int listSize;

    MapData(int listSize) {
        if (listSize < 2) {
            this.listSize = 2;
        }
        this.listSize = listSize;
    }
    public int get_Size() {
        return this.listSize;
    }

    /*
     * Auto sets enemies, depends on listSize
     * 
     * Regular enemies will be set between position 0 and listSize - 2
     * boss will be placed at position listSize - 1
     * 
     * You will need to pass 2 Enemy objects, they can be the same if needed
     */
    public void set_enemies(Enemy regEnemy, Enemy boss) {
        for (int i = 0; i < listSize - 1; i++) {
            this.enemyList.add(regEnemy);
        }
        this.enemyList.add(boss);
    }
}
