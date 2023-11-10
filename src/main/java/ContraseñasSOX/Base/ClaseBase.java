package ContraseñasSOX.Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClaseBase {

    private WebDriver driver;

    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    /* public static String url = "jdbc:sqlserver://10.145.71.157;databaseName=BD_AUTOMATIZACION_CERT;trustServerCertificate=true;";
     public static String usuario = "cert_upnsac1";
     public static String contraseña = "E71t9aMuz#";

 */
    public WebDriver ConnectionWebDriverChrome() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        return driver;
    }

    //Buscar los elementos

    public WebElement buscarElemento(By locator) {
        return driver.findElement(locator);
    }
//Buscar lista de elementos

    public List<WebElement> buscarListaElementos(By locator) {
        return driver.findElements(locator);
    }

//Obtener un WebElement

    public String getTextWebElement(WebElement element) {
        return element.getText();
    }

    //Obtener un locator

    public String getTextLocator(By locator) {
        return driver.findElement(locator).getText();
    }

//Enviar texto

    public void SendKeys(String inputText, By locator) {

        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(inputText);
    }

    //Clickear

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    //Validar si un elemento esta listo para ser utilizado

    public Boolean isDisplayed(By locator) {

        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//Recibir la URL de la pagina

    public void getUrl(String URL) {
        driver.get(URL);

    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyy_HH.mm.ss");
        Date date = new Date();
        return dateFormat.format(date);

    }

    public void screenAsShoot(String status) {

        try {
            Screenshot myFullScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
            //Definir la ubicacion donde se desea guardar
            String rutaScreenShoot = "./src/main/resources/screenShoots/";
            ImageIO.write(myFullScreen.getImage(), "PNG", new File(rutaScreenShoot + getDate() + status + ".png"));

        } catch (Exception e) {

        }

    }

    public void screenShoot(String nombreWeb, String status) {

        try {

            File myScreenShoot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //Definir la ubicacion donde se desea guardar
            String rutaScreenShoot = "./src/main/resources/screenShoots/";

            //Copia el archiv de la captura de pantalla a la ubicacion especificada

            FileUtils.copyFile(myScreenShoot, new File(rutaScreenShoot + getDate() +"_"+ nombreWeb +"_"+status+ ".jpg"));
        } catch (Exception e) {

        }
    }


}
