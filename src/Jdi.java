import java.util.Scanner;

public class Jdi implements Command {
    private Scanner sc = new Scanner(System.in);
    private Location currentLocation = new Location();
    private Map map = new Map();

    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        Location cLocation = map.getCurrentLocation(currentID);
        System.out.println("Current Location: " + cLocation);
        System.out.println("Current ID: " + currentID);
        System.out.println("enter id of your target location");
        System.out.println("1-Opusteny_Dum, 2-Znicena_Ulice, 3-Namesti, 4-Opusteny_Obchod, 5-Park, 6-Podivny_Dum, 7-Opustena_Nemocnice, 8-Kemp");
        String input = sc.next();
        try {
            int targetID = Integer.parseInt(input);
            if (currentLocation.getLocations().contains(targetID)) {
               map.setCurrentPosition(targetID);
                System.out.println("you moved into: " + map.getCurrentLocation(targetID).getName());
            }else{
                System.out.println("you cant go there");
            }
        } catch (NumberFormatException e) {
            System.out.println("you entered an invalid input");
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
