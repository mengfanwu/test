package mengfw.test.lombok.getter;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.NONE)
public class TestClassGetter {
    private String fieldA;
    private Integer fieldB;
}
