package first.app

// command objects
// command object is declared in the same file as the controller
// whose request data will be marshalled into the command object
class UserCommand {
  String username
  Integer password
  String country
  String gender
}

class PrivateController {

    // implict objects
    // 1) params
    // 2) flash
    // 3) request

    // data binding request parameters to action arguments
    /* def register(String username, Integer password, String country, String gender) {
      //receive the form data
      // data binding the request parameters into params map
      /* println params.username
      println params.country
      println params.gender */

      /* println username
      println password.class
      println country
      println gender

    } */

    def deactivate() {
      def u = User.get(1)
      def r = u.delete(flush: true)
      println "Delete ops : ${r}"
      // render "Physics : ${u.marks.physics}\nChemistry : ${u.marks.chemistry}"
    }

    def dummyRegister() {
      // OOP
      def u = new User(username: 'jane23', password: 'xyz345', gender: 'f',
        contact: new Contact(email: 'jane@gmail.com', mobile: '987898980', fax: '09875890'),
        marks: new Marks(physics: 93, chemistry: 94, maths: 100, verbal: 100, quant: 67))
      println u
      try {
        def r = u.save(failOnError: true)
        println r
      } catch (e) {
        println e
        u.errors.allErrors.each {
          println "Field : ${it.field}"
          println "Error value : ${it.rejectedValue}"
          println "Error Message : ${it.toString()}"
        }
      }

      render "Hello World!"
    }

    // data binding request parameters to a command object (OOP)
    def register(UserCommand user) {
      /* println user.username
      println user.password
      println user.country
      println user.gender */

      def file = request.getFile('profilePic')
      file.transferTo(new File('/home/mehul/Desktop/abc.jpg'))

      // save the data in some persistent store (Database)
      // ORM (GORM)
      def u = new User(username: user.username, password: user.password, country: user.country, gender: user.gender)
      u.save()

      // take the end user to the login page

      // some data to be stored and accessible in the request(2) after this request(1)
      flash['message'] = 'Register Success. Please Login'

      redirect(controller: 'public', action: 'login')
    }
}
