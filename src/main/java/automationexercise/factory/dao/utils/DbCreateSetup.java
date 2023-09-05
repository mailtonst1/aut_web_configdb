package automationexercise.factory.dao.utils;

public class DbCreateSetup {

    public DbCreateSetup(){

    }

    // CREATE TABLE
    public static final String CREATE_TABLE_USUARIO =
            "CREATE TABLE usuario (" +
                    "id serial primary key," +
                    "nome varchar(255) not null," +
                    "email varchar(255) not null," +
                    "senha varchar(255) not null" +
                    ")";

    // ALTER TABLE

    // DROP TABLE
    public static  final String DROP_TABLE_USUARIO_IF_EXISTS = "DROP TABLE usuario;";
    // CREATE SEQUENCE








}
