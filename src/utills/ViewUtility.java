package utills;

import java.util.Scanner;

/**
 * 
 * @Description 项目中提供了TSUtility.java类，可用来方便地实现键盘访问。
 * @author shkstart 林敬舒(补充readString) Email:shkstart@126.com
 * @version 
 * @date 2019年2月12日上午12:02:58
 *
 */
public class ViewUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 
     * @Description 该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     * @author shkstart
     * @date 2019年2月12日上午12:03:30
     * @return
     */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            //判断字符是否为数字(by linjingshu)
            if (!Character.isDigit(c)) {
                System.out.print("选择错误，请重新输入：");
            } else {
                break;
            }
        }
        return c;
    }
	/**
	 * 
	 * @Description 该方法提示并等待，直到用户按回车键后返回。
	 * @author shkstart
	 * @date 2019年2月12日上午12:03:50
	 */
    public static void readReturn() {
        System.out.print("按回车键继续...");
        readKeyBoard(100, true);
    }
    /**
     * 
     * @Description 该方法从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * @author shkstart
     * @date 2019年2月12日上午12:04:04
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     * 
     * @Description 从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     * @author shkstart
     * @date 2019年2月12日上午12:04:45
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    public static char readSelectionByAdminType() {
        char c;
        for (;;){
            String str = readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if (c == 'U' || c == 'I'){
                break;
            }else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 从键盘中读取字符串
     * @return
     */
    public static String readString(){
        String s;
        s = readKeyBoard(20,false);
        return s;
    }

    public static double readDouble(){
        String s;
        double d;
        for (;;) {
            s = readKeyBoard(20, false);
            //判断字符串是否为数字
            try {
                d = Double.parseDouble(s);
                return d;
            } catch (NumberFormatException e) {
                System.out.println("字符串格式不正确");
            }
        }
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) {
                    return line;
                } else {
                    continue;
                }
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
}

