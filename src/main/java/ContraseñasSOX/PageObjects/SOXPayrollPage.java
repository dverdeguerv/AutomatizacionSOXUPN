package ContraseñasSOX.PageObjects;

import ContraseñasSOX.Base.ClaseBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SOXPayrollPage extends ClaseBase {

    public SOXPayrollPage(WebDriver driver) {
        super(driver);
    }

    //String grupo="Administrativos intranet";
    String nombreWeb="Payroll";
    String userLoginText = "47113504-1";
    String PassLoginText = "{LD%>6aA";


    //Localizadores de la Pagina

    By LoginUser = By.id("userid");
    By LoginPass = By.id("pwd");
    By LoginButton = By.className("ps-button");
    By PageIsDisplayed=By.id("win0div$ICField27");

    /*public String RetornarContraseñaLogin(String grupo, String nombreWeb) {
        String user = null; // Declaración inicial de la variable user

        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = connection.createStatement();

            String consulta = "select usuario from webs_Contraseñas_SOX where grupo='Administrativos intranet' and nombreWeb='Payroll'";
            ResultSet resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                // Aquí obtienes los datos de cada fila de la tabla y los almacenas en la variable user
                user = resultSet.getString("pass");
            }

            // Cierra los recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user; // Devuelve el resultado de la consulta
    }
*/
    public void credencialesPayroll() {
        SendKeys(userLoginText, LoginUser);
        SendKeys(PassLoginText, LoginPass);

    }

    public void clickPayroll() {
        click(LoginButton);
    }


    public void ValidarMainPayrroll() {
        if (isDisplayed(PageIsDisplayed)){
            String Status="Pass";
            screenShoot(Status,nombreWeb);
        }else {
            String Status="Fail";
            screenShoot(Status,nombreWeb);
        }
    }
}
