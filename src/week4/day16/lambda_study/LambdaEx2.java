package week4.day16.lambda_study;

import java.util.Comparator;
import java.util.function.Predicate;

public class LambdaEx2 {

  public static void main(String[] args) {
//    MyFunction2 f = new MyFunction2() {
//      @Override
//      public int max(int a, int b) {
//        return a > b ? a : b;
//      }
//    };
    //람다식(익명 객쳬)을 다루기 위한 참조변수의 타입은 함수형 인터페이스이다.
    //그리고 사용할 람다식은 함수형 인터페이스에 선언된 추상 메서드와 일치해야 한다(매개변수 개수, 매개변수 타입,
    // 리턴타입이 있다면 리턴타입도). 둘이 다르면 해당 함수형 인터페이스로 참조할 수 없음.
    MyFunction2 f = (a, b) -> a > b ? a : b; //람다식애선 이름을 없애줬지만 람다식은 메서드니까 우리가 사용하려면
    int value = f.max(3,5); //이렇게 이름이(여기선 max) 필요하다. 그걸 함수형 인터페이스가 지어주는 거고.
    System.out.println(value);
  }
}

@FunctionalInterface //함수형 인터페이스는 단 하나의 추성 메서드만 가져야 함.
interface MyFunction2 {
  int max(int a, int b);
}
