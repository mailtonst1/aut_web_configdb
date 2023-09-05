package automationexercise.test;

import automationexercise.dto.LoginDto;
import automationexercise.factory.data.DataFactory;
import automationexercise.factory.data.DataGeneretor;
import automationexercise.factory.selenium.Validation;
import automationexercise.page.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static storys.LoginStory.*;

@Epic(EPIC)
@Story(USER_STORY_LOGIN)
public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    DataGeneretor dataGeneretor = new DataGeneretor();
    DataFactory dataFactory = new DataFactory();
    Validation validation = new Validation();


    @Test
    @Description(CE_LOGIN_01)
    public void test1validarLoginDadosValidos_teste2() throws SQLException, ClassNotFoundException {
        LoginDto usu =  dataGeneretor.loginDadosValidos();
        LoginDto dbUsu = dataFactory.dbInserirUsuario(usu.getNome(),usu.getEmail(),usu.getSenha());
        loginPage.preencherCampoEmail(dbUsu.getEmail());
        loginPage.preencherCampoSenha(dbUsu.getSenha());
        loginPage.clicarBtnAcessar();
        String msgm = loginPage.validarTextoBtnAposLogin();
        validation.validateText(msgm,"Logout");
        dataFactory.dbDeleteUsuarioPeloEmail(dbUsu.getEmail());
    }

/*
    @Test
    @Description(CE_LOGIN_01)
    public void test1validarLoginDadosValidos() throws SQLException, ClassNotFoundException {
        LoginDto usu =  dataGeneretor.loginDadosValidos();
        LoginDto dbUsu = dataFactory.inserirUsuario2(usu.getNome(),usu.getEmail(),usu.getSenha());
        loginPage.preencherCampoEmail(dbUsu.getEmail());
        loginPage.preencherCampoSenha(dbUsu.getSenha());
        loginPage.clicarBtnAcessar();
        String msgm = loginPage.validarTextoBtnAposLogin();
        validation.validateText(msgm,"Logout");
    }

    @Test
    @Description(CE_LOGIN_02).
    public void test2validarLoginDadosInvalidos(){
        LoginDto usu =  loginData.LoginDadoDinamicos();
        loginPage.preencherCampoEmail(usu.getEmail());
        loginPage.preencherCampoSenha(usu.getSenha());
        loginPage.clicarBtnAcessar();
        String msgm = loginPage.validarMsgmEmailIncorreto();
        validation.validateText(msgm,"Your email or passwod is incorrect!");

    }

    @Test
    @Description(CE_LOGIN_03)
    public void test3validarLoginComDadosValidos(){
        LoginDto usu =  loginData.loginDadosValidos();
        String msgm = loginPage.fazerLogin(usu.getEmail(),usu.getSenha());
        validation.validateText(msgm,"Logout");
    }

    @Test
    @Description(CE_LOGIN_04)
    public void test4validarLoginDadosInvalidos(){
        LoginDto usu =  loginData.LoginDadoDinamicos();
        String msgm = loginPage.loginEmailIncorreto(usu.getEmail(), usu.getSenha());
        validation.validateText(msgm,"Your email or password is incorrect!");
    }
*/

}
