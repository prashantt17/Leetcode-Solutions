class Solution {
    class Car {
        int position;
        int speed;
        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        
        Arrays.sort(cars, (a, b) -> a.position - b.position);
        
        Stack<Double> fleets = new Stack<>();
        for (int i = cars.length - 1; i >= 0; i--) {
            double time = (double) (target - cars[i].position) / cars[i].speed;
            if (!fleets.isEmpty() && time <= fleets.peek()) {
                continue;
            }
            fleets.push(time);
        }
        
        return fleets.size();
    }
}
