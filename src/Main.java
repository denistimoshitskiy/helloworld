import  java.util.Scanner;
import java.util.Random;

public class Main {
    private static final Random random = new Random(); // Создание объекта Random для генерации случайного числа для выбора слова в игре
    public static String createSecretWord(String[] selectedWordArray) { // Создание маски слова, количество звездочек равно количеству букв в загаданном слове
        return "*".repeat(selectedWordArray.length);
    }
    public static void main(String[] args) {
        String [] listWords = {"лошадь", "напиток"}; // Список слов
        Scanner scanner = new Scanner(System.in); // Создаем объект scanner для возможности считывания ответа из консоли
        System.out.println("Вы хотите начать новую игру? Y/N"); // Спрашиваем пользователя о желании начать новую игру
        String answer = scanner.nextLine(); // Запускаем считываем того, что пользователь ввел из консоли
        int randomIndex = random.nextInt(listWords.length); // Генерация случайного числа
        String selectedWord = listWords[randomIndex]; // Выбор случайного слова из массива
        String selectedWordArray[] = selectedWord.split(""); // Разделение строки загаданного слова на элементы массива
        if (answer.equals("y")) { // Если пользователь ответил Y - игра стартует
            System.out.println("Игра начинается");
            System.out.println("Я загадал слово " + createSecretWord(selectedWordArray));
            System.out.println("Введи букву, которая может быть в слове");
            String firstLetter = scanner.nextLine();
            if (selectedWord.contains(firstLetter)) { // Первая попытка
                for (int i = 0; i < selectedWordArray.length; i++) {
                    if (selectedWordArray[i].equals(firstLetter)){
                        selectedWordArray[i] = firstLetter;
                    } else {
                        selectedWordArray[i] = "*";
                    }
                }
                String selectedWordAfterFirstChance = String.join("", selectedWordArray);
                String selectedWordAfterFirstChanceArray[] = selectedWordAfterFirstChance.split("");
                System.out.println("Такая буква есть! Открыта часть слова " + selectedWordAfterFirstChance);
                System.out.println("Введи следующую букву букву, которая может быть в слове");
                String secondLetter = scanner.nextLine();
                if (selectedWord.contains(secondLetter)) { // Вторая попытка
                    for (int i = 0; i < selectedWordAfterFirstChanceArray.length; i++) {
                        if (selectedWordAfterFirstChanceArray[i].equals(secondLetter)){
                            selectedWordAfterFirstChanceArray[i] = secondLetter;
                        } else {
                            selectedWordAfterFirstChanceArray[i] = "*";
                        }
                    }
                    String secondChance = String.join("", selectedWordAfterFirstChanceArray);
                    System.out.println("Такая буква есть! Открыта часть слова " + secondChance);
                } else {
                    System.out.println("Такой буквы нет! Повесим голову и туловище :)");
                }
            } else {
                System.out.println("Такой буквы нет! Повесим голову :)");
            }
        } else if (answer.equals("n")) {
            System.out.println("Вы вышли");
        }
    }
}