import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    public List<String> RandomNumbers(int difficultNumber) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        // 난이도의 숫자만큼 number의 크기를 조정하여 해당 갯수만큼의 랜덤 숫자를 생성
        while (numbers.size() < difficultNumber) {
            int randomNumber = random.nextInt(9)+1;
            // 중복이 아닐 경우에만 List에 추가
            if(!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        // int > String 형변환
        List<String> randomNumbers = new ArrayList<>();
        for(Integer a : numbers) {
            randomNumbers.add(a.toString());
        }
        return randomNumbers;
    }
}
