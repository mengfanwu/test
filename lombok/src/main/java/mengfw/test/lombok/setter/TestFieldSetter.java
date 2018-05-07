package mengfw.test.lombok.setter;

import lombok.AccessLevel;
import lombok.Setter;

public class TestFieldSetter {
    @Setter(AccessLevel.PUBLIC)
    private String fieldA;
    @Setter(AccessLevel.PRIVATE)
    private Integer fieldB;
    private Long fieldC;
}
