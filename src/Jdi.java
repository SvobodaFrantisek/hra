import java.util.Scanner;

/**
 * Prikaz pro pohyb hrace mezi lokacemi.
 */
public class Jdi implements Command {
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Player player;
    private Location currentLocation = new Location();
    private Location targetLocation = new Location();

    public Jdi(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    /**
     * Vykona prikaz jdi, ktery umozni hraci pohybovat se mezi lokalitami na mape.
     * Hrac zada cilovou lokalitu, do ktere chce prejit. Pokud je cilova lokalita uzamcena, hrac musi mit
     * pozadovany predmet k jeji odemceni.
     *
     * @return Popis akce, zda se hrac pohyboval do nove lokality nebo zda byla lokalita uzamcena.
     */
    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        currentLocation = map.getCurrentLocation(currentID);
        System.out.println("Current " + currentLocation);
        System.out.println("Current ID: " + currentID);
        System.out.println("Avaible id of locations from this location" + currentLocation.getLocations());
        System.out.println("enter id of your target location");
        System.out.println(">>");
        try {
            int targetID = sc.nextInt();
            targetLocation = map.getWorld().get(targetID);

            if (targetLocation.isLocked()) {
                if (player.hasItem(targetLocation.getRequiredItem())) {
                    targetLocation.setLocked(false);
                    return "you used " + targetLocation.getRequiredItem() + " to unlock this location now you can go there";
                }
                return "this location is locked you need " + targetLocation.getRequiredItem() + " to unlock it";
            }

            if (currentLocation.getLocations().contains(targetID)) {
                map.setCurrentPosition(targetID);
                player.setHunger(player.getHunger() - 10);
                player.setHydration(player.getHydration() - 10);

                if (targetLocation.getName().equalsIgnoreCase("Kemp")) {
                    System.out.println("congratulations! you reached the camp and won the game!");
                    System.exit(0);
                }
            } else {
                return "you cant move there";
            }
            for (int i = 0; i < targetLocation.getCharacters().size(); i++) {
                Character character = targetLocation.getCharacters().get(i);
                if (character.getName().equals("Okradac_Mrtvol")){
                    if (player.hasItem("Pistol") && player.hasItem("Naboje")) {
                        player.decreaseHealth(10);
                        player.increaseStress(30);
                        return "you were attacked by okradac mrtvol but gun saved your life";
                    } else {
                        player.decreaseHealth(30);
                        player.increaseStress(10);
                        return "okradadac mrtvol escaped but it costs a lot of your hp";
                    }
                }
            }


            return "you move into" + targetLocation.getName();
        } catch (Exception e) {
            sc.nextLine();
            return " you entered invalid input";
        }
    }


    @Override
    public boolean exit() {
        return false;
    }
}
