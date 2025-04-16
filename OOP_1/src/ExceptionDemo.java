public class ExceptionDemo {
    static final int DEFAULT = 100;
    int n;

   ExceptionDemo(){
     n = DEFAULT;
   }
   ExceptionDemo(int num){
         n = num;
    }
    public  void prova() {
        try {
            if (n <= 0) {
                System.out.println("n must be positive. Using default.");
                ensurePositive();
                n = DEFAULT;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No argument specified for n. Using default.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer argument. Using default.");
        }

        System.out.println("n has value: " + n);
    }
    public static void ensurePositive(){
        throw new IllegalArgumentException("That's not positive!");
    }
}