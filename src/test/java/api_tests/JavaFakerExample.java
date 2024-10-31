package api_tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExample {

    @Test
    public void fakerTest() {
        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().nameWithMiddle());

        System.out.println(faker.cat().name());

        System.out.println(faker.address().streetAddress());
        System.out.println(faker.address().fullAddress());

        System.out.println(faker.commerce().productName());
        System.out.println(faker.commerce().price());
        System.out.println(faker.commerce().material());
    }
}
