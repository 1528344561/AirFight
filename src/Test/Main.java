package Test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        huiwenriqi(data);
        ABhuiwenriqi(data);
        sc.close();
    }

    public static void huiwenriqi(int n) {
        for (int i = n + 1; i <=99999999; i++) {
            String str = i + "";
            char[] ch = str.toCharArray();
            char a = ch[0], b = ch[1], c = ch[2], d = ch[3], e = ch[4], f = ch[5], g = ch[6], h = ch[7];
            if ((e - '0') * 10 + (f - '0') > 12 || (e - '0') + (f - '0') == 0 || (g - '0') * 10 + (h - '0') > 31) {
                continue;
            }
            //判断闰年
            int run = (a - '0') * 1000 + (b - '0') * 100 + (c - '0') * 10 + (d - '0');
            if (run % 4 == 0 || run % 400 == 0) {
                if ((e - '0') + (f - '0') == 2 && (g - '0') * 10 + (h - '0') > 29) {
                    continue;
                }
            }
            if (a == h && b == g && c == f && d == e) {
                System.out.println(ch);
                break;
            }

        }
    }

    public static void ABhuiwenriqi(int n) {
        for (int i = n + 1; i <=99999999; i++) {
            String str = i + "";
            char[] ch = str.toCharArray();
            char a = ch[0], b = ch[1], c = ch[2], d = ch[3], e = ch[4], f = ch[5], g = ch[6], h = ch[7];
            if ((e - '0') * 10 + (f - '0') > 12 || (e - '0') + (f - '0') == 0 || (g - '0') * 10 + (h - '0') > 31) {
                continue;
            }
            //判断闰年
            int run = (a - '0') * 1000 + (b - '0') * 100 + (c - '0') * 10 + (d - '0');
            if (run % 4 == 0 || run % 400 == 0) {
                if ((e - '0') + (f - '0') == 2 && (g - '0') * 10 + (h - '0') > 29) {
                    continue;
                }
            }
            if (a == c && c == f && f == h && b == d && d == e && e == g) {
                System.out.println(ch);
                break;
            }
        }
    }
}
