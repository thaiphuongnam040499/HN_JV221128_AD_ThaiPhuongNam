package Bai2;
import java.util.Scanner;
import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String sentence = "";
        do {
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.println("Nhập lựa chọn của bạn:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập câu của bạn:");
                    sentence = scanner.nextLine();
                    break;
                case 2:
                    reverseSentence(sentence);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        } while (choice != 3);
    }

    public static void reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < words.length; i++) {
            stack.push(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            words[i] = stack.pop();
        }
        String temp = "";
        for (int i = 0; i < words.length; i++) {
            temp += " " + words[i];
        }
        System.out.println(temp);
    }
}
