// 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.
// 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
// dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
//입력
// 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
// 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
//출력
// 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // BufferedReader는 객체 생성시 생성자의 입력값으로 InputStreamReader의 객체가 필요함
        // InputStream - byte / InputStreamReader - character / BufferedReader - String

        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // charAt >> String 문자열 중에서 한글자만 char 타입으로 반환함
            // 즉, 입력 받은 알파벳이 i개라면 i개의 char로 반환함
            if (ch == 'c') {
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == '=') {
                        i++;
                    }
                    else if (str.charAt(i + 1) == '-') {
                        i++;
                        // i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1을 증가하는 i++ 사용
                    }
                }
            }
            else if (ch == 'd') {
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == 'z') {
                        if (i < str.length() - 2) {
                            if (str.charAt(i + 2) == '=') {
                                i += 2;
                            }
                        }
                    }
                    else if (str.charAt(i + 1) == '-') {
                        i++;
                    }
                }
            }

            else if (str.charAt(i + 1) == '-') {
                i++;
            }

            else if (ch == 's') {
                if (i < str.length() - 1){
                    if (str.charAt(i + 1) == '=') {
                        i++;
                    }
                }
            }
            else if (ch == 'z') {
                if (i < str.length() - 1){
                    if(str.charAt(i+1) == '='){
                        i++;
                    }
                }
            }
            else if (ch == 'l') {
                if (i < str.length() - 1){
                    if (str.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            }
            else if (ch == 'n') {
                if (i < str.length() - 1){
                    if (str.charAt(i + 1) == 'j') {
                        i++;
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}