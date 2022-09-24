class ParkingSystem {

    int small;
int big;
int medium;

int x_small;
int x_big;
int x_medium;
public ParkingSystem(int big, int medium, int small) {
        this.small=small;
        this.medium=medium;
        this.big=big;
}

public boolean addCar(int carType) {
        if(carType==1){
            if(x_big==big){
                return false;
            }
            x_big++;
            return true;
        }
       else if(carType==2){
           if(x_medium==medium){
               return false;
           }
           x_medium++;
           return true;
       }
    else{
        if(x_small==small){
            return false;
        }
        x_small++;
        return true;
    }
}
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
