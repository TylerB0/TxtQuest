// the ultimate game
// TxtQuest
package TxtQuest;
public class Main {
    public static void main(String[] args) {
        /*
         * Bug corner
         * bug 1: enemy still hits player after win
         * bug 2: New Game doesnt work as intended
         * bug 3: not really a bug but pretty up the inventory to display in an understandable way
         * 
         * Everything here is for testing
         * a lot of stuff needs to be made private instead as well to justify the existence of the 
         * getters, that will be done eventually...
         */

        //System.out.println("");
        String[] slimetxt = {"The slime jiggles about.", "The slime's emotion is hard to read"};
        Enemy slime = new Enemy("Slime", 20, 2, 1, 2, slimetxt);
        Enemy daiSlime = new Enemy("DaiSlime", 30, 3, 2, 4, slimetxt);
        //String theName = slime.get_name();

        MapData slimeArea = new MapData(2);
        slimeArea.set_enemies(slime, daiSlime);
        Player you = new Player(0, 0, 0, 0);
        you = you.default_player();
        you.showStats();

        Game newGame = new Game(you, slimeArea);
        newGame.start();
    }
    
}
