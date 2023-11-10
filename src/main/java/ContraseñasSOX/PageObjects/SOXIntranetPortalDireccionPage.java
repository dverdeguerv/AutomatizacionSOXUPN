package ContraseñasSOX.PageObjects;

import ContraseñasSOX.Base.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SOXIntranetPortalDireccionPage extends ClaseBase {

    public SOXIntranetPortalDireccionPage(WebDriver driver) {
        super(driver);
    }

    //String grupo="Administrativos intranet";
    String nombreWeb = "PortalIntranet";
    String opcion = "";
    String status = "";
    String userLoginText = "vva";
    String PassLoginText = "Cambio203@@@@";


    //Localizadores de la Pagina

    //Login
    By LoginUser = By.id("logUPN_UserName");
    By LoginPass = By.id("logUPN_Password");
    By LoginButton = By.name("logUPN$LoginButton");

    //Main Portal Intranet
    By PageIsDisplayed = By.id("logo_UPN13");
    By OpcionPortalDireccionMain = By.partialLinkText("Dirección");

    //Reservas Online
    By OpcionReservasOnline = By.partialLinkText("Reservas");
    By ValidarReservasOnline = By.id("ddlTipoUsuario");

    //Localizadores Portal Direccion
    By MainPortalDireccion = By.xpath("//*[@id=\"mainNav\"]/div[1]/a");


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
            status = "Fail";
            screenShoot(status, nombreWeb);
        }
    }

    public void ValidarPortalMain() {
        opcion = "Direccion";
        if (isDisplayed(MainPortalDireccion)) {
            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);
        } else {

            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }
    }

    public void clickReservasOnline() {
        click(OpcionReservasOnline);

    }

    public void ValidarReservasOnline(){
        opcion="ReservasOnline";

        if (isDisplayed(ValidarReservasOnline)){
            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);
        }else {

            status="Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }
    }
}
