package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AttemptNumTest {

    @Test
    void 게임_실행_횟수_유효성_검사() {
        AttemptNum attemptNum = new AttemptNum();
        assertThatThrownBy(() -> attemptNum.isValid("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}