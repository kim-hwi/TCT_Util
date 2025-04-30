import java.util.Scanner;

public class ConsoleUtil {
    private static final Scanner scanner = new Scanner(System.in);

    // 문자열 입력
    public static String readLine() {
        return scanner.nextLine();
    }

    // 정수 입력
    public static int readInt(String prompt) {
        while (!scanner.hasNextInt()) {
            scanner.next(); //
        }
        return scanner.nextInt();
    }

    // 실수 입력
    public static double readDouble(String prompt) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static void printLine(String prompt) {
        System.out.println(prompt);
    }

    // 종료 시 호출
    public static void close() {
        scanner.close();
    }
}
