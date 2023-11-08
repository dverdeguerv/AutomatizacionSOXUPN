package ContraseñasSOX.PageObjects;

import ContraseñasSOX.Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SOXIntranetPortalDireccionPage extends base {

    public SOXIntranetPortalDireccionPage(WebDriver driver) {
        super(driver);
    }

    //String grupo="Administrativos intranet";
    String nombreWeb = "PortalDireccion";
    String userLoginText = "vva";
    String PassLoginText = "Cambio203@@@@";


    //Localizadores de la Pagina

    //Login
    By LoginUser = By.id("logUPN_UserName");
    By LoginPass = By.id("logUPN_Password");
    By LoginButton = By.name("logUPN$LoginButton");

    //Main Portal Intranet
    By PageIsDisplayed = By.id("logo_UPN13");
    By OpcionPortalDireccionMain = By.xpath("//*[@id=\"medium-contenedor\"]/li[4]/a/img");

    //Localizadores Portal Direccion
    By MainPortalDireccion=By.xpath("//*[@id=\"mainNav\"]/div[1]/a");


    public void credencialesLogin() {
        SendKeys(userLoginText, LoginUser);
        SendKeys(PassLoginText, LoginPass);

    }

    public void clickLogin() {
        click(LoginButton);
    }

    public void clickPortalValidar() {
        click(OpcionPortalDireccionMain);
    }

    public void ValidarIntranet() {
        if (isDisplayed(PageIsDisplayed)) {
            click(OpcionPortalDireccionMain);
        } else {
            String Status = "Fail";
            screenShoot(Status, nombreWeb);
        }
    }

    public void ValidarPortalMain(){
        if (isDisplayed(MainPortalDireccion)){
            String status="Pass";
            screenShoot(nombreWeb,status);
        }else {

            String status="Fail";
            screenShoot(nombreWeb,status);
        }
    }
}
