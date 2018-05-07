package mengfw.test.lombok.data;

import lombok.Data;

@Data(staticConstructor = "build")
public class TestData {
    private String fieldA;
    private Integer fieldB;
}
