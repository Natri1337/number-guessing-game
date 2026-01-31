import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner s = new Scanner(System.in);
        int count = 0;
        int randomNum = random.nextInt(101);
        int[] history = new int[50];

        System.out.println("""
                    Привет, это игра \"Угадай число\"
                      Я загадываю число от 0 до 100, а твоя задача угадать это число
                      за ограниченное количество попыток
                    Начнём!
                    """);

        while(true) {
            System.out.print("Введите ваше число: ");
            int number = s.nextInt();
            count++;
            for(int i = 0; i < history.length; i++) {
                if (history[i] == 0) {
                    history[i] = number;
                    break;
                }
            }

            if (number == randomNum) {
                System.out.printf("""
                        \nВы угадали загаданное число!
                        Количество попыток: %d
                        
                        Хотите посмотреть ваши попытки?
                            '1' - да
                            '2' - нет
                        :""", count);
                int historyBool = s.nextInt();
                if (historyBool == 1) {
                    for (int i : history) {
                        if (i != 0) {
                            System.out.print(i + " ");
                        }
                    }
                    break;
                } else if (historyBool == 2) {
                    System.out.println("До свидания!");
                    break;
                } else {
                    System.out.println("Вы ввели некорректное число!");
                }
                break;
            } else if (number < 0 || number > 100){
                System.out.println("Вы ввели некорректное число!");
                continue;
            } else if (number < randomNum) {
                System.out.println("Загаданное число больше!");
                continue;
            } else {
                System.out.println("Загаданное число меньше!");
                continue;
            }
        }
    }
}
