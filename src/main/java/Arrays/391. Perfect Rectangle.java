class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
    Set<String> points = new HashSet<String>();
    int area = 0;
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxA = Integer.MIN_VALUE;
    int maxB = Integer.MIN_VALUE;
    for (int[] r : rectangles){
        int x = r[0];
        int y = r[1];
        int a = r[2];
        int b = r[3];
        area += (x-a) * (y-b);
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxA = Math.max(maxA, a);
        maxB = Math.max(maxB, b);
        String bottomLeft = getHash(x,y);
        String topLeft = getHash(x,b);
        String bottomRight = getHash(a,y);
        String topRight = getHash(a,b);
        checkInSet(points, bottomLeft);
        checkInSet(points, topLeft);
        checkInSet(points, bottomRight);
        checkInSet(points, topRight);
    }
    String fullBottomLeft = getHash(minX,minY);
    String fullTopLeft = getHash(minX,maxB);
    String fullBottomRight = getHash(maxA,minY);
    String fullTopRight = getHash(maxA,maxB);
    if (points.size() != 4 || !points.contains(fullBottomLeft) 
        || !points.contains(fullTopLeft) || !points.contains(fullBottomRight) || !points.contains(fullTopRight)) return false;
    int fullArea = (minX-maxA) * (minY-maxB);
    return area == fullArea;
}
private void checkInSet(Set<String> points, String hash){
    if (!points.contains(hash)) points.add(hash);
    else points.remove(hash);
}
private String getHash(int x, int y){
    return x + ":" + y;
    }
}
