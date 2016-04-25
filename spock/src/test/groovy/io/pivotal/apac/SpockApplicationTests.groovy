package io.pivotal.apac

import org.junit.Rule
import org.junit.rules.TestName
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

//@RunWith(SpringRunner)
@SpringBootTest
class SpockApplicationTests extends Specification {
    @Rule
    TestName name

    def "retrieve test name at runtime"() {
        println "entering '$name.methodName'"
        expect:
        1 + 1 == 2
        println "leaving '$name.methodName'"
    }
    def "testing spock works"(){
        expect:
        true
    }
}
