package first.app

class BookDetail {

    String publication

    String isbn

    static belongsTo = [book: Book]

    static constraints = {
    }

    static mapping = {
      table 'book_details'
    }
}
