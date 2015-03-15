import geb.*

class FreeRiceCategoryPage extends Page {

    static url = "http://freerice.com/category"

    static at = { title ==  "Freerice.com" }

    static content = {
        multiplicationTable(wait: true) { $('a', text: "Multiplication Table") }
    }
}