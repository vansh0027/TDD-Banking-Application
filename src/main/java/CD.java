public class CD extends Account {

    CD(double amount, double apr) {
        super(amount, apr);


    }

    @Override
    public double getAmount(Integer id) {
        return ((CD) Bank.getID(id)).amount;
    }

    @Override
    public void deposit(Integer id, double amount) {
        ((CD) bank.get(id)).amount = ((CD) bank.get(id)).amount + amount;

    }

    @Override
    public void withdraw(Integer id, double amount) {
        ((CD) bank.get(id)).amount = ((CD) bank.get(id)).amount - amount;
        if (((CD) bank.get(id)).amount <= 0.00) {
            ((CD) bank.get(id)).amount = 0;

        }

    }


    public void Create(Integer id, Account account) {

        Bank.create(id, account);


    }
}
