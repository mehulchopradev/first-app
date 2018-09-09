package first.app

class User {

    String username
    String password
    String country
    String gender

    // compose of (embedded)
    Contact contact

    // composition
    static embedded = ['contact']

    static hasOne = [marks: Marks] //owner entity

    static constraints = {
      username maxSize: 20, unique: true, minSize: 4, blank: false
      password maxSize: 30, minSize: 5, blank: false
      country maxSize: 15, nullable: true
      gender inList: ['m','f']
    }

    static mapping = {
      table 'users'
    }
}

// for this to be embedded in user and not appear as a separate table, it should
// be in the same file as the entity in which it will be composed
class Contact {
  String email
  String mobile
  String fax
}
