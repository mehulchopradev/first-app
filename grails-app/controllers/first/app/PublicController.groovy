package first.app

import com.abc.domain.Country

class PublicController {

    // static layout = 'main'

    def login() {
      def current = new Date()
      def message = flash['message']

      [currentTimestamp: current, message: message ?: null] // gets stored in the request scope
      // using the same request scope, grails will dispatch ur request to login.gsp
    }

    def register() {
      // fetch the countries from an external data source
      def countries = [
        new Country(code: 'IN', fullName: 'India'),
        new Country(code: 'US', fullName: 'United States of america'),
        new Country(code: 'CH', fullName: 'China')
      ]

      [countries: countries, selectedCountry: 'US']
    }
}
