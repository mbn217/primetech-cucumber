package api_tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExampleDemo {

    @Test
    public void javaFakerExample(){
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().lastName());

        System.out.println(faker.cat().name());

        System.out.println(faker.address().cityName());
    }

}
