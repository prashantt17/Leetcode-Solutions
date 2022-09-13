class Solution {
    public double average(int[] salary) {
        int maxSalary=Integer.MIN_VALUE, minSalary = Integer.MAX_VALUE;
        double sum = 0;
        for(int x: salary)
        {
            maxSalary = Math.max(maxSalary,x);
            minSalary = Math.min(minSalary,x);
            sum += x;
        }
        return (sum-maxSalary-minSalary)/(salary.length-2);
    }
}
