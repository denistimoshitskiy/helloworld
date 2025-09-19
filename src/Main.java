import  java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    private static final Random random = new Random(); // Создание объекта Random для генерации случайного числа для выбора слова в игре
    public static String createSecretWord(String word) {
        return "*".repeat(word.length());
    }
    public static void main(String[] args) {
        String [] listWords = {"лошадь", "напиток"}; // Список слов
        int randomIndex = random.nextInt(listWords.length); // Генерация случайного числа
        String selectedWord = listWords[randomIndex]; // Выбор случайного слова из массива
        String[] selectedWordArray = new String[selectedWord.length()];

        // Инициализируем массив звездочками
        for (int i = 0; i < selectedWordArray.length; i++) {
            selectedWordArray[i] = "*";
        }

        Scanner scanner = new Scanner(System.in); // Создаем объект scanner для возможности считывания ответа из консоли
        System.out.println("Вы хотите начать новую игру? Y/N"); // Спрашиваем пользователя о желании начать новую игру
        String answer = scanner.nextLine(); // Запускаем считываем того, что пользователь ввел из консоли
        String answerWord = "";
        int attempt = 0;
        int errors = 0;
        if (answer.equals("y")) { // Если пользователь ввел y, то игра начинается
            while(selectedWord != answerWord) {
                attempt++;
                if(attempt == 1){
                    System.out.println("Я загадал слово " + createSecretWord(selectedWord));
                }
                if (errors < 5) {
                    System.out.println("Введи букву, которая может быть в слове");
                    String letter = scanner.nextLine();
                    if (selectedWord.contains(letter)) {
                        for (int i = 0; i < selectedWordArray.length; i++) {
                            if (selectedWordArray[i].equals(letter)) {
                                selectedWordArray[i] = letter;
                            }
                        }
                        String newStatusSelectedWord = String.join("", selectedWordArray);
                        System.out.println("Пока угадано " + newStatusSelectedWord);
                        if (newStatusSelectedWord.equals(selectedWord)) {
                            System.out.println("Поздравляю слово отгадано!");
                            break;
                        }
                    } else {
                        errors++;
                        System.out.println("Ошибок " + errors);
                    }
                }
                else {
                    System.out.println("Вы проиграли");
                    break;
                }

            }
        } else if (answer.equals("n")) {
            System.out.println("Вы вышли");
        }
    }
}