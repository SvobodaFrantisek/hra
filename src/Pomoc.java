/**
 * Trida reprezentujici prikaz pomoc.
 * Tento prikaz vypise dostupne prikazy ve hre.
 */
public class Pomoc implements Command {
    /**
     * Spusti prikaz pomoc a vypise seznam dostupnych prikazu.
     *
     * @return Text s napovedou.
     */
    @Override
    public String execute() {
        return "Dostupne prikazy: Jdi, Seber, Poloz, Mluv, Prozkoumej, Pomoc, Napoveda, Inventar, Konec";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
