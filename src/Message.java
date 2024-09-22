public class Message {
    public void Message(){
        System.out.println("0. 난이도(문제의 자릿수) 설정");
        System.out.println("1. 숫자 야구게임 시작하기");
        System.out.println("2. 게임 기록 보기");
        System.out.println("3. 숫자 야구게임 종료하기");
    }
    public void noResultListMessage(){
        System.out.println("게임 기록이 존재하지 않습니다.");
        System.out.println("------------------------");
    }
    public void errInputMessage(){
        System.out.println("잘못된 입력값입니다.");
        System.out.println("------------------------");
    }
}
