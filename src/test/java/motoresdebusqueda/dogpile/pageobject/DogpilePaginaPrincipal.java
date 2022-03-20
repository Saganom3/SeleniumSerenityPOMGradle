package motoresdebusqueda.dogpile.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

//@DefaultUrl("https://www.dogpile.com/")
public class DogpilePaginaPrincipal extends PageObject {

    @FindBy(css = "#q")
    @CacheLookup
    WebElement cajaDeBusqueda;

    @FindBy(css = "#search > button")
    @CacheLookup
    WebElementFacade botonDeBusqueda;

    public void abrirURL(String url) {
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    public void ingresarPalabraClave(String palabraClave) {
        cajaDeBusqueda.sendKeys(palabraClave);
    }

    public void realizarBusqueda() {
        botonDeBusqueda.click();
    }
}
