package day6.householdledger;

public class Main {

  public static void run() {
    final int ADD = 1;
    final int EDIT = 2;
    final int DELETE = 3;

    Prompt prompt = new Prompt();
    HouseHoldLedger houseHoldLedger = new HouseHoldLedger();
    String registerSign = null;
    String currentUser = null;
    boolean registerSuccess = false;

    //입력
    System.out.print("사용자 이름을 입력하십시오( 종료는 q/Q 입력 ) : ");
    String userName = prompt.inputUserName();

    //입력후 1 > 등록된 유저가 있으면 바로 로그인 -------------------------------------
    if (houseHoldLedger.checkHasUser(userName)) {
      System.out.print("비밀번호를 입력해주세요:");
      String password = prompt.inputPassword();
      houseHoldLedger.signIn(userName, password);
      currentUser = userName;

      //가계부 입력부분
      boolean isTaskGoinOn = true;
      while (isTaskGoinOn) {
        int taskNum = prompt.inputTaskSelection();
        prompt.printCurrentLedger();

        if (taskNum == ADD) {

          prompt.inputAdd();
        }
        if (taskNum == EDIT) {
          int order = prompt.inputItemOrder();
          LedgerItem item = prompt.inputNewItem();
          houseHoldLedger.edit(order, item);
        }
        if (taskNum == DELETE) {
          prompt.inputDelete();
        }
        houseHoldLedger.doTask(taskNum);

        isTaskGoinOn = prompt.inputIsTaskGoingOn();
      }

      return;
    }

    //입력후 2 > 등록된 유저가 없으면 신규등록 의사를 묻는다. ----------------------------
    System.out.print("미등록된 사용자입니다. 신규 등록을 진행하시겠습니까(Y/N)?");
    registerSign = prompt.inputRegisterSign();

    if (registerSign.equals("N")) {
      System.out.println("사용자 등록을 취소하셨습니다.");
      run();
      return;
    }
    //2-2 > 신규 등록을 진행하려면 Y
    if (registerSign.equals("Y")) {
      while (!registerSuccess) {
        userName = prompt.inputUserName();

        if (!houseHoldLedger.checkHasUser(userName)) {
          System.out.print("신규비밀번호를 입력해주세요 : ");
          String newPassword = prompt.inputPassword();
          registerSuccess = houseHoldLedger.registerUser(userName, newPassword);
          System.out.println("등록이 완료되었습니다. 로그인 단계로 돌아갑니다.");
          run();
        }

        System.out.println("입력하신 이름이 이미 등록되어있습니다. 다른 이름을 입력해주세요.");
      }

    }

  }


  public static void main(String[] args) {
    run();
  }
}
