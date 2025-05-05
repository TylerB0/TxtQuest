package TxtQuest;

import java.util.Random;
import java.util.Scanner;

public class Game {
    
    /*
     * Various game states and interactions for the game to work
     * A Player and MapData object is needed to start
     * 
     */
    Player player;
    int pos = 0; //keeps track of position in map
    MapData map;
    int turnNum = 1; //turn number vs the current enemy, not needed but it looks nice
    boolean state = true; //supposed to be used to dictate whether the game keeps going or not, but kinda goes unused for now

    /*
     * constructor for the game
     * 
     * Paramter(s): Player obj, MapData obj
     * Output: None
     * 
     * initialize the Game object
     */
    Game(Player player, MapData map) {
        this.player = player;
        this.map = map;
    }

    /*
     * This is where the attack interaction is handled
     * 
     * Paramter(s): Enemy object
     * Output: none
     * 
     * First compares speed between player and enemy then whoever is faster hits first
     * Damage is then applied based on each party's stats
     * 
     * TO BE ADDED: Coin flip when speed tie
     */
    public void attack(Enemy enemy) {

        int tmpSpd = Integer.compare(this.player.get_spd(), enemy.get_spd());
        int tmp;
        
        if (tmpSpd < 0) {
            tmp = enemy.atk - this.player.get_def();
            if (tmp <= 0) {
                //deal 1 dmg to player
                this.player.hp-=1;
                game_overChk();
            }
            else {
                this.player.hp-=tmp;
                game_overChk();
            }
            if (this.player.hp ==0|| this.map.enemyList.get(pos).get_hp()==0)
                return;
            tmp = this.player.get_atk() - enemy.get_def();
            if (tmp <= 0) {
                enemy.hp-=1;
                winChk();
            }
            else {
                enemy.hp-=tmp;
                winChk();
            }
        }
        else {
            tmp = this.player.get_atk() - enemy.get_def();
            if (tmp <= 0) {
                enemy.hp-=1;
                winChk();
            }
            else {
                enemy.hp-=tmp;
                winChk();
            }
            if (this.player.hp ==0|| this.map.enemyList.get(pos).get_hp()==0)
                return;
            tmp = enemy.atk - this.player.get_def();
            if (tmp <= 0) {
                //deal 1 dmg to player
                this.player.hp-=1;
                game_overChk();
            }
            else {
                this.player.hp-=tmp;
                game_overChk();
            }
        }
    }

    /*
     * defend against the enemy
     * 
     * Paramter(s): Enemy obj
     * Output: none
     * 
     * Temporarily increases player defense but gives up attacking for that turn
     * Enemy still attacks
     */
    public void defend(Enemy enemy) {
        int tmp = this.player.get_def();
        this.player.def = this.player.def + (this.player.def/2);
        int tmp2 = enemy.atk - this.player.get_def();
            if (tmp2 <= 0) {
                //deal 1 dmg to player
                this.player.hp-=1;
                game_overChk();
            }
            else {
                this.player.hp-=tmp;
                game_overChk();
            }
    }

    /*
     * run away from an enemy
     * 
     * Paramter(s): None
     * Output: None
     * 
     * Using Random, do a coin flip to determine whether you can run or not
     * if successful you move on to the next area, if not you still take damage for that turn
     */
    public void run() {
        Random r = new Random();
        int r1 = r.nextInt(100) + 1;
        // get the 50/50 here
        r1 = r1%2;
        if (r1 == 0) {
            System.out.println("You managed to run away...");
            proceed();
        }
        else
            System.out.println("Escape attempt failed.");
    }

    /*
     * the menu for actions
     * 
     * Paramter(s): None
     * Output: None
     * 
     * lets you choose what you want to do for that stage/encounter
     */
    public void choices() {
        //while both parties still standing
        
        Scanner sc = new Scanner(System.in);
        while (this.player.get_hp() != 0 && this.map.enemyList.get(pos).get_hp() != 0 && pos < map.get_Size()) {
            System.out.println("------------------");
            System.out.println("Turn " + turnNum);
            System.out.println("Your HP: " + this.player.hp + "/" + this.player.ttlHp);
            System.out.println("Enemy HP: " + this.map.enemyList.get(pos).get_hp() + "/" + this.map.enemyList.get(pos).get_ttlHp());
            System.out.println("1: Attack   2: Defend   3: Item   4: Run");

            String choice = sc.nextLine();
            switch (choice) {
                case ("1"):
                turnNum++;
                attack(this.map.enemyList.get(pos));
                    break;
                case ("2"):
                turnNum++;
                defend(this.map.enemyList.get(pos));
                    break;
                case ("3"):
                this.player.inventory.displayInv();
                    break;
                case ("4"):
                turnNum++;
                run();
                    break;
                default:
                    break;
            }
        }
        sc.close();
        return;
    }

    /*
     * begins the game
     * 
     * Paramter(s): None
     * Output: None
     * 
     * Start at the first stage (which is really the first enemy in the list of enemies)
     * and go from there.
     * Calls choices() so you can perform actions
     */
    public void start() {
        pos = 0;
        int tmp = pos + 1;
        System.out.println("-----Stage " + tmp + "-----");
        System.out.println("A(n) " + map.enemyList.get(pos).get_name() + " approaches.");
        choices();

    }

    /*
     * Go to next stage
     * 
     * Paramter(s): None
     * Output: None
     * 
     * performs a check to see if you beat all enemies in the area/map, if not go to the next enemy
     */
    public void proceed() {
        this.pos+=1;
        areaWinChk();
        int tmp = pos + 1;
        if (pos >= map.get_Size())
            return;
        System.out.println("-----Stage " + tmp + "-----");
        System.out.println("A(n) " + map.enemyList.get(pos).get_name() + " approaches.");
    }

    /*
     * start a new game
     * 
     * Paramter(s): None
     * Output: None
     * 
     * Handles the players decision to continue with the game or not
     * Y continues, N ends game
     */
    public void new_game() {
        System.out.println("New Game? Y/N");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "Y":
            sc.close();
            start();
                break;
            case "N":
            sc.close();
            this.state = false;
            System.exit(0);
                break;
            default:
            sc.close();
            game_overChk();
                break;
            }
            sc.close();
            return;
    }

    /*
     * checks if player hp has hit 0
     * 
     * Paramter(s): None
     * Output: None
     * 
     * if the player has died ask if theyre done or want to restart
     */
    public void game_overChk() {
        if (this.player.hp == 0) {
            System.out.println("You have died.");
            new_game();
            return;
        }
    }

    /*
     * check if you beat an enemy
     * 
     * Paramter(s): None
     * Output: None
     * 
     * If the enemy is dead, move to nxt stage and continue fighting
     * Little message for gold gained 
     */
    public void winChk() {
        if (this.map.enemyList.get(this.pos).get_hp() <= 0) {
            turnNum = 1;
            System.out.println("You win!!!");
            int gold = this.map.enemyList.get(this.pos).goldDrop;
            this.player.gold+=gold;
            System.out.println("You got " + gold + "G.");
            areaWinChk();
            System.out.println("Moving to next stage...");
            proceed();
            return;
        };
    }

    /*
     * checks if you beat the area
     * 
     * Paramter(s): None
     * Output: None
     * 
     * If youve beaten all the enemies in an area, you'll be prompted to start a new game or exit
     */
    public void areaWinChk() {
        if (this.pos == map.get_Size()) {
            System.out.println("!!!!AREA CLEAR!!!");
            new_game();
            return;
        }
    }
}
