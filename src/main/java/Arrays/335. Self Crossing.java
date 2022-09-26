class Solution {
    public boolean isSelfCrossing(int[] distance) {
        boolean arm = false;
        boolean leg = false;
        for (int i = 2; i < distance.length; ++i) {
        int a = f(distance, i - 2) - f(distance, i - 4);
        int b = f(distance, i - 2);

        if (arm && distance[i] >= b)          return true;  
        if (leg && distance[i] >= a && a > 0) return true;  

        if (distance[i] < a)       arm = true;
        else if (distance[i] <= b) leg = true;
        }
        return false;
        }
        private int f(int[] distance, int index) {
        return (index < 0) ? 0 : distance[index];
    }
}
