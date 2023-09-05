package automationexercise.factory.data;


import automationexercise.dto.LoginDto;
import automationexercise.factory.dao.utils.Queries;
import automationexercise.util.FakerGeneretor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static automationexercise.factory.dao.queries.DbMassa.*;

public class DataFactory extends Queries {

    FakerGeneretor fakerGeneretor = new FakerGeneretor();

    public LoginDto dbInserirUsuario(String nome, String email, String senha) throws SQLException, ClassNotFoundException {

        List<String> listVar1 = new ArrayList<>();
        listVar1.add(0, nome);
        listVar1.add(1, email);
        listVar1.add(2, senha);
        dbCreate(INSERT_USUARIO, listVar1);

        List<String> listVar2 = new ArrayList<>();
        listVar2.add(0, email);
        ResultSet result = dbSelect(SELECT_USUARIO, listVar2);

        if (!result.next()) return null;

        String dbNome = result.getString("nome");
        String dbEmail = result.getString("email");
        String dbSenha = result.getString("senha");

        //stmt.close();

        return new LoginDto(dbNome, dbEmail, dbSenha);

    }

    public void dbDeleteUsuarioPeloEmail(String email) throws SQLException, ClassNotFoundException {

        List<String> listVar = new ArrayList<>();
        listVar.add(0, email);
        dbDelete(DELETE_USUARIO, listVar);

    }

    /*
    public LoginDto inserirUsuario2(String nome, String email, String senha) throws SQLException, ClassNotFoundException {
        PreparedStatement usu = createData(INSERT_USUARIO);
        usu.setString(1, nome);
        usu.setString(2, email);
        usu.setString(3, senha);
        usu.executeUpdate();
        usu.close();
        PreparedStatement ler = createData(SELECT_USUARIO_CREATED);
        ler.setString(1, email);
        ResultSet res = ler.executeQuery();
        if(!res.next()) return null;
        String dbNome = res.getString("nome");
        String dbEmail = res.getString("email");
        String dbSenha = res.getString("senha");
        return new LoginDto(dbNome, dbEmail, dbSenha);
    }
    */

}
