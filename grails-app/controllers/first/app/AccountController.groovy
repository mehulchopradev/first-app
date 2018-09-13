package first.app

import com.abc.exceptions.AccountSaveException

class AccountController {

    static layout = 'public'

    AccountService accountService

    def create() {
      [account: new Account()]
    }

    def save(String accName, Float balance) {
      try {
        accountService.createAccount(accName, balance)
        redirect(action: 'list')
      } catch (e) {
        println e
        // render "fail"
        render view: 'create', model: [account: e.failedAccount]
      }
    }

    def list() {
      [accounts: accountService.getAllAccounts()]
    }

    def edit(Long id) { // id refers to the value stored in the path param
      [account: accountService.getAccountById(id)]
    }

    def update(String accName, Float balance, Long id) {
      try {
        accountService.updateAccount(id, accName, balance)
        redirect(action: 'list')
      } catch (AccountSaveException ase) {
        render view: 'edit', model: [account: ase.failedAccount]
      }
    }

    def delete(Long id) {
      accountService.deleteAccount(id)
      flash.message = 'Record delete successfully'
      redirect(action: 'list')
    }

    def transfer() { }

    def initiateTransfer(Long from, Long to, Float transferAmount) {


      /*
      in Spring we never ever create dependent objects.
      DI (Dependency injection) where the object is rather created for us and assigned to us by an external container,
      without we asking for the object
      def a = new AccountService()
      a.performTransfer(from, to, transferAmount)
      */
      try {
        accountService.performTransfer(from, to, transferAmount)
        render "Transaction complete"
      } catch (e) {
        render e.message
      }
    }
}
