package week4.day16.lambda_study;

public class LambdaEx1 {

  public static void main(String[] args) {
    Object obj = new Object() {
      int max(int a, int b) {
        return a > b ? a : b;
      }
    };

//    int value = obj.max(3,5); //참조변수 obj의 타입인 Object에는 max란 메서드가 없기 때문에 호출할 수 없다.
    //그러면 형변환을 해줘야 하는 건데 뭘로 형변환 하겠는가? 해줄 게 없지?
    //람다를 사용하는 데 필요한 건 함수형 인터페이스
  }
}
