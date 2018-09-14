package mengfw.regex;

public class TestStringFormat {
    public static void main(String[] args) {
        String template = "http://2899-upvns-sl-sts.travel.test.sankuai.com/sop-client/frame.html#/audit/handle?businessKey=%s&taskId=%d\n";
        System.out.println(String.format(template,"123",123));
    }
}
