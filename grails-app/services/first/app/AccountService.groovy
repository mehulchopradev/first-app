package first.app

import grails.gorm.transactions.Transactional

@Transactional
class AccountService {

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
    }
}
