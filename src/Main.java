import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 입력 오류 발생 예상
// 메인화면
// 0 ~ 3 이 아닌 숫자를 입력할 경우
// 문자를 입력할 경우

// 0. 난이도 입력구간
// 숫자가 아닌 문자를 입력할 경우
// 3 ~ 5 가 아닌 숫자를 입력할 경우

// 1. 게임 구간
// 숫자가 아닌 문자를 입력할 경우
// 동일한 숫자를 입력할 경우
// 난이도에 따른 자릿수를 넘어서는 숫자를 입력할 경우
// 난이도에 따른 자릿수에 미치지 못하는 숫자를 입력할 경우

// 2. 게임 기록 구간
// 입력이 존재하지 않으므로 입력 오류 없음

// 3. 게임 종료 구간
// y, n을 제외한 다른 문자 또는 숫자를 입력할 경우


public class Main {
    public static void main(String[] args) {
        RandomNumbers randomNumbers = new RandomNumbers();
        Stadium stadium = new Stadium();
        Message msg = new Message();
        ResultList resultList = new ResultList();

        Scanner scanner = new Scanner(System.in);

        // 기본 난이도 3으로 설정
        int difficultNumber = 3;
        List<String> rNum;
        boolean exit = false;

        // 시작 메세지
        System.out.println("환영합니다! 무엇을 하고싶으신가요?");
        msg.Message();

        while (true) {
            String input = scanner.nextLine();
            // 0을 입력한 경우 난이도 세팅
            // 난이도는 3 ~ 5
            if (input.equals("0")) {
                while(true){
                    System.out.println("난이도를 3 ~ 5 중 골라서 입력해주세요.");
                    // 입력값이 숫자가 아닌 경우 예외처리
                    try {
                        difficultNumber = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        msg.errInputMessage();
                        scanner.nextLine();
                        continue;
                    }
                    // 입력값이 3 ~ 5가 아닌 경우 메세지 출력
                    if (difficultNumber > 2 && difficultNumber < 6) {
                        System.out.println("난이도 설정 : " + difficultNumber);
                        msg.Message();
                        break;
                    } else {
                        msg.errInputMessage();
                    }
                }
            }
            // 1을 입력한 경우 게임 시작
            // 게임 도중 "exit" 입력시 메인화면으로 복귀
            // 난이도에 따른 예제의 자릿수 변경
            else if (input.equals("1")) {
                System.out.println("숫자 야구게임을 시작합니다.");
                System.out.println("도중에 게임을 종료하시려면 exit를 입력해주세요.");
                System.out.println("1 ~ 9까지의 숫자 중 " + difficultNumber + "가지를 중복없이 입력해주세요");
                switch (difficultNumber) {
                    case 3:
                        System.out.println("Ex) 854");
                        break;
                    case 4:
                        System.out.println("Ex) 8542");
                        break;
                    case 5:
                        System.out.println("Ex) 85427");
                        break;
                    default:
                }
                // 무작위 숫자 생성
                // 난이도에 따라 숫자 개수 다르게 생성
                rNum = randomNumbers.RandomNumbers(difficultNumber);
                // 게임 시작
                int result = stadium.gameMessage(rNum, difficultNumber);
                // result 값이 -1인 경우 (중간에 돌아온 경우) 게임기록에 기록하지 않는다.
                if (result != -1) {
                    // 난이도에 따라 각 난이도 별 기록 저장
                    resultList.addResult(result, difficultNumber);
                }
                // 게임 완료 후 메세지 (중간에 돌아온 경우에도 해당)
                msg.Message();
            }
            // 2를 입력한 경우 게임 기록 보기
            // 게임 기록이 존재하지 않는 경우 메세지 출력
            else if (input.equals("2")) {
                System.out.println("게임 기록을 출력합니다.");
                System.out.println("현재 설정된 난이도 : " +  difficultNumber);
                // 게임 기록 출력
                resultList.printResult(difficultNumber);
                msg.Message();
            }
            // 3을 입력한 경우 반복문 탈출하여 종료
            // 한번 더 물어보며 기록 초기화 명시
            else if (input.equals("3")) {
                System.out.println("게임을 종료하면 게임 기록이 초기화됩니다.");
                System.out.println("정말 종료하시겠습니까? y/n");

                while(true){
                    String exitInput = scanner.nextLine();
                    if (exitInput.equals("y")) {
                        System.out.println("숫자 야구게임이 종료됩니다.");
                        exit = true;
                        break;
                    } else if(exitInput.equals("n")) {
                        System.out.println("되돌아온 것을 환영합니다.");
                        System.out.println("------------------------");
                        msg.Message();
                        break;
                    } else {
                        // y, n이 아닌 문자 또는 숫자일 경우 메세지 출력
                        msg.errInputMessage();
                        System.out.println("정말 종료하시겠습니까? y/n");
                        continue;
                    }
                }
                // exit가 true인 경우 게임 종료
                if(exit){break;}
            } else {
                // 0 ~ 3을 제외한 다른 값 입력 시 메세지
                msg.errInputMessage();
                msg.Message();
            }
        }
    }
}