import java.util.Scanner;

public class Settings {
    private int fieldSize = 3;

    public int getFieldSize() {
        return fieldSize;
    }

    public void configure(Scanner scanner) {
        while (true) {
            System.out.println("Налаштування");
            System.out.println("1. Вибір розміру поля");
            System.out.println("0. Повернутися до меню");
            System.out.print("Оберіть пункт: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Зробіть вибір цифрою)");
                scanner.next();
            }
            int choice = scanner.nextInt();

            if (choice == 0) break;
            if (choice == 1) {
                System.out.println("Оберіть розмір поля: 1) 3x3  2) 5x5  3) 7x7  4) 9x9");
                while (!scanner.hasNextInt()) {
                    System.out.println("Зробіть вибір цифрою)");
                    scanner.next();
                }
                switch (scanner.nextInt()) {
                    case 1 -> fieldSize = 3;
                    case 2 -> fieldSize = 5;
                    case 3 -> fieldSize = 7;
                    case 4 -> fieldSize = 9;
                    default -> {
                        System.out.println("Здається такої розмітки немає");
                        fieldSize = 3;
                    }
                }
            }
        }
    }
}