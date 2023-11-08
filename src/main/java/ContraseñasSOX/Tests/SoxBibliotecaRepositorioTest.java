package ContraseñasSOX.Tests;

import ContraseñasSOX.Base.base;
import ContraseñasSOX.PageObjects.SOXIntranetBibliotecaPage;
import ContraseñasSOX.PageObjects.SOXPayrollPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SoxBibliotecaRepositorioTest {

    private WebDriver driver;
    SOXIntranetBibliotecaPage soxIntranetBibliotecaPage;
    base base;

    @Before
    public void setUP() {
        soxIntranetBibliotecaPage = new SOXIntranetBibliotecaPage(driver);
        base = new base(driver);

        driver = soxIntranetBibliotecaPage.ConnectionWebDriverChrome();
        soxIntranetBibliotecaPage.getUrl("https://biblioteca.upn.edu.pe/");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test

    public void tests() throws InterruptedException {

        soxIntranetBibliotecaPage.ValidarPageBiblioteca();
        soxIntranetBibliotecaPage.ValidarOpcionNosotros();
        soxIntranetBibliotecaPage.ValidarOpcionServicios();
        soxIntranetBibliotecaPage.ValidarOpcionAdquisiciones();
        soxIntranetBibliotecaPage.ValidarOpcionServiciosEnLineaBibliotecaVirtual();
        soxIntranetBibliotecaPage.ValidarOpcionServiciosEnLineaCatalogoEnLinea();
        soxIntranetBibliotecaPage.ValidarOpcionServiciosEnLineaVideosTutoriales();
        soxIntranetBibliotecaPage.IrMainPageBiblioteca();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soxIntranetBibliotecaPage.clickRepositorioInstitucional();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        soxIntranetBibliotecaPage.ValidarRepositorioInstitucional();

    }
}
