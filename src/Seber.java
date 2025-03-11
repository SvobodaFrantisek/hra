public class Seber implements Command{
    private Location location;
    private Inventar inventar;

    public Seber(Location location, Inventar inventar) {
        this.location = location;
        this.inventar = inventar;
    }

    @Override
    public String execute() {
        return "item polozen";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
