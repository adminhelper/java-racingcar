package step1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp () {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인")
    public void size () {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("1, 2, 3의 값이 존재하는지를 확인 및 중복 코드를 제거")
    @ValueSource(ints =  {1,2,3})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("1, 2, 3의 값이 존재하면 true 4,5값이 존재하면 false")
    @CsvSource(value = {"1:true", "2:true","3:true","4:false","5:false"},delimiter = ':')
    void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(int input, boolean bool) {
        assertThat(numbers.contains(input)).isEqualTo(bool);
    }

}
