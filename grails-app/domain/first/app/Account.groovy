package first.app

class Account {

    String accName

    Float balance

    static constraints = {
      balance min: 1000F
    }

    static mapping = {
      table 'accounts'
    }
}
