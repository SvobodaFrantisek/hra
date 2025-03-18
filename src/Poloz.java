import java.util.Scanner;

public class Poloz implements Command {
    private Player player;
    private Scanner sc = new Scanner(System.in);

    public Poloz(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        if (player.getInventory().getItems().isEmpty()) {
            return "there's nothing to drop";
        }

        System.out.println("enter name of item you wanna drop from your inventory");
        String input = sc.nextLine().trim();

        Item foundItem = null;
        for (int i = 0; i < player.getInventory().getItems().size(); i++) {
            if (player.getInventory().getItems().get(i).getName().equalsIgnoreCase(input)) {
                foundItem = player.getInventory().getItems().get(i);
            }
        }

        if (foundItem != null) {
            player.getInventory().getItems().remove(foundItem);
            return "you droped" + foundItem.getName();
        } else {
            return "this item is not in your inventory";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}