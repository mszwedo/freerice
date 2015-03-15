import spock.lang.*
import geb.*
import geb.spock.*

class FreeRiceSpec extends GebReportingSpec {

    def "get free rice"() {

        when:
        to FreeRicePage

        then:
        if(popupIsPresent()) {
            popupCloseButton.click()
        }

        then:
        changeSubject.click()

        then:
        waitFor { at FreeRiceCategoryPage }

        then:
        multiplicationTable.click()

        then:
        waitFor { at FreeRicePage }

        then:
        def numOfTimesToPlay = 10
        playGame(numOfTimesToPlay)

        then:
        System.out.println(getGameStatus())
    }

} 