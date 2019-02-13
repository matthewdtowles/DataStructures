package recursion;

/**
 * KnapsackProblem
 * 
 * @author matthew.towles
 * @date Feb 11, 2019
 */
public class KnapsackProblem {
    
    /**
     * This method recursively attempts to find a
     * solution which exactly fills the sack.
     * @param weightLeftToFill
     * @param weightsAvailable
     * @param currentWeight
     * @return 
     */
//    public static boolean fillSack(
//            int weightLeftToFill,
//            int[] weightsAvailable,
//            int currentWeight
//    ) {
//        //base case 1 -The bag is full
//        if (weightLeftToFill == 0) {
//            System.out.println("Solution Found!! Weights are: ");
//            return true;
//        }
//        // base case 2 -There are no weights left to consider
//        else if (currentWeight >= weightsAvailable.length) {
//            return false;
//        }
//        // base case 3 -The bag is over full
//        else if (weightLeftToFill < 0) {
//            return false;
//        }
//        //recursive cases.  First assume there is an answer
//        //using the currentWeight
//        else if (fillSack(weightLeftToFill – weightsAvailable[currentWeight],
//                weightsAvailable, currentWeight + 1)) {
//            System.out.println(weightsAvailable[currentWeight]);
//            return true;
//        }
//        // Second case.  Since no solution was found in the
//        // previous step, there is no solution with the current
//        // weight, so look for a solution without it.
//        else {
//            return fillSack(weightLeftToFill,weightsAvailable,currentWeight+1);
//        }
//        return false;
//    }
}
