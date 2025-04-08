import java.util.Scanner;

public class P3a_ceaser {

    static String encrypt(String txt, int key) {
        return transform(txt, key);
    }

    static String decrypt(String txt, int key) {
        return transform(txt, -key);
    }

    static String transform(String txt, int key) {
        StringBuilder res = new StringBuilder();
        txt.chars().forEach(c -> 
            res.append(Character.isAlphabetic(c) 
                        ? (char) ((c - 'a' + key + 26) % 26 + 'a') 
                        : (char) c)
        );
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine().toLowerCase();

        int key = sc.nextInt();
        key %= 26; 
        var enc = encrypt(txt, key);
        var dec = decrypt(enc, key);
        System.out.println(enc + "\n" + dec);
        sc.close();
    }
}
