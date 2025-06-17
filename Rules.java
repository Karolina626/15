import java.util.Scanner;

public class Rules {
    public static void show(Scanner scanner) {
        System.out.println("Правила: 1) Кожен гравець ходить по черзі. 2) Хрестик ходить першим. 3) Щоб виграти потрібно, щоб у гравця 3 фігури були в лінію.");
        System.out.println("Натисніть 0 щоб повернутися в меню.");
        scanner.nextInt();
    }
}