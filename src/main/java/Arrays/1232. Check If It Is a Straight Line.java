class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slopeOfCoordinates = calculateSlope(coordinates[0], coordinates[1]);

    for(int row = 2; row < coordinates.length; row++){
        if(slopeOfCoordinates != calculateSlope(coordinates[0], coordinates[row])){
            return false;
        }
    }
    return true;
}

public double calculateSlope(int[] coordinateOfPoint1, int[] coordinateOfPoint2){

    double slope = (((coordinateOfPoint1[1] - coordinateOfPoint2[1]) * 1.0) /
                    ((coordinateOfPoint1[0] - coordinateOfPoint2[0]) * 1.0));

    if((slope == Double.POSITIVE_INFINITY) || (slope == -Double.POSITIVE_INFINITY)){
        return Integer.MAX_VALUE;
    }

    return (((coordinateOfPoint1[1] - coordinateOfPoint2[1]) * 1.0) /
                     ((coordinateOfPoint1[0] - coordinateOfPoint2[0]) * 1.0));
    }
}
