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
    public Player(String name, int health,int hunger,int hydration, int stressLevel) {
        this.name = name;
        this.health = health;
        this.stress = stressLevel;
        this.inventory = new Inventar(this);
        this.hydration = hydration;
        this.hunger = hunger;

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

    public int getStress() {
        return stress;
    }

    public void setStress(int stress) {
        this.stress = stress;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHydration() {
        return hydration;
    }

    public void setHydration(int hydration) {
        this.hydration = hydration;
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
        if (itemName.equalsIgnoreCase("konzerva se zkazenym jidlem")) {
            health -= 20;
            if (hunger <= 90) {
                hunger += 10;
            }else {
                setHunger(100);
            }
        } else {
            if (hunger <= 70) {
                hunger += 30;
            } else {
                setHunger(100);
            }
        }
    }

    public void drink(String itemName) {
        if (itemName.equalsIgnoreCase("lahev se znecistenou vodou")) {
            health -= 20;
            if (hydration <= 90) {
                hydration += 10;
            }else {
                setHydration(100);
            }
        } else {
            if (hydration <= 70) {
                hydration += 30;
            }else {
                setHydration(100);
            }
        }
    }
    public void heal(){
        if(getHealth()<= 70){
            health += 30;
        }else{
            setHealth(100);
        }
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }
    public void increaseStress(int amount) {
        stress += amount;
    }
    public void dicreaseStress(int amount) {
        if (stress - amount<0){
            stress = 0;
        }

    }
    public String useItem(Item item) {
        String name = item.getName().toLowerCase();
        if (name.contains("konzerva")) {
            eat(name);
        } else if (name.contains("lahev")) {
            drink(name);
        } else if (name.equals("lekarnicka")) {
            heal();
        } else if (name.contains("batoh")) {
            inventory.setCapacity(15);
        } else if (name.contains("prasky na uklidneni")){
            dicreaseStress(20);
        }
        else {
            return "this item cant be used";
        }
        return name + " has been used";
    }
    public boolean isAlive() {
        return health > 0 && hunger > 0 && hydration > 0 && stress < 100;
    }
    public String status(){
        String vypis = "";
        vypis += " health " + getHealth()+"\n";
        vypis += " hunger " + getHunger()+"\n";
        vypis += " hydration " + getHydration()+"\n";
        vypis += " stress level " + getStress();
        return vypis;
    }





    @Override
    public String toString() {
        return "Player{" + "name='" + name + '\'' + ", health=" + health + ", stressLevel=" + stress + '}';
    }
}