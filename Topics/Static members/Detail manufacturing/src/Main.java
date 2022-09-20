import java.util.Scanner;

class ManufacturingController {
    // here you may declare a field
    static int count;

    ManufacturingController(){
        count = 0;
    }

    public static String requestProduct(String product) {
        count++;

        return count + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}