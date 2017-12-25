/**
 *
 */
package day35;

import java.util.Scanner;

/**
 * @author neeraj
 */
class TestClass {
    static void solve(int arr[]) throws Exception {
        int ans = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (j > 10) {
                    throw new ArrayInvalidIndex(0);
                }
                if (arr[j] == 0) {
                    throw new ZeroException(0);
                }

                ans += arr[i] / arr[j];

            }
        }

        throw new MyException(ans);
    }

    public static void main(String args[]) throws Exception {
        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] arr = new int[n];
            in.nextLine();

            for (int i = 0; i < 10; i++)
                try {
                    arr[i] = Integer.parseInt(in.nextLine());

                } catch (Exception e) {
                    throw new StringException(1);
                }


            String s = in.nextLine();
            if (s.length() < 10) {
                throw new StringValidException(2);
            }
            System.out.println(s.charAt(10));

            solve(arr);
        } catch (StringValidException myException) {

            System.out.println("Index is invalid");

        } catch (ArrayInvalidIndex myException) {

            System.out.println("Array index is invalid");

        } catch (StringException myException) {

            System.out.println("Format mismatch");

        } catch (ZeroException myException) {

            System.out.println("Invalid division");

        } catch (MyException myException) {
            System.out.println("MyException[" + myException.param + "]");
        } catch (NumberFormatException e) {
            System.out.println("Format mismatch");
        } catch (Exception e) {
            System.out.println("Exception encountered");
        }
        System.out.println("Exception Handling Completed");

    }
}

     class MyException extends Exception {

        private static final long serialVersionUID = 1L;

        public int param;

        MyException(int param) {
            this.param = param;
        }

    }

     class ZeroException extends Exception {

        private static final long serialVersionUID = 1L;

        private int param;

        ZeroException(int param) {
            this.param = param;
        }

    }
     class StringException extends Exception {

        private static final long serialVersionUID = 1L;

        private int param;

        StringException(int param) {
            this.param = param;
        }

    }

     class StringValidException extends Exception {

        private static final long serialVersionUID = 1L;

        private int param;

        StringValidException(int param) {
            this.param = param;
        }

    }
     class ArrayInvalidIndex extends Exception {

        private static final long serialVersionUID = 1L;

        private int param;

        ArrayInvalidIndex(int param) {
            this.param = param;
        }



}