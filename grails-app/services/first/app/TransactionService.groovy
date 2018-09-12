package first.app

import grails.gorm.transactions.Transactional
import grails.gorm.transactions.NotTransactional
import org.springframework.transaction.annotation.Propagation

@Transactional
class TransactionService {

    @NotTransactional
    def getHighAmountTransactions() {
      def dw = Transaction.where {
        amountTransferred >= 10000
      }

      dw.list()
    }

    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    def saveTransaction(Long fromAccountId, Long toAccountId, Float amt) {
      /* Transaction transaction = new Transaction(fromAccount: fromAccountId, toAccount: toAccountId,
          amountTransferred: amountToTransfer) */

      Transaction transaction = new Transaction(fromAccount: fromAccountId,
              amountTransferred: amt)
      if (!transaction.save(flush: true)) {
        // throw an exception to the caller
        // this will cause the previous operations in the transaction to be rolled back
        throw new RuntimeException('Unable to save the transaction record')
      }
    }
}
