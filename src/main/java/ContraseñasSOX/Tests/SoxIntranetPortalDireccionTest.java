package ContraseñasSOX.Tests;

import ContraseñasSOX.Base.ClaseBase;
import ContraseñasSOX.PageObjects.SOXIntranetPortalDireccionPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SoxIntranetPortalDireccionTest {

    private WebDriver driver;
    SOXIntranetPortalDireccionPage soxIntranetPortalDireccionPage;
    ClaseBase ClaseBase;

    @Before
    public void setUP() {
        soxIntranetPortalDireccionPage = new SOXIntranetPortalDireccionPage(driver);
        ClaseBase = new ClaseBase(driver);

        driver = soxIntranetPortalDireccionPage.ConnectionWebDriverChrome();
        soxIntranetPortalDireccionPage.getUrl("https://intranet.upn.edu.pe/WebLogin/Bienvenido.aspx");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
         driver.quit();
    }

    @Test

    public void tests() {

        //Opcion Portal direccion
        soxIntranetPortalDireccionPage.credencialesLogin();
        soxIntranetPortalDireccionPage.clickLogin();
        soxIntranetPortalDireccionPage.ValidarIntranet();
        //soxIntranetPortalDireccionPage.clickPortalValidar();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        soxIntranetPortalDireccionPage.ValidarPortalMain();
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        //Opcion ReservasOnline
        soxIntranetPortalDireccionPage.clickReservasOnline();
        driver.switchTo().window(driver.getWindowHandles().toArray()[2].toString());
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        soxIntranetPortalDireccionPage.ValidarReservasOnline();



    }
}
