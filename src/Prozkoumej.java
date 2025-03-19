import java.util.Scanner;

public class Prozkoumej implements Command {
    private Location location;
    private Scanner sc = new Scanner(System.in);
    private Map map;
    private Location currentLocation = new Location();
    private Location targetLocation = new Location();


    public Prozkoumej(Map map) {
        this.map = map;
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        currentLocation = map.getCurrentLocation(currentID);

        System.out.println("current " + currentLocation.getName());
        System.out.println("avaiable location to explore " + currentLocation.getLocations());
        System.out.print("enter ID of location you wannna explore ");
        System.out.println(">>");


        try {
            int targetID = sc.nextInt();

            targetLocation = map.getWorld().get(targetID);

            if (targetLocation == null) {
                return "this location is not available";
            }

            if (targetLocation.isLocked()) {
                return "this location is locked";
            }
            System.out.println(targetLocation.toString());


            return "you explored " + targetLocation.getName() + "avaiable items " + targetLocation.getAvailableItems();
        } catch (Exception e) {
            sc.nextLine();
            return "invalid input";
        }
    }
}
