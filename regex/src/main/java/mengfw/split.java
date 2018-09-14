package mengfw;

public class split {
    public static void main(String[] args) {
        String s = "装修开始时间##装修结束时间#";
        String[] split = s.split("#");

        System.out.println(split.length);
        for (String str:split){
            System.out.println(str);
        }
    }
}
