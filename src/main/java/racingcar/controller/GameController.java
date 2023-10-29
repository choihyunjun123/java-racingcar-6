package racingcar.controller;

import racingcar.model.Move;
import racingcar.model.Name;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class GameController {
    private int randomNum, attemptsNum;
    private final InputView inputView = new InputView();
    private final Name name = new Name();
    private final Move move = new Move();
    public void start() {
        List<String> player = Arrays.asList(inputView.name().split(","));
        name.isValid(player);
        attemptsNum = Integer.parseInt(inputView.attemptsNum());
        randomNum = move.generateRandom();
        System.out.println(randomNum);
        System.out.println(attemptsNum);
    }
}
