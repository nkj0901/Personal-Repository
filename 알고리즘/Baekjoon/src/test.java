import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class test {
    static class Person {
        String name;
        int age;
        static int st = 20;

        public int test(){
            return st++;
        }

        public void eat() {
            System.out.println("음식을 먹는다.");
        }
    }

    static class Student extends Person {
        String major;

        public void study() {
            System.out.println("공부를 한다.");
        }
        public void eat() {
            System.out.println("음식11을 먹는다.");
        }
    }
    public static void main(String[] args) {
        String[] strArray = { "10" , "2a" };
        int value = 0;
        for(int i = 0; i <= 2; i++ ){
            try{
                value = Integer.parseInt(strArray[i]);
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("인덱스를 초과했음");
            } catch(NumberFormatException e) {
                System.out.println("숫자로 변환할 수 없음");
            } finally {
                System.out.println(value);
            }
            int a = 1;
            int b = 2;

            System.out.println(a*b-- + b--*2);
        }
    }
}
