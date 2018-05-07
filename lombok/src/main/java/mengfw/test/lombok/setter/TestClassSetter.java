package mengfw.test.lombok.setter;

import lombok.AccessLevel;
import lombok.Setter;

@Setter(value = AccessLevel.PUBLIC)
public class TestClassSetter {
    private String fieldA;
    private Integer fieldB;
}
