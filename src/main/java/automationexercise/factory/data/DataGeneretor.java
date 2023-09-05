package automationexercise.factory.data;


import automationexercise.dto.LoginDto;
import automationexercise.util.FakerGeneretor;

public class DataGeneretor {

    // instanciar a ferramenta Faker
    FakerGeneretor fakerGeneretor = new FakerGeneretor();

    // Gerar dados fakes e guardar no DTO correspondente
    public LoginDto loginDadosValidos(){
        // Instanciar = conexão com LoginDto
        return new LoginDto(
                "Mailton Nascimento",
                "vs@gmail.com",
                "123456"
        );
    }

    // Gerar dados fakes e guardar no DTO correspondente
    public LoginDto LoginDadoDinamicos(){
        // Instanciar = conexão com LoginDto
        return new LoginDto(
                fakerGeneretor.nomeFaker(),
                fakerGeneretor.emailFaker(),
                fakerGeneretor.senhaFaker()
        );
    }







}
