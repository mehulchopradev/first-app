package first.app

class BookController {

    // /book -> /book/index
    def index() {
      // fetch all the categories
      [categories: Category.list(sort: 'description', order: 'asc')]
    }

    def createAuthors() {
      def a = new Author(name: 'steve', gender: 'm', rating: 4)
      try {
        def r = a.save(flush: true, failOnError: true)
        println r
      } catch (e) {
        println e
      }

      render "Done"
    }

    def queryAuthors() {
      //def authorCount = Author.count()
      // def maleAuthorCount = Author.countByGender('f')

      // def authors = Author.list()
      // def maleAuthors = Author.findAllByGender('m')
      // def authors = Author.list sort: 'name', order: 'asc'
      // println authors
      // def awesomeMaleAuthors = Author.findAllByGenderAndRatingGreaterThan('m', 2, [sort: 'rating', order: 'asc'])

      // def maleAuthors = Author.findAllWhere gender: 'm'
      // println maleAuthors

      // def lowestRating = Author.first sort: 'rating', order: 'asc'
      // println lowestRating

      def ratingFilter = 4

      // def authors = Author.findAll('from Author a where a.rating >= ?', [ratingFilter]) //HQL
      def authors = Author.findAll('from Author a where a.gender = :gender and a.rating >= :rating order by a.name desc',
        [gender: 'm', rating: 3])
      println authors

      render "done"
    }

    def queryBooks() {
      def book = Book.get(2)
      /* book.reviews.each { // lazy relationship
        println it.description
      } */
      render "done"
    }

    def updateAuthor() {
      def authorId = 2

      // updated data
      def requestData = [name: 'Steve', gender: 'm', rating: 3]

      def a = Author.get(authorId)
      a.properties = requestData

      try {
        a.save(flush: true, failOnError: true)
        render "Success"
      } catch (e) {
        println e
        render "Error"
      }
    }

    def dummySave() {
      def a1 = Author.get(1)
      def a2 = Author.get(2)

      // dynamic addTo* works with one to many collection
      def b = new Book(title: 'prog in scala', pages: 900, price: 876,
        bookDetail: new BookDetail(isbn: 'fdgfd980870', publication: 'Oracle pubs'),
        category: Category.get(1))
        .addToReviews(new Review(description: 'Amazing', rating: 4))
        .addToAuthors(a2)

      try {
        def r = b.save(flush: true, failOnError: true)
        render "Saved"
      } catch (e) {
        println e
        render "Error"
      }
    }

    def delete() {
      def b = Book.get(1)
      b.delete flush: true

      render "Delete success"
    }

    def save() {
      println params
      def b = new Book(params)
      try {
        def r = b.save(flush: true, failOnError: true)
        render "Saved"
      } catch (e) {
        println e
        render "Error"
      }
    }
}
