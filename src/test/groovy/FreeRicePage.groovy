import geb.*

class FreeRicePage extends Page {

    static url = "http://freerice.com"

    static at = { title !=  "" }
    
    static content = {
    	changeSubject(wait: true) { $('.change').find("a") }
    	popup(wait: true, required: false) { $('#wfp-ew-dialog') }
    	popupCloseButton(wait: true) { popup.find('a') }
    	question(wait: true, required: false) { $('.question-link').find('b').text() }
    	numbers { question.split('x') }
    }

    def popupIsPresent() {
        popup
    }

    def playGame(numOfTimesToPlay) {

        def oldQuestion
        def newQuestion = $('.question-link').find('b').text()
        def i = 0
        while(i < numOfTimesToPlay) {
            clickOnAnswer()
            Thread.sleep(350)
            oldQuestion = getOldQuestion()
            newQuestion = $('.question-link').find('b').text()
            if (oldQuestion.equals(newQuestion)) {
                Thread.sleep(100)
            }   
            i++
        }
        true
    }

    def clickOnAnswer() {

    	def first = numbers[0]
    	def second = numbers[1]
    	def value = first.toInteger() * second.toInteger()

    	def answer = $('.answer-item', text: value.toString())
    	if (answer.isDisplayed()) {
    		answer.click()
    	}
    }

    def getOldQuestion() {
        def last = $('#game-status').find('td').text()
        if (last != null) {
            def formula = last.split('!')[1]
            def oldQuestion = formula.split('=')[0].trim()
            return oldQuestion
        }
        return ""
    }

    def getGameStatus() {
    	$('#game-status-right').text()
    }
}