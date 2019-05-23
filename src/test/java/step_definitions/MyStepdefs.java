package step_definitions;

import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    private WebDriver driver;
    private String url;

    @Given("something is done")
    public void somethingIsDone() {
        System.out.println("Udało się skonfigurowąć ogórka");

    }

    @When("{string} is printed")
    public void isPrinted(String parameter) {
        System.out.println(parameter);
    }

    @And("{int} is printed correctly")
    public void isPrintedCorrectly(int parameter) {
        int i = parameter + 3;
        System.out.println(i);
    }

    @But("we can use a list as well")
    public void weCanUseAListAsWell(List<String> list) {
//        list.forEach(System.out::println);
        for (String animal : list) {
            System.out.println(animal);
        }
    }

    @Given("people trying singing")
    public void peopleTryingSinging() {
        System.out.println("***siging****");
    }

    @When("now (.*) trying")       // tu moze zostac użyty każdy parametr
    public void nowPersonTrying(String person) {
        System.out.println("***" + person + "***");
    }

    @Then("sings (.*)")
    public void singsHow(String how) {
        System.out.println("***" + how + "***");

    }

    @Given("an open browser with google")
    public void anOpenBrowserWithGoogle() {
        System.setProperty("webdriver.chrome.driver", "C://Users/teo/driverChrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.pl");

    }

    @When("{string} word has been written into input field and submitted")
    public void wordHasBeenWrittenIntoInputFieldAndSubmitted(String input) {
        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys(input);
        inputField.submit();
    }


    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }


    @Then("the first should contain {string} result")
    public void theFirstShouldContainResult(String parameter) {
//        System.out.println(parameter);
        List<WebElement> elements = driver.findElements(By.cssSelector(".rc"));
//        assertEquals(parameter, elements.get(1).getText());
//        assertTrue(elements.get(1).getText().contains(parameter));
            for  (WebElement element : elements) {
                assertTrue(element.getText().contains(parameter));
        }
//        elements.forEach(webElement -> assertTrue(webElement.getText().contains(parameter)));


}


    @Given("browser opened with (.*)")
    public void browserOpenedWithPage( ) {
        System.setProperty("webdriver.chrome.driver","C://Users/teo/driverChrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }


    @When("user clicks on registration button")
    public void userClicksOnRegistrationButton() {
        driver.findElement(By.cssSelector(".bodytext a")).click();
    }

    @Then("user is on registration page")
    public void userIsOnRegistrationPage() {
        assertEquals("Add New User", driver.getTitle());
    }

    @When("user fills all mandatory fields")
    public void userAllMandatoryFields(List<String> inputValues ) {
        driver.findElement(By.name("first_ name")).sendKeys(inputValues.get(0));
        driver.findElement(By.name("last_name")).sendKeys(inputValues.get(1));
        driver.findElement(By.name("email")).sendKeys(inputValues.get(2));
        driver.findElement(By.name("address_1")).sendKeys(inputValues.get(3));
        driver.findElement(By.name("address_2")).sendKeys(inputValues.get(4));
        driver.findElement(By.name("phone_number")).sendKeys(inputValues.get(5));
        driver.findElement(By.name("city")).sendKeys(inputValues.get(6));
        driver.findElement(By.name("state")).sendKeys(inputValues.get(7));
        driver.findElement(By.name("zip")).sendKeys(inputValues.get(8));
        driver.findElement(By.name("password")).sendKeys(inputValues.get(9));

    }


    @When("user fills all mandatory fields with values")
    public void userFillsAllMandatoryFieldsWithValues(DataTable dataTable) {
        List<List<String>> lists = dataTable.asLists();
        System.out.println(lists);

        for (List<String> list : lists) {
            driver.findElement(By.name(list.get(0))).sendKeys(list.get(1));
        }

    }

    public void setUrl(String url) {
        this.url = url;
    }
}





