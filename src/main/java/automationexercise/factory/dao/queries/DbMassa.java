package automationexercise.factory.dao.queries;

public class DbMassa {

    public DbMassa() {

    }

    public static final String INSERT_USUARIO = "insert into usuario (nome, email, senha) VALUES (?,?,?)";

    public static final String SELECT_USUARIO = "select * from usuario u where u.email=?";

    public static final String DELETE_USUARIO = "delete from usuario u where u.email=?";

}
