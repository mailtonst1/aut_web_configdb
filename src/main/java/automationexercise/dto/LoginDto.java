package automationexercise.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginDto {

    private String nome;
    private String email;
    private String senha;



    public LoginDto(String nome, String email,String senha ) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
}
