import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Settings settings = new Settings();

        while (true) {
            System.out.println("\nМеню");
            System.out.println("1. Почати гру");
            System.out.println("2. Налаштування");
            System.out.println("3. Правила");
            System.out.println("4. Вихід");
            System.out.print("Пункт меню: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Оберіть ціле число");
                scanner.next();
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    Game game = new Game(settings.getFieldSize(), scanner);
                    game.start();
                }
                case 2 -> settings.configure(scanner);
                case 3 -> Rules.show(scanner);
                case 4 -> {
                    System.out.println("Вихід.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Зробіть вибір цифрою)");
            }
        }
    }
}