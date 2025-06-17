import java.util.Scanner;

public class Game {
    private final int size;
    private final Scanner scanner;

    public Game(int size, Scanner scanner) {
        this.size = size;
        this.scanner = scanner;
    }

    public void start() {
        Board board = new Board(size);
        char currentPlayer = 'X';
        System.out.println("Починаємо гру. Розмір поля: " + size + "x" + size);

        while (true) {
            board.print();

            int row = getCoordinate("рядка") - 1;
            int col = getCoordinate("стовпця") - 1;

            if (!board.placeMark(row, col, currentPlayer)) {
                System.out.println("Ця клітинка вже зайнята. Спробуйте іншу.");
                continue;
            }

            if (board.checkWin(currentPlayer)) {
                board.print();
                System.out.println("Вітаю! Гравець " + currentPlayer + " виграв!");
                break;
            }

            if (board.isFull()) {
                board.print();
                System.out.println("Нічия! Повертайтесь на головне меню.");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private int getCoordinate(String name) {
        int value;
        while (true) {
            System.out.print("Гравець, введіть номер " + name + " (1-" + size + "): ");
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= 1 && value <= size) return value;
            } else {
                scanner.next();
            }
            System.out.println("Невірне значення. Спробуйте ще.");
        }
    }
}