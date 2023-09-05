package automationexercise.util;

import com.github.javafaker.Faker;

public class FakerGeneretor {

    // instanciar a ferramenta Faker
    private static final Faker faker = new Faker();

    public String nomeFaker() {return  faker.name().username();}

    public String emailFaker(){
        return faker.internet().emailAddress();
    }

    public String senhaFaker(){
        return faker.internet().password();
    }





}
