package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final int MAX_NAME_LENGTH = 5;

    public static String readNames() {
        return Console.readLine();
    }

    public static String readTryCount() {
        return Console.readLine();
    }

    public static List<String> parseCarNames(String input) {
        validateNotEmpty(input);
        String[] nameArray = input.split(",");
        List<String> names = new ArrayList<>();

        for (String name : nameArray) {
            String trimmed = name.trim();
            validateName(trimmed);
            names.add(trimmed);
        }
        return names;
    }

    public static int parseTryCount(String input) {
        validateNotEmpty(input);
        int tryCount = toInteger(input);
        if (tryCount <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 숫자를 입력해야 합니다.");
        }
        return tryCount;
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 비어있습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다. (" + name + ")");
        }
    }

    private static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자만 입력 가능합니다.");
        }
    }
}