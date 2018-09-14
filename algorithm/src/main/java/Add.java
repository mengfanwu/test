public class Add {
    public static void main(String[] args) {
        System.out.println(calc2(50));
    }

    public static long calc (int size){
        long a = 1,b = 1;
        if(size == 1 || size == 2){
            return 1;
        }
        for (int i = 3;i<=size;i++){
            long s = a+b;
            a = b;
            b = s;
        }
       return b;
    }

    public static long calc2(int size){
        if(size == 1 || size == 2){
            return 1;
        }
        return calc2(size-1) + calc2(size -2);
    }
}
