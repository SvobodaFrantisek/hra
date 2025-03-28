import java.util.Scanner;

public class Pouzij implements Command {
    private Player player;
    private Scanner sc = new Scanner(System.in);

    public Pouzij(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.getInventory().getItems().isEmpty()) {
            return "no items to use in your invetory ";
        }

        System.out.println("what item you wanna use ");
        String itemName = sc.next().trim().toLowerCase();


        Item item = null;
        for (int i = 0; i < player.getInventory().getItems().size(); i++) {
            if (player.getInventory().getItems().get(i).getName().equalsIgnoreCase(itemName)) {
                item = player.getInventory().getItems().get(i);
            }
        }

        if (item != null) {
            player.getInventory().getItems().remove(item);
            return "you used " + item.getName();
        }

        return "this item is not in your invetory";

    }

    @Override
    public boolean exit() {
        return false;
    }
}