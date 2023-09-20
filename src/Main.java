import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //first_task();
        //second_task();
        //third_task();
        //forth_task();
        //fifth_task();
        //sixth_task();
        seventh_task();
    }

    public static String[] entered_strings(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int n = sc.nextInt();//кол-во строк
        String[] scanned_strings = new String[n];
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            System.out.println("Введите строку " + (i+1));
            scanned_strings[i] = sc2.nextLine();
        }
        return scanned_strings;
    }

    public static String text_for_work(){
        System.out.println("Введите текст: ");
        Scanner sc1 = new Scanner(System.in);
        String text = sc1.nextLine();
        return text;
    }
    public static void first_task(){
        //Ввести n строк с консоли, найти самую короткую строку. Вывести эту строку и ее длину.
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество строк: ");
        int n = sc.nextInt();//кол-во строк
        String[] scanned_strings = new String[n];
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < n; i++){
            System.out.println("Введите строку " + (i+1));
            scanned_strings[i] = sc2.nextLine();
        }
        int min_length = Integer.MAX_VALUE;
        String str_out = null;
        for (int i = 0; i < n; i++){
            if (scanned_strings[i].length() < min_length) {
                min_length = scanned_strings[i].length();
                str_out = scanned_strings[i];
            }
        }
        if (str_out != null) {
            System.out.println("Самая короткая строка: " + str_out + " Количество символов: " + min_length);
        } else {
            System.out.println("Не было введено ни одной строки.");
        }
    }

    public static void second_task(){
        //Ввести n строк с консоли. Упорядочить и вывести строки в
        // порядке возрастания их длин, а также (второй приоритет) значений этих их длин.
        String[] entered_list = entered_strings();

        Arrays.sort(entered_list, Comparator.comparingInt(String::length));

        System.out.println("Отсортированные строки:");
        for (int i = 0; i < entered_list.length; i++) {
            String str = entered_list[i];
            System.out.println(str + " (длина: " + str.length() + ")");
        }
    }

    public static void third_task(){
        //Ввести n строк с консоли. Вывести на консоль те строки, длина которых меньше средней, также их длины.
        String[] entered_list_third = entered_strings();

        int total_length = 0;
        for (int i = 0; i < entered_list_third.length; i++){
            String str2 = entered_list_third[i];
            total_length += str2.length();
        }
        double averageLength = (double) total_length / entered_list_third.length;

        System.out.println("Строки, длина которых меньше средней:");
        for (int i = 0; i < entered_list_third.length; i++) {
            String str = entered_list_third[i];
            if (str.length() < averageLength) {
                System.out.println(str + " (длина: " + str.length() + ")");
            }
        }
    }

    public static void forth_task(){
        //В каждом слове текста k-ю букву заменить заданным символом. Если k больше длины слова,
        // корректировку не выполнять.

        String text = text_for_work();

        System.out.println("Введите позицию k: ");
        Scanner sc2 = new Scanner(System.in);
        int k = sc2.nextInt();

        System.out.println("Введите символ для замены: ");
        Scanner sc3 = new Scanner(System.in);
        char symbol = sc3.next().charAt(0);

        String[] words = text.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (k <= words[i].length()) {
                char[] letters = words[i].toCharArray();
                letters[k - 1] = symbol;
                words[i] = String.valueOf(letters);
            }
        }

        String result = String.join(" ", words);
        System.out.println(result);

    }

    public static void fifth_task(){
        //В русском тексте каждую букву заменить ее номером в алфавите. В одной строке печатать текст
        // с двумя пробелами между буквами, в следующей строке внизу под каждой буквой печатать ее номер.
        String text = text_for_work();
        StringBuffer modifiedText = new StringBuffer();
        StringBuffer numbers = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                int number = Character.toLowerCase(c) - 'а' + 1;
                modifiedText.append(c).append("  ");
                numbers.append(number).append(" ");
            } else {
                modifiedText.append(c).append("   ");
                numbers.append("  ");
            }

        }
        String changed_text = modifiedText.toString() + "\n" + numbers.toString();
        System.out.println(changed_text);

    }

    public static void sixth_task(){
        //Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами.
        // Между последовательностями подряд идущих букв оставить хотя бы один пробел.
        String text = text_for_work();
        StringBuffer cleaned_text = new StringBuffer();
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (Character.isLetter(c)|| c == ' '){
                if (Character.isLetter(c)){
                    if (i > 0 && !Character.isLetter(text.charAt(i - 1)));
                    cleaned_text.append(' ');
                }
                cleaned_text.append(c);
            }
        }
        System.out.println(cleaned_text.toString());


    }

    public static void seventh_task(){
        //Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
        String text = text_for_work();
        String[] words = text.split(" ");

        System.out.println("Введите длину слова: ");
        Scanner sc2 = new Scanner(System.in);
        int l = sc2.nextInt();

        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        StringBuffer result = new StringBuffer();

        for (String word : words){
            if (word.length() != l || isVowel(word.charAt(0), vowels)) {
                result.append(word).append(" ");
            }
        }

        System.out.println("Результат: " + result.toString());

    }
    public static boolean isVowel(char c, char[] vowels) {
        for (int i = 0; i < vowels.length; i++) {
            char vowel = vowels[i];
            if (Character.toLowerCase(c) == vowel) {
                return true;
            }
        }
        return false;
    }



}