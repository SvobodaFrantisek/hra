public class Player {
    private String name;
    private int health;
    private int stress;
    private Inventar inventory;


    public Player(String name, int health, int stressLevel) {
        this.name = name;
        this.health = health;
        this.stress = stressLevel;
        this.inventory = new Inventar(this);
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

    public int getStressLevel() {
        return stress;
    }

    public void setStressLevel(int stressLevel) {
        this.stress = stressLevel;
    }

    public Inventar getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", stressLevel=" + stress +
                '}';
    }
}