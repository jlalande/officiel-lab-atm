package ca.ulaval.glo4002.atm.contexts;

import ca.ulaval.glo4002.atm.application.ServiceLocator;
import ca.ulaval.glo4002.atm.application.banking.BankingService;
import ca.ulaval.glo4002.atm.application.banking.ReceiptAssembler;
import ca.ulaval.glo4002.atm.domain.accounts.AccountRepository;
import ca.ulaval.glo4002.atm.domain.dispensers.CashDispenser;
import ca.ulaval.glo4002.atm.infrastructure.dispensers.SpxModel3CashDispenser;
import ca.ulaval.glo4002.atm.infrastructure.persistence.HibernateAccountRepository;

public class ProdContext implements Context {

    @Override
    public void apply() {
        ServiceLocator.registerSingleton(ReceiptAssembler.class, new ReceiptAssembler());
        ServiceLocator.registerSingleton(AccountRepository.class, new HibernateAccountRepository());
        ServiceLocator.registerSingleton(CashDispenser.class, new SpxModel3CashDispenser());
        ServiceLocator.registerSingleton(BankingService.class, new BankingService());
    }
}
