package week4.day16.gui;

import java.awt.*;

public class ListTest {

  public static void main(String[] args) {
    Frame f = new Frame();
    int frameWidth = 300;
    int frameHeight = 200;
    f.setSize(frameWidth, frameHeight);
    f.setLayout(null);

    List selectOne = new List(8);// 보여줄 리스트의 개수
    selectOne.setLocation(20,40);
    selectOne.setSize(100,50);
    selectOne.add("학생");
    selectOne.add("선생님");
    selectOne.add("프로그래머");
    selectOne.add("음악가"); //보여줄 개수보다 적은 항목이 입력되어도 빈 칸이 생기진 않음. 빈칸은 총 항목의 사이즈를 넘어서는
    //height가 설정되었을 때만 생김

    List selectMany = new List(6, true); // 두 번째 인자는 다중 선택 가능여부.
    selectMany.setLocation(150, 40);
    selectMany.setSize(100, 120);
    selectMany.add("학생");
    selectMany.add("선생님");
    selectMany.add("프로그래머");
    selectMany.add("음악가");
    selectMany.add("감독");
    selectMany.add("영업직");
    selectMany.add("사무직");

    f.add(selectOne);
    f.add(selectMany);
    f.setVisible(true);
  }

}
