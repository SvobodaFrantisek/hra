/**
 * Rozhrani pro herni prikazy.
 */
public interface Command {
    /**
     * Spusti prikaz.
     *
     * @return Vysledek provedeni prikazu.
     */
    String execute();

    /**
     * Urcuje, zda prikaz ukoncuje hru.
     *
     * @return true pokud prikaz ukoncuje hru, jinak false.
     */
    boolean exit();
}