package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            // 1. 자동차 이름 입력받기
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String inputNames = InputView.readNames();
            List<String> names = InputView.parseCarNames(inputNames);

            // 2. 시도할 회수 입력받기
            System.out.println("시도할 회수는 몇회인가요?");
            String inputTryCount = InputView.readTryCount();
            int tryCount = InputView.parseTryCount(inputTryCount);

            // 3. 자동차 객체 리스트 생성
            List<Car> cars = CarFactory.createCars(names);

            // 4. 게임 진행
            System.out.println("\n실행 결과");
            Race race = new Race(cars);
            race.play(tryCount);

            // 5. 우승자 판별
            List<Car> winners = race.findWinners();

            // 6. 우승자 출력
            ResultView.printWinners(winners);

        } catch (IllegalArgumentException e) {
            // 예외 메시지 출력 후 프로그램 종료(별도 System.exit() 호출 X)
            System.out.println(e.getMessage());
        }
    }
}