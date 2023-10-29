package racingcar.controller;

import racingcar.model.Attempt;
import racingcar.model.Game;
import racingcar.model.Move;
import racingcar.model.Name;
import racingcar.view.InputView;

import java.util.*;

public class GameController {
    private final InputView inputView = new InputView();
    private final Name carName = new Name();
    private final Move move = new Move();
    private final Attempt attemptNum = new Attempt();
    HashMap<Object, String> distance = new HashMap<Object, String>();
    public void start() {
        List<String> player = Arrays.asList(inputView.name().split(","));
        carName.isValid(player);
        String attemptsNum = inputView.attemptsNum();
        attemptNum.isValid(attemptsNum);
        for (Object playerName : player){
            distance.put(playerName,"");
        }
        for (int i = 0; i < Integer.parseInt(attemptsNum); i++) {
            playGame(player, distance);
        }
    }

    public void playGame(List player, HashMap distance) {
        for (Object playerName : player){
            int randomNum = move.generateRandom();
            Game game = new Game(randomNum);
            if (game.move()){
                String a = (String) distance.get(playerName);
                a+="-";
                distance.put(playerName,a);
            }
        }
    }
}
