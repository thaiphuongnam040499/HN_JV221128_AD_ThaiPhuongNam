package Bai3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ParentsSubmitApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        int choice;
        do {
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            System.out.println("Nhập lựa chọn của bạn:");
            choice = Integer.parseInt(scanner.nextLine()) ;
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên phụ huynh nộp hồ sơ");
                    String parentsName = scanner.nextLine();
                    queue.add(parentsName);
                    System.out.println("Thành công");
                    break;
                case 2:
                    if (!queue.isEmpty()){
                        System.out.println("Phụ huynh tiếp theo");
                        System.out.println(queue.poll());
                        break;
                    }else {
                        System.out.println("không còn phụ huynh nào nữa");
                    }

                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Không có lựa chọn của bạn");
                    break;
            }
        }while (choice!=3);
    }
}
