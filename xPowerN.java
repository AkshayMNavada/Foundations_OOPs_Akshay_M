public class xPowerN {
    public static void main(String[] args) {
        System.out.println(power(3,4));
    }
    public static int power(int x, int n) {
        int result;

        if( n == 0)
            return 1;

        result = power(x, n / 2);

        if (n % 2 == 0)
            return result * result;
        else
            return x * result * result;
    }
}
