import com.github.javafaker.Faker;

// ... (producer setup)

Faker faker = new Faker();

for (long i = 0; i < 10; i++) {
    String key = "user-" + i;
    String value = String.format("{\"name\": \"%s\", \"address\": \"%s\", \"email\": \"%s\"}",
            faker.name().fullName(),
            faker.address().fullAddress(),
            faker.internet().emailAddress());
            // producer.send(new ProducerRecord<>("users", key, value));
            println(value);
            
            }



// String a=1;
// println(a)



