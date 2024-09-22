import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stadium {

    public int gameMessage(List<String> randomNumbers, int difficultNumber){
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;

        while (true){
            String input = scanner.nextLine();
            // 게임 도중 탈출
            if(input.equals("exit")){
                System.out.println("초기 화면으로 돌아갑니다.");
                System.out.println("------------------------");
                return -1;
            }
            // 숫자가 아닌 값이 입력된 경우
            if(!input.matches("\\d+")) {
                System.out.println("숫자가 아닌 값이 포함되어있습니다.");
                continue;
            }
            String[] inputs = input.split("");
            // 숫자가 난이도의 자릿수 미만거나 초과인 경우
            if(inputs.length != difficultNumber) {
                System.out.println("입력된 숫자가 " + difficultNumber + "자리 미만이거나 초과입니다.");
                continue;
            }
            //중복된 숫자가 있는 경우 오류값 출력
            boolean flag = false;
            for(int i=0; i<inputs.length; i++){
                for (int j=i+1; j< inputs.length; j++){
                    if(inputs[i].equals(inputs[j])) {
                        System.out.println("중복된 숫자가 존재합니다.");
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) {continue;}

            // 스트라이크 : 같은 자리에 같은 숫자가 있는 경우
            // 볼 : 숫자는 같지만 위치가 다른 경우
            // 아웃 : 숫자가 다른 경우
            String[] gameMessage = new String[difficultNumber];
            for (int i = 0; i < difficultNumber; i++) {
                if(randomNumbers.get(i).equals(inputs[i])) {
                    gameMessage[i] = "스트라이크";
                } else if (randomNumbers.contains(inputs[i])) {
                    gameMessage[i] = "볼";
                } else {
                    gameMessage[i] = "아웃";
                }
            }
            // 게임 진행 횟수 카운트
            cnt ++;

            System.out.println("입력된 숫자 " + Arrays.toString(inputs));
            System.out.println(Arrays.toString(gameMessage));

            // 클리어 여부 확인
            int strikeCount = 0;
            for (String a : gameMessage) {
                if(a.equals("스트라이크")){
                    strikeCount++;
                }
            }
            if (strikeCount == difficultNumber){
                System.out.println("------------------------");
                System.out.println("클리어했습니다. 축하합니다.");
                System.out.println("입력 횟수 : " + cnt);
                System.out.println("------------------------");
                return cnt;
            } else {
            }
        }
    }
}
