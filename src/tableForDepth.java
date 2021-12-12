
public class tableForDepth {

    //The depth options for Table One:
    private final static int[] DEPTH_ARRAY = {35, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140};
    //The dive times for Table One:
    private final static int[][] DEPTH_TIMES = {
            {10, 19, 25, 29, 32, 36, 40, 44, 48, 52, 57, 62, 67, 73, 79, 85, 92, 100, 108, 117, 127, 139, 152, 168, 188, 205},
            {9, 16, 22, 25, 27, 31, 34, 37, 40, 44, 48, 51, 55, 60, 64, 69, 74, 79, 85, 91, 97, 104, 111, 120, 129, 140},
            {7, 13, 17, 19, 21, 24, 26, 28, 31, 33, 36, 39, 41, 44, 47, 50, 53, 57, 60, 63, 67, 71, 75, 80},
            {6, 11, 14, 16, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 42, 44, 47, 49, 52, 54, 55},
            {5, 9, 12, 13, 15, 16, 18, 19, 21, 22, 24, 26, 27, 29, 31, 33, 35, 36, 38, 40},
            {4, 8, 10, 11, 13, 14, 15, 17, 18, 19, 21, 22, 23, 25, 26, 28, 29, 30},
            {4, 7, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25},
            {3, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {3, 6, 7, 8, 9, 10, 11, 12, 13, 13, 14, 15, 16},
            {3, 5, 6, 7, 8, 9, 10, 11, 11, 12, 13},
            {3, 5, 6, 7, 7, 8, 9, 10},
            {4, 4, 5, 6, 7, 8}
            };

    //Constructor not accessible
    private tableForDepth(){

    }

    /*
    get the entire depth array
     */
    public static int[] getDepthArray(){
        return DEPTH_ARRAY;
    }

    /*
    Returns the rounded depth
     */
    public static int roundedDepth(int depthEstimate){
    	
       int depthRounded = calculationOfDive.arrayRoundingUp(depthEstimate, DEPTH_ARRAY);
       return depthRounded;
       
    }

    /*
    gets the single array of possible depth times from the 2D array
     */
    public static int[] currentDepthime(int roundedDepth){
    	
        int row = calculationOfDive.indexSearch(roundedDepth, DEPTH_ARRAY);
        int[] currentRow = new int[DEPTH_TIMES[row].length];
        
        for(int i = 0; i < DEPTH_TIMES[row].length; i++){
        	
            currentRow[i] = DEPTH_TIMES[row][i];
            
        }
        return currentRow;
    }
    
    

    //Round to the nearest dive time
    public static int roundTheTime(int time, int[] array){
    	
        int nearestTime =  calculationOfDive.arrayRoundingUp(time, array);
        return nearestTime;
    }

    //
    public static char currentPressure(int diveTime, int[] time){
    	
        int i = calculationOfDive.indexSearch(diveTime, time);
        char currentPressure = calculationOfDive.pressureFromIndex(i);
        return currentPressure;
    }

    
    public static int nitroTime(char pressure, int[] depthTimes){
    	
        int i = calculationOfDive.pressureIndex(pressure);
        int residualNitrogenTime = depthTimes[i];
        return residualNitrogenTime;
    }

    public static int[] depthTimeWithoutNitro(int nitroTime, int[] time){
    	
        int limit = time[time.length-1] - nitroTime;
        int roundLimit = calculationOfDive.arrayRoundingDown(limit, time);
        int indexStopper = calculationOfDive.indexSearch(roundLimit, time);
        int[] changedDepthtimeArray = new int[indexStopper+1];
        
        for(int i = 0; i < changedDepthtimeArray.length; i++){
        	
        	changedDepthtimeArray[i] = time[i];
            
        }
        return changedDepthtimeArray;
    }

}
