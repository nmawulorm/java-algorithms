import java.util.Arrays;

public class ClosestToT {
    public static void main() {
        String s = "emkteneetkybe";
        String t = "e";
        int size = s.length();
        int[] result = new int[size];
        int[] tPositions = new int[size];
        int lastTPosition = 0;

        //Get all tPositions
        for(int i=0;i<size;i++) {
            if(s.charAt(i)=='e') {
                tPositions[lastTPosition] = i;
                lastTPosition++;
            }
        }

        for(int i=0;i<size;i++) {
            result[i] = getClosestDistance(i,tPositions);
        }

        System.out.println("e positions: "+ Arrays.toString(tPositions));
        System.out.println("Results: " + Arrays.toString(result));
    }

    private static int getClosestDistance(int sPosition, int[] tPositions) {
        int size = tPositions.length;
        int closestDistance = size;
        boolean firstCheckout = true;

        for(int i=0;i<size;i++) {

            int tValue = tPositions[i];
            if(firstCheckout) {
                int difference = tValue - sPosition;
                if(difference<0) difference = -difference;
                if(difference<closestDistance) closestDistance = difference;
                firstCheckout = false;
            } else if(tValue>0){
                int difference = tValue - sPosition;
                if(difference<0) difference = -difference;
                if(difference<closestDistance) closestDistance = difference;
            }
        }

        return closestDistance;
    }
}
