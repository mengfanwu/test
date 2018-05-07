package mengfw.test.lombok.getter;

import lombok.AccessLevel;
import lombok.Getter;

public class TestFieldGetter {
    @Getter(AccessLevel.PUBLIC)
    private String fieldA;
    @Getter(AccessLevel.PRIVATE)
    private Integer fieldB;
    private Long fieldC;
}
