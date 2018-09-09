package first.app

class Review {

    String description
    Integer rating

    // bidirectional one to many relationship
    // static belongsTo = [book: Book]

    static constraints = {
    }

    static mapping = {
      table 'reviews'
    }
}
