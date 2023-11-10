package ContraseñasSOX.PageObjects;

import ContraseñasSOX.Base.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SOXPortalAlumno extends ClaseBase {

    public SOXPortalAlumno(WebDriver driver) {
        super(driver);
    }

    //String grupo="Administrativos intranet";
    String nombreWeb = "PortalAlumno";
    String status = "";
    String opcion = "";
    String userLoginText = "N00191684@upn.pe";
    String passLoginText = "DreamTheater$89";


    //Localizadores de la Pagina

    //Login Para redireccionar a portal estudiante

    By ValidarLoginMicrosoft = By.name("loginfmt");//Caja de texto Logueo Microsoft
    By LoginUserMicrosoft = By.name("loginfmt");
    By LoginButtonMicrosoft = By.id("idSIButton9");

    //Login Portal Alumno
    By ValidarPortalAlumnoLogin = By.id("branding"); //Imagen Izquierda - Campus
    By LoginUserPortalAlumno = By.id("userNameInput");
    By LoginPassPortalAlumno = By.id("passwordInput");
    By LoginButtonPortalAlumno = By.id("submitButton");


    //Modal Portal Alumno
    By ModalPortalAlumnoDashBoard = By.xpath("/html/body/app-root/moo-app/div/section/moo-dashboard-main/moo-dash-popup-alert/div/div/img[2]");
    By CerrarModalPortalAlumnoDashBoard = By.xpath("/html/body/app-root/moo-app/div/section/moo-dashboard-main/moo-dash-popup-alert/div/div/img[1]");


    public void ValidarLoginMicrosoft() {
        opcion = "FirstLoginMicrosoft";
        if (isDisplayed(ValidarLoginMicrosoft)) {
            credencialesLoginMicrosoft();
        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }
    }

    public void credencialesLoginMicrosoft() {

        SendKeys(userLoginText, LoginUserMicrosoft);
        clickLoginMicrosoft();
    }

    public void clickLoginMicrosoft() {
        click(LoginButtonMicrosoft);
    }


    public void ValidarLoginPortalAlumno() {
        opcion = "SecondLoginPortalAlumno";
        if (isDisplayed(ValidarPortalAlumnoLogin)) {

            credencialesLoginPortalalumno();

        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);

        }
    }

    public void credencialesLoginPortalalumno() {
        SendKeys(userLoginText, LoginUserPortalAlumno);
        SendKeys(passLoginText, LoginPassPortalAlumno);
        clickLoginButtonPortalAlumno();
    }

    public void clickLoginButtonPortalAlumno() {
        click(LoginButtonPortalAlumno);
    }

    public void ValidarPortalAlumnoModal() throws InterruptedException {
        opcion = "ModalPortalAlumno";
        Thread.sleep(3000);
        if (isDisplayed(ModalPortalAlumnoDashBoard)) {
            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);
        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }
    }

    public void cerrarModalPortalAlumno() {
        click(CerrarModalPortalAlumnoDashBoard);
    }



}
