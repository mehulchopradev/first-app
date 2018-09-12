package first.app

import grails.gorm.transactions.Transactional
import grails.gorm.transactions.NotTransactional
import com.abc.exceptions.AccountSaveException

@Transactional
class AccountService {

    TransactionService transactionService

    def createAccount(String accName, Float balance) {
      Account account = new Account(accName: accName, balance: balance)
      if (!account.validate()) {
        throw new AccountSaveException(account, 'Validation failed')
      }

      account.save()
    }

    def performTransfer(Long fromId, Long toId, Float amountToTransfer) {
      // business logic
      // ACID

      // transaction starts
      // For Account with id 'from' get the balance
      // Check whether for that balance whether the transfer can happen or no
      // if no -> error
      // if yes
        // deduct the transferAmount from account with id 'from'
        // Get Account with id 'to'
        // add the transferAmount to account with id 'to'
        // create a new Transaction and save it
      // transaction ends

      // transaction has started
      Account source = Account.get(fromId)
      if (source.balance < amountToTransfer) {
        throw new RuntimeException('Insufficient balance')
      }
      source.balance -= amountToTransfer
      if (!source.save(flush: true)) {
        // throw an exception
        throw new RuntimeException('Unable to add to the source account')
      }

      Account destination = Account.get(toId)
      destination.balance += amountToTransfer
      if (!destination.save(flush: true)) {
        // throw an exception
        throw new RuntimeException('Unable to add to the destination account')
      }

      transactionService.saveTransaction(fromId, toId, amountToTransfer)

      // all the steps in the above transaction succeded
    }
}
