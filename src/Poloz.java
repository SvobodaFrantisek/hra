public class Poloz implements Command{
    private Item item;
    private Inventar inventar;

    public Poloz(Item item, Inventar inventar) {
        this.item = item;
        this.inventar = inventar;
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
