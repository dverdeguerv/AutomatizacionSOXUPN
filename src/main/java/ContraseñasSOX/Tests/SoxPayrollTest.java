package ContraseñasSOX.Tests;

import ContraseñasSOX.Base.base;
import ContraseñasSOX.PageObjects.SOXPayrollPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SoxPayrollTest {

    private WebDriver driver;
    SOXPayrollPage soxPayrollPage;
    base base;

    @Before
    public void setUP(){
        soxPayrollPage = new SOXPayrollPage(driver);
        base = new base(driver);

        driver = soxPayrollPage.ConnectionWebDriverChrome();
        soxPayrollPage.getUrl("https://payrollaws.upn.edu.pe:8443/psp/hcm92prd/?cmd=login&languageCd=ESP&");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
         driver.quit();
    }

    @Test

    public void tests() {

        soxPayrollPage.credencialesPayroll();
        soxPayrollPage.clickPayroll();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        soxPayrollPage.ValidarMainPayrroll();

    }
}
