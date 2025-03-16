import java.util.Random;

public class RandomDataGenerator {

    public static void main(String[] args) {
        Random random = new Random();

        // Generate a random integer
        int randomInt = random.nextInt();
        System.out.println("Random Integer: " + randomInt);

        // Generate a random integer within a specific range (0 to 99)
        int randomIntInRange = random.nextInt(100);
        System.out.println("Random Integer (0-99): " + randomIntInRange);

        // Generate a random double
        double randomDouble = random.nextDouble();
        System.out.println("Random Double: " + randomDouble);

        // Generate a random boolean
        boolean randomBoolean = random.nextBoolean();
        System.out.println("Random Boolean: " + randomBoolean);

        // Generate a random long
        long randomLong = random.nextLong();
        System.out.println("Random Long: " + randomLong);

        // Generate a random float
        float randomFloat = random.nextFloat();
        System.out.println("Random Float: " + randomFloat);

        //Generate a random number from a gaussian distribution
        double gaussian = random.nextGaussian();
        System.out.println("Random Gaussian: " + gaussian);
    }
};

