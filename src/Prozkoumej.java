public class Prozkoumej implements Command{
    private Location location;

    public Prozkoumej(Location location) {
        this.location = location;
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String execute() {
        return "";
    }
}
