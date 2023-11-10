package ContraseñasSOX.PageObjects;

import ContraseñasSOX.Base.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SOXIntranetBibliotecaPage extends ClaseBase {

    public SOXIntranetBibliotecaPage(WebDriver driver) {
        super(driver);
    }

    //String grupo="Administrativos intranet";
    String nombreWeb = "Biblioteca";
    String status = "";
    String opcion = "";

    ////Localizadores de la Pagina
    By MetaBuscador = By.id("ebscohostsearchtext");

    //Localizadores Page Nosotros
    By OpcionNosotros = By.xpath("//*[@id=\"block-upn-barrio-main-menu\"]/ul/li[1]/a");
    By ValidarPageNosotros = By.xpath("//*[@id=\"block-upn-barrio-page-title\"]/div/div/h1");

    /////Localizadores Page Servicios
    By OpcionServicios = By.xpath("//*[@id=\"block-upn-barrio-main-menu\"]/ul/li[2]/a");
    By ValidarPageServicios = By.xpath("//*[@id=\"block-upn-barrio-page-title\"]/div/div/h1");

    //////Localizadores Page Adquisiciones
    By OpcionAdquisiciones = By.xpath("//*[@id=\"block-upn-barrio-main-menu\"]/ul/li[4]/a");
    By ValidarPageAdquisiciones = By.xpath("//*[@id=\"block-upn-barrio-page-title\"]/div/div/h1");

    /////Localizadores Servicios en Linea
    By OpcionServiciosEnLinea = By.xpath("//*[@id=\"block-upn-barrio-main-menu\"]/ul/li[3]/a");
    By OpcionBibliotecaVirtualServicios = By.xpath("//*[@id=\"block-upn-barrio-main-menu\"]/ul/li[3]/ul/li[1]/a");
    By OpcionCatalogoEnLineaServicios = By.xpath("//*[@id=\"block-upn-barrio-main-menu\"]/ul/li[3]/ul/li[2]/a");
    By ValidarCatalogoEnLineaServicio = By.xpath("//*[@id=\"block-upn-barrio-content\"]/div/article/div/div/div/div/div[2]/div/div/a");
    By OpcionVideosTutorialesServicios = By.xpath("//*[@id=\"block-upn-barrio-main-menu\"]/ul/li[3]/ul/li[3]/a");
    By ValidarVideosTutorialesServicio = By.xpath("//*[@id=\"views-bootstrap-videos-tutoriales-page-1\"]/div/div[1]/div/a");

    //Localizadores Opcion Biblioteca Virtual
    By LibrosVirtuales = By.xpath("//*[@id=\"views-bootstrap-tab-views-bootstrap-biblioteca-virtual-page-2\"]/div[1]/ul/li[1]/a");
    By BaseDeDatos = By.xpath("//*[@id=\"views-bootstrap-tab-views-bootstrap-biblioteca-virtual-page-2\"]/div[1]/ul/li[2]/a");

    By RevistasDigitales = By.xpath("//*[@id=\"views-bootstrap-tab-views-bootstrap-biblioteca-virtual-page-2\"]/div[1]/ul/li[3]/a");
    By Diarios = By.xpath("//*[@id=\"views-bootstrap-tab-views-bootstrap-biblioteca-virtual-page-2\"]/div[1]/ul/li[4]/a");
    By AccesoAbiertp = By.xpath("//*[@id=\"views-bootstrap-tab-views-bootstrap-biblioteca-virtual-page-2\"]/div[1]/ul/li[5]/a");


    //Repositorio Institucional

    By RepositorioInstitucional = By.xpath("//*[@id=\"block-homeservicioenlinea\"]/div[2]/div/div/div[4]/div/div/a");
    By ValidarRepositorioInstitucional = By.xpath("/html/body/header/div/div[1]/div/a/img");
    By PageIsDisplayed = By.xpath("//*[@id=\"navbar-main\"]/a/img");

    public void ValidarPageBiblioteca() {
        opcion = "MainPage";
        if (isDisplayed(PageIsDisplayed)) {
            SendKeys("Prueba MetaBuscador", MetaBuscador);
            status = "Pass";

            screenShoot(nombreWeb + "_" + opcion, status);

        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }

    }

    public void ValidarOpcionNosotros() {
        opcion = "OpcionNosotros";
        click(OpcionNosotros);
        if (isDisplayed(ValidarPageNosotros)) {
            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);
        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);

        }

    }

    public void ValidarOpcionServicios() {
        opcion = "OpcionServicios";
        click(OpcionServicios);
        if (isDisplayed(ValidarPageServicios)) {

            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);

        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }

    }

    public void ValidarOpcionAdquisiciones() {
        opcion = "OpcionAdquisiciones";
        click(OpcionAdquisiciones);
        if (isDisplayed(ValidarPageAdquisiciones)) {

            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);

        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }
    }

    public void ValidarOpcionServiciosEnLineaBibliotecaVirtual() throws InterruptedException {
        opcion = "OpcionServiciosEnLineaBibliotecaVirtual";
        click(OpcionServiciosEnLinea);
        click(OpcionBibliotecaVirtualServicios);
        if (isDisplayed(LibrosVirtuales)) {

            click(BaseDeDatos);
            Thread.sleep(1000);
            click(RevistasDigitales);
            Thread.sleep(1000);
            click(Diarios);
            Thread.sleep(1000);
            click(AccesoAbiertp);

            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);


        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }


    }

    public void ValidarOpcionServiciosEnLineaCatalogoEnLinea() {
        opcion = "OpcionServiciosEnLineaCatalogoEnLinea";
        click(OpcionServiciosEnLinea);
        click(OpcionCatalogoEnLineaServicios);
        if (isDisplayed(ValidarCatalogoEnLineaServicio)) {

            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);


        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }


    }

    public void ValidarOpcionServiciosEnLineaVideosTutoriales() {
        opcion = "OpcionServiciosEnLineaVideosTutoriales";
        click(OpcionServiciosEnLinea);
        click(OpcionVideosTutorialesServicios);
        if (isDisplayed(ValidarVideosTutorialesServicio)) {

            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);


        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }

    }

    public void IrMainPageBiblioteca() {
        click(PageIsDisplayed);
    }

    public void clickRepositorioInstitucional() {
        click(RepositorioInstitucional);
    }

    public void ValidarRepositorioInstitucional() {
        opcion = "RepositorioInstitucional";

        if (isDisplayed(ValidarRepositorioInstitucional)) {
            status = "Pass";
            screenShoot(nombreWeb + "_" + opcion, status);


        } else {
            status = "Fail";
            screenShoot(nombreWeb + "_" + opcion, status);
        }
    }

}
