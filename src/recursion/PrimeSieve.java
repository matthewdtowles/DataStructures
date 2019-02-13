package recursion;

/**
 * PrimeSieve
 * 
 * @author matthew.towles
 * @date Feb 11, 2019
 */
public class PrimeSieve {
    
    private static class SieveNode {
        private int myPrime;
        private SieveNode nextSieveNode;

        /**
         * When node is created, print out value
         * as it is a new prime
         */
        public SieveNode(int prime) {
            myPrime = prime;
            System.out.println(myPrime);
        }
        
        /**
         * Check to see if number is divisible
         * by this node in sieve
         * if not, pass to next node in sieve
         * 
         * if this is last node in sieve
         * and number is prime
         * create a new sieve node
         */
        public void checkPrime(int number) {
            if ((number % myPrime) == 0) {
                return;
            }
            else if(nextSieveNode == null) {
                nextSieveNode = new SieveNode(number);
            }
            else {
                nextSieveNode.checkPrime(number);
            }
        }
    }
    
//    public static void main(String[] args) {
//        // print out 1 (do not put in sieve):
//        System.out.println(1);
//        //init sieve with prime, 2:
//        SieveNode sieve = new SieveNode(2);
//        for (int i = 3; i < 100; i = i + 2) {
//            sieve.checkPrime(i);
//        }
//    }
}
