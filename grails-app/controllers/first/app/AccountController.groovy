package first.app

class AccountController {

    AccountService accountService

    def transfer() { }

    def initiateTransfer(Long from, Long to, Float transferAmount) {


      /*
      in Spring we never ever create dependent objects.
      DI (Dependency injection) where the object is rather created for us and assigned to us by an external container,
      without we asking for the object
      def a = new AccountService()
      a.performTransfer(from, to, transferAmount)
      */

      accountService.performTransfer(from, to, transferAmount)
    }
}
