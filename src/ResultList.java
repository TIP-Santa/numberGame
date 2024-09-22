import java.util.ArrayList;
import java.util.List;

public class ResultList {
    Message msg = new Message();

    // 게임기록을 private로 선언하여 외부 접근 불가
    private List<Integer> resultList3 = new ArrayList<>();
    private List<Integer> resultList4 = new ArrayList<>();
    private List<Integer> resultList5 = new ArrayList<>();

    // 난이도에 따라 각 난이도 별 기록
    public void addResult(int result, int difficult) {
        switch (difficult) {
            case 3:
                resultList3.add(result);
                break;
            case 4:
                resultList4.add(result);
                break;
            case 5:
                resultList5.add(result);
                break;
            default:
        }
    }

    // 게임 기록 출력
    public void printResult(int difficult) {
        List<Integer> resultList = getResultListBydifficult(difficult);
        // 게임 기록이 존재하지 않을 경우 메세지 출력
        if(resultList.isEmpty()) {
            msg.noResultListMessage();
        } else {
            for (int i=0; i<resultList.size(); i++) {
                System.out.println((i+1) + "번째 게임 - 입력 횟수 : " + resultList.get(i));
            }
            System.out.println("------------------------");
        }

    }

    // 게임 기록 가져오기
    private List<Integer> getResultListBydifficult(int difficult) {
        switch (difficult) {
            case 3:
                return resultList3;
            case 4:
                return resultList4;
            case 5:
                return resultList5;
            default:
                return null;
        }
    }

}
