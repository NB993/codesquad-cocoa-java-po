package week4.day16.lambda_study;

import java.util.function.Function;

public class MethodReferenceEx {

  public static void main(String[] args) {
    // 3. 원래 람다식은 (s) -> new MyClass(s) 인데,
    // Function<String, MyClass>를 통해 매개변수의 타입과 리턴타입을 알 수 있으니 생략하고,
    // '클래스명::메서드명' 으로 변경해줄 수 있다. 이게 메서드 참조를 사용하는 방식.
    MyClass myClass = makeMyClass(MyClass::new);
    System.out.println("name is: " + myClass.getName());

  }


  // 1. makeMyClass란 메서드에 매개변수로 Function인터페이스 타입의 람다식을 선언해줬다.
  // 이 람다식은 String타입 매개변수를 받고, MyClass타입의 리턴타입을 가지고 있다.
  private static MyClass makeMyClass(Function<String, MyClass> lambda) {
    // 2. 람다식에 "method reference"를 인자로 전달한다.
    String name = "method reference";
    return lambda.apply(name);
  }
}


