package motoresdebusqueda.dogpile.steps;

import motoresdebusqueda.dogpile.pageobject.DogPilePaginaResultado;
import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioDogPile {

    DogpilePaginaPrincipal paginaPrincipal;
    DogPilePaginaResultado paginaResultado;

    @Step("ingresa a la pagina principal de dogpile")
    public void ingresar_a_dogpile() {
        //paginaPrincipal.open();
        paginaPrincipal.abrirURL("https://www.dogpile.com/");
    }

    @Step("realiza una búsqueda de: {0}")
    public void busca_por_palabra_clave(String palabraClave) {
        paginaPrincipal.ingresarPalabraClave(palabraClave);
        paginaPrincipal.realizarBusqueda();
    }

    @Step("deberia poder ver resultados que contengan la palabra {0}")
    public void deberia_ver_resutlados_con_palabra(String palabraEsperada) {
        List<String> resultados = paginaResultado.obtenerResultados();
        resultados.replaceAll(String::toLowerCase);
        for (String resultado : resultados) {
            System.out.println(resultado);
        }

        assertThat(resultados, Matchers.everyItem(Matchers.containsString(palabraEsperada)));
    }
}
