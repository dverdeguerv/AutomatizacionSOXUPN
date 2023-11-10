package ContraseñasSOX.Tests;

import ContraseñasSOX.Base.ClaseBase;
import ContraseñasSOX.PageObjects.SOXPortalAlumno;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class SoxPortalAlumnoDashBoardTest {

    private WebDriver driver;
    SOXPortalAlumno soxPortalAlumno;
    ClaseBase claseBase;

    @Before
    public void SetUp() throws InterruptedException {
        soxPortalAlumno = new SOXPortalAlumno(driver);
        claseBase = new ClaseBase(driver);

        driver = soxPortalAlumno.ConnectionWebDriverChrome();
        soxPortalAlumno.getUrl("https://mimundo.upn.edu.pe/");
        Thread.sleep(5000);


    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void testPortalAlumno() throws InterruptedException {

        //Login y Modal
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soxPortalAlumno.ValidarLoginMicrosoft();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soxPortalAlumno.ValidarLoginPortalAlumno();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soxPortalAlumno.ValidarPortalAlumnoModal();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soxPortalAlumno.cerrarModalPortalAlumno();

        //

    }
}
