package day6.householdledger;

import java.util.List;

public class Main {

  static final int ADD = 1;
  static final int EDIT = 2;
  static final int DELETE = 3;
  static final int CHANGE = 4;
  static final int QUIT = 5;

  static final Prompt prompt = new Prompt();
  static final HouseHoldLedger houseHoldLedger = new HouseHoldLedger();

  static String registerSign = null;
  static User currentUser = null;
  static boolean registerSuccess = false;
  static boolean signInSuccess = false;

  public static void run() {
    //입력
    System.out.print("사용자 이름을 입력하십시오( 종료는 q/Q 입력 ) : ");
    String userName = prompt.inputUserName();

    if (userName.toUpperCase().equals("Q")) {
      System.out.println("프로그램을 종료합니다.");
      return;
    }

    //입력후 1 > 등록된 유저가 있으면 바로 로그인 -------------------------------------
    if (houseHoldLedger.checkHasUser(userName)) {
      System.out.print("비밀번호를 입력해주세요:");
      String password = prompt.inputPassword();
      signInSuccess = houseHoldLedger.signIn(userName, password);
    }

    if (signInSuccess) {

      LedgerItem item;
      User currentUser = houseHoldLedger.getCurrentUser();
      List<LedgerItem> ledgerItems = currentUser.getLedgerItems();
      int order;

      //로그인시 한 번 쫙 출력해주고
      prompt.printCurrentLedger(ledgerItems);

      boolean isTaskGoingOn = true;
      while (isTaskGoingOn) { //taskNum을 while문에서 비교해가지고 변수를 하나로 합치면 작업 계속할지말지
        //추가 작업뭐할지를 물어보는 단계를 하나로 합칠 수 있다.

        int taskNum = prompt.inputTaskSelection();

        switch (taskNum) {
          case ADD:
//            order = ledgerItems.size();
            item = prompt.inputNewItem();
            ledgerItems.add(item);
            break;
          case EDIT:
            //수정할 항목 번호를 입력받은 후, 해당 항목을 지우고 새로 만들어서 갈아끼우는 식.
            //Q. setter로 order프로퍼티를 수정하면 안되는지? 코드를 작성하다보니 setter가 절실해짐..
            order = prompt.inputItemOrder();
            item = prompt.inputNewItem();
            ledgerItems.remove(order - 1);
            ledgerItems.add(order - 1, item);
            break;
          case DELETE:
            //Q. 삭제하고 넘버링 다시 따주는 걸 반복문 돌면서 노가다로 바꿔줘야만 하나..?? 다른 방법이 없을까?
            order = prompt.inputItemOrder();
            ledgerItems.remove(order - 1);

            break;
          case CHANGE:
            houseHoldLedger.changeUser();
          case QUIT:
            return;
          default:
            break;
        }

        //작업 한번 끝날 때마다 또 출력 해주고.
        System.out.println("---------------------------------------------------------------------");
        prompt.printCurrentLedger(ledgerItems);
        System.out.println("---------------------------------------------------------------------");
        isTaskGoingOn = prompt.inputIsTaskGoingOn();
      }

      return;
    }

    //입력후 2 > 등록된 유저가 없으면 신규등록 의사를 묻는다. ----------------------------
    System.out.print("미등록된 사용자입니다. 신규 등록을 진행하시겠습니까(Y/N)?");
    registerSign = prompt.inputRegisterSign();

    if (registerSign.equals("N")) {
      System.out.println("사용자 등록을 취소하셨습니다. 로그인 단계로 돌아갑니다.");
      run();
      return;
    }

    if (registerSign.equals("Y")) {
      System.out.print("신규로 등록할 비밀번호를 입력해주세요 : ");
      String password = prompt.inputPassword();

      //비밀번호 재입력 로직 추가시 플래그 사용
      registerSuccess = houseHoldLedger.registerUser(userName, password);
      
      System.out.println("등록이 완료되었습니다. 로그인 단계로 돌아갑니다.");
      run();
    }

  }

  public static void main(String[] args) {
    run();
  }
}
