/**
 * Reprezentuje herni predmet.
 */
public class Item {
    private String name;
    private String description;
    private String location;

    /**
     * Vytvari item ve hre.
     *
     * @param name        nazev predmetu.
     * @param description popisek predmetu.
     * @param location    kde se predmet nachazi.
     */
    public Item(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", location='" + location + '\'' + '}';
    }
}