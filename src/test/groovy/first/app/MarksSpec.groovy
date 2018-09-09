package first.app

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MarksSpec extends Specification implements DomainUnitTest<Marks> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
