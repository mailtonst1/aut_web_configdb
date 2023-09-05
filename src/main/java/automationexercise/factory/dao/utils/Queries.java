package automationexercise.factory.dao.utils;

import automationexercise.factory.dao.utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class Queries extends DbConnection {

    public PreparedStatement createData(String quarys) throws SQLException, ClassNotFoundException {
        return DbConnection.getConnection().prepareStatement(quarys);
    }

    public static void dbCreate(String quarys, List<String>var) throws SQLException, ClassNotFoundException {
        System.out.println(var);
        int cont;
        int parametro = 1;
        int lista = 0;
        int n = var.size();

        PreparedStatement stmt = DbConnection.getConnection().prepareStatement(quarys);
        for (cont=0 ; cont < n ; cont++) {

            stmt.setString(parametro, var.get(lista));
            parametro++;
            lista++;
        }
        stmt.executeUpdate();
        stmt.close();
    }

    public ResultSet dbSelect(String quarys, List<String>var) throws SQLException, ClassNotFoundException {
        int cont;
        int parametro = 1;
        int lista = 0;
        int n = var.size();

        PreparedStatement stmt = DbConnection.getConnection().prepareStatement(quarys);
        for (cont=0 ; cont < n ; cont++) {

            stmt.setString(parametro, var.get(lista));
            parametro++;
            lista++;
        }
        return stmt.executeQuery();
    }

    public void dbDelete(String quarys, List<String>var) throws SQLException, ClassNotFoundException {
        int cont;
        int parametro = 1;
        int lista = 0;
        int n = var.size();

        PreparedStatement stmt = DbConnection.getConnection().prepareStatement(quarys);
        for (cont=0 ; cont < n ; cont++) {

            stmt.setString(parametro, var.get(lista));
            parametro++;
            lista++;
        }
        stmt.executeUpdate();
        stmt.close();
    }




}
