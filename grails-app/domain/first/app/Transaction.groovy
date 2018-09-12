package first.app

class Transaction {

    Long fromAccount

    Long toAccount

    Float amountTransferred

    static constraints = {
    }

    static mapping = {
      table 'transactions'
    }
}
