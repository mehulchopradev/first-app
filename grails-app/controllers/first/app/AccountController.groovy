package first.app

class AccountController {

    AccountService accountService

    def create() {
      [account: new Account()]
    }

    def save(String accName, Float balance) {
      try {
        accountService.createAccount(accName, balance)
      } catch (e) {
        println e
        // render "fail"
        render view: 'create', model: [account: e.failedAccount]
      }
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
