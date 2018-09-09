package first.app

class Author {

    String name
    String gender
    Integer rating

    static hasMany = [books: Book]

    static belongsTo = Book

    static constraints = {
    }

    static mapping = {
      table 'authors'
    }
}
