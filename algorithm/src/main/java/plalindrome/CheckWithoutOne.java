package plalindrome;

/**
 * 检查是否是回文串，允许最多擦除一个字符
 */
public class CheckWithoutOne {
    public static boolean check(String str ,int site){
        if(str == null){
            return false;
        }
        int len = str.length();
        if(len <= 1){
            return false;
        }
        int left = 0;
        int right = len - 1;
        boolean wipe = false;
        while (true){
            if(left == right || left == right - 1 ){
                return true;
            }
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);
            if(leftChar == rightChar){
                left ++;
                right --;
                continue;
            }
            if(wipe){
                return false;
            }
            wipe = true;
            if(site == 1){//left
                left ++;
                char leftAddChar = str.charAt(left);
                if(leftAddChar != rightChar){
                    return false;
                }

            }else if(site == 2){
                right --;
                char rightAddChar = str.charAt(right);
                if(rightAddChar != leftChar){
                    return false;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(check("aaaaaaa"));//abcbcgcbcbca
    }
    public static boolean check(String str){
        return check(str, 1) || check(str, 2);
    }
}
