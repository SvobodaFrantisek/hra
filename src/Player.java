/**
 * Trida reprezentujici hrace ve hre.
 */
public class Player {
    private String name;
    private int health;
    private int stress;
    private int hunger;
    private int hydration;
    private Inventar inventory;

    /**
     * Vytvori hrace s danym jmenem, zdravim a skore.
     *
     * @param name        Jmeno hrace.
     * @param health      Pocet zivotu hrace.
     * @param stressLevel Uroven stresu hrace.
     */
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

    /**
     * Zkontroluje, zda hrac ma urcity predmet.
     *
     * @param itemName Nazev predmetu.
     * @return true, pokud hrac ma predmet, jinak false.
     */
    public boolean hasItem(String itemName) {
        for (int i = 0; i < inventory.getItems().size(); i++) {
            if (inventory.getItems().get(i).getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public void eat(String itemName) {
        if (itemName.equalsIgnoreCase("")) {
            health -= 20;
            if (hunger <= 90) {
                hunger += 10;
            }
        } else {
            if (hunger <= 70) {
                hunger += 30;
            }
        }
    }

    public void drink(String itemName) {
        if (itemName.equalsIgnoreCase("")) {
            health -= 20;
            if (hydration <= 90) {
                hydration += 10;
            }
        } else {
            if (hydration <= 70) {
                hydration += 30;
            }
        }
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }

    public void increaseHealth(int amount) {
        health += amount;
    }

    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + ", health=" + health + ", stressLevel=" + stress + '}';
    }
}