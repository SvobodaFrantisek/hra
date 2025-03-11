public class Player {
    public String name;
    public int health;
    private Inventar inventar;
    private Location currentLocation;

    public Player(String name, int health, Inventar inventar, Location currentLocation) {
        this.name = name;
        this.health = health;
        this.inventar = inventar;
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
