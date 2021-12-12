
public class calculationOfDive {


	// compares our integer input of the depth to the integer array and will round up to show the nearest one
    public static int arrayRoundingUp(int depthValue, int[] array){
        int results = array[0];

        for(int i = 1 ; i < array.length; i++){
            if(depthValue > results){
                results = array[i];
            }
        }
        return results;
    }

    
    // compares our integer input of the depth to the integer array and will round down to show the nearest one
    public static int arrayRoundingDown(int depthValue, int[] array){
        int results = array[array.length-1];

        for(int i = array.length - 2 ; i >= 0; i--){
            if(depthValue < results){
                results = array[i];
            }
        }
        return results;
    }
    
    
    
    
    //creates and returns a char array of the alphabet(Capitalized)
    public static char[] createPressureList(){
    	
        char []pressureGroups = new char[26];
        int i = 65;
        
        for (int j = 0; j < pressureGroups.length; j++){
        	
            pressureGroups[j] = (char)i;
            i++;
            
        }
        
        return pressureGroups;
    }

    
    public static int pressureIndex(char pressure){
    	
        char[] pressureList = createPressureList();
        int i = indexSearch(pressure, pressureList);
        return i;
    }
    

    public static char pressureFromIndex(int i){
    	
    	// equals the return of the createPressureList
        char[] pressureLists = createPressureList();
        // this equals an index from the function return
        char currentPressure = pressureLists[i];
        
        return currentPressure;
    }

    // index search for an integer value
    public static int indexSearch(int integer, int[] arrayList){
    	
        for(int i = 0; i < arrayList.length ; i++){
        	
            if(integer == arrayList[i]){
                return i;
            }
            
        }
            return -1;
        }

    // index search for a char value
    public static int indexSearch(char character, char[] arrayList){
    	
        for(int i = 0; i < arrayList.length ; i++){
        	
            if(character == arrayList[i]){
                return i;
            }
        }
            return -1;
    }



}
