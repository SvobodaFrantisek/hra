/**
 * Prikaz pro ukonceni hry.
 */
public class Konec implements Command {
    /**
     * Vykona prikaz konec, ktery ukonci hru.
     * Tento prikaz je urcen pro ukonceni hry a vystoupeni z aplikace.
     *
     * @return Zprava oznamujici ukonceni hry.
     */
    @Override
    public String execute() {
        return "Hra ukoncena";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
