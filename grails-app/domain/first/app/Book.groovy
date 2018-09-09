package first.app

class Book {

    String title

    Integer pages

    Float price

    static hasOne = [bookDetail: BookDetail]

    static belongsTo = [category: Category]

    static hasMany = [reviews: Review, authors: Author]

    static constraints = {
      bookDetail unique: true
    }

    static mapping = {
      table 'books'
      reviews fetch: 'join'
    }
}
