package week4.day16.gui;

import java.awt.*;

public class FileDialogTest {

  public static void main(String[] args) {
    Frame f = new Frame();
    int frameWidth = 300;
    int frameHeight = 200;
    f.setSize(frameWidth, frameHeight);
    f.setLayout(null);

    FileDialog fileOpen = new FileDialog(f, "파일열기", FileDialog.LOAD);

    f.setVisible(true);
    fileOpen.setDirectory("/Users/jaehongchoe");
    fileOpen.setVisible(true);

    //파일 다이얼로그에서 파일을 선택하면 콘솔창에 선택한 파일의 경로 + 파일명이 찍힌다.
    System.out.println(fileOpen.getDirectory() + fileOpen.getFile());
  }
}
