package first.app

class BookController {

    // /book -> /book/index
    def index() {
      // fetch all the categories
      [categories: Category.list(sort: 'description', order: 'asc')]
    }

    def createAuthors() {
      def a = new Author(name: 'jude', gender: 'm', rating: 4)
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

      //type safe with comile time check on ur queries
      // loosely coupled way
      def maleCriteria = Author.where {
        gender == 'm'
      }

      def highestRatedMalesCriteria = Author.where {
        gender == 'm' && rating >= 3
      }

      def l = maleCriteria.list(sort: 'name', order: 'asc')
      println l
      // def cb = Author.createCriteria()
      /*def aulist = cb.list {
        eq('gender', 'm')
        ge('rating', 3)
        order('name', 'asc')
      }

      println aulist */

      /* def highestRated = cb.list(max: 3, offset: 0) {
        projections {
          property('name')
          property('rating')
        }
        eq('gender', 'm')
        order('rating', 'desc')
      }

      highestRated.each {
        println it[0]
        println it[1]
      }
      println highestRated.totalCount */

      /* def genderAvgRatings = cb.list {
        projections {
          groupProperty('gender')
          avg('rating')
        }
      }
      println genderAvgRatings
      */

      /* def genderSpecificCounts = cb.list {
        projections {
          count('gender')
          groupProperty('gender')
        }
      }

      println genderSpecificCounts */

      /*def maleAuthors = cb.list {
        or {
          eq('gender', 'f')
          le('rating', 1)
        }
      }
      println maleAuthors;*/
      // def authors = Author.list sort: 'name', order: 'asc'
      // println authors
      // def awesomeMaleAuthors = Author.findAllByGenderAndRatingGreaterThan('m', 2, [sort: 'rating', order: 'asc'])

      // def maleAuthors = Author.findAllWhere gender: 'm'
      // println maleAuthors

      // def lowestRating = Author.first sort: 'rating', order: 'asc'
      // println lowestRating

      //def ratingFilter = 4

      // def authors = Author.findAll('from Author a where a.rating >= ?', [ratingFilter]) //HQL
      /*def authors = Author.findAll('from Author a where a.gender = :gender and a.rating >= :rating order by a.name desc',
        [gender: 'm', rating: 3])
      println authors*/

      render "done"
    }

    def queryBooks() {
      // def book = Book.get(2)
      /* book.reviews.each { // lazy relationship
        println it.description
      } */
      /* def booksForIsbn = Book.where {
        bookDetail.isbn == 'fdgfd980870'
      }

      def l = booksForIsbn.list()
      println l */
      /* def cb = Book.createCriteria()
      def l = cb.list {
        bookDetail {
          eq('isbn', 'fdgfd980870')
        }
      }
      println l */

      def topAuthorBooks = Book.where {
        authors.rating >= 4
      }

      def l = topAuthorBooks.list()
      println l
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
      def a2 = Author.get(5)

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
