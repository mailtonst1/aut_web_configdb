package automationexercise.factory.dao.utils;

import java.sql.Connection;
import java.sql.SQLException;

import static automationexercise.factory.dao.utils.DbCreateSetup.*;

public class Setup {


    private static void removerEstuturas() throws ClassNotFoundException, SQLException{
        Connection conn = DbConnection.getConnection();
        conn.createStatement().executeUpdate(DROP_TABLE_USUARIO_IF_EXISTS);
        DbConnection.closeConnection();

    }

    private static void criarEstuturas() throws ClassNotFoundException, SQLException{
        Connection conn = DbConnection.getConnection();
        conn.createStatement().executeUpdate(CREATE_TABLE_USUARIO);
        DbConnection.closeConnection();
    }

    public static void setupDb() throws ClassNotFoundException, SQLException {
        removerEstuturas();
        criarEstuturas();
        System.out.println("Ambiente criado!");
    }

    public static void main(String[] args) throws Exception {
        Setup.setupDb();
    }
}
