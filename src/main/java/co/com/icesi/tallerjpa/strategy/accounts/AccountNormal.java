package co.com.icesi.tallerjpa.strategy.accounts;

import co.com.icesi.tallerjpa.enums.TypeAccount;
import co.com.icesi.tallerjpa.model.Account;
import co.com.icesi.tallerjpa.strategy.accounts.interfaces.TypeAccountStrategy;

public class AccountNormal implements TypeAccountStrategy {

    @Override
    public TypeAccount getType() {
        return TypeAccount.ACCOUNT_NORMAL;
    }

    @Override
    public void withdraw(Long amount, Account account) {
        if (amount < 0) { throw new RuntimeException("The amount must be greater than 0"); }
        if(account.getBalance() < amount) { throw new RuntimeException("Insufficient funds"); }
        account.setBalance(account.getBalance() - amount);

    }

    @Override
    public void transfer(Long amount, Account accountOrigin, Account accountDestination, boolean isReceiverAccountValid) {
        if(!isReceiverAccountValid) { throw new RuntimeException("The account type does not allow transfers"); }
        if (amount < 0) { throw new RuntimeException("The amount must be greater than 0"); }
        if(accountOrigin.getBalance() < amount) { throw new RuntimeException("Insufficient funds"); }
        accountOrigin.setBalance(accountOrigin.getBalance() - amount);
        accountDestination.setBalance(accountDestination.getBalance() + amount);
    }

    @Override
    public boolean isReceiverAccountValid() {
        return true;
    }

    @Override
    public void deposit(Long amount, Account account) {
        if (amount < 0) { throw new RuntimeException("The amount must be greater than 0"); }
        account.setBalance(account.getBalance() + amount);

    }
}