public class Napoveda implements Command {
    private Map map;
    private Player player;

    public Napoveda(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    @Override
    public String execute() {
        int currentID = map.getCurrentPosition();
        Location currentLocation = map.getCurrentLocation(currentID);
        String inventory = player.getInventory().toString();
        String text = "";
        text += currentLocation.toString();
        text += "\n";
        text += inventory;

        return "Prozkoumavej ostatni mistnosti, sbirej itemy, pouzij item kdyz je to vhodne, promluv s civilistou kdyz ho najdes \n" + text;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
