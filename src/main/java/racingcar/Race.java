package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int RANDOM_START_INCLUSIVE = 0;
    private static final int RANDOM_END_INCLUSIVE = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int tryCount) {
        for (int round = 0; round < tryCount; round++) {
            runRound();
            ResultView.printRoundResult(cars);
        }
    }

    private void runRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
            if (randomValue >= MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        return filterWinners(maxPosition);
    }

    private int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<Car> filterWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}