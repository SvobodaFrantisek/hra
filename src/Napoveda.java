
public class Napoveda implements Command {
    @Override
    public String execute() {
        return "Prozkoumavej ostatni mistnosti, sbirej itemy, pouzij item kdyz je to vhodne, promluv s civilistou kdyz ho najdes";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
