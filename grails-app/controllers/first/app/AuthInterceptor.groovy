package first.app


class AuthInterceptor {

    AuthInterceptor() {
      matchAll()
        .excludes(controller: 'public')
        .excludes(controller: 'private')
    }

    boolean before() {
      def user = session.user
      if (!user) {
        redirect controller: 'public', action: 'login'
        return false
      }

      return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
