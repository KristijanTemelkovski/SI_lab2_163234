import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
};

public class SILab2 {

    public List<Integer> function(List<Time> timesList) {  //1
        List<Integer> result = new ArrayList<>(); //1

        for (int i = 0; i < timesList.size(); i++) { // 2
            int hr = timesList.get(i).getHours(); //3
            int min = timesList.get(i).getMinutes(); //3
            int sec = timesList.get(i).getSeconds(); //3
            if (hr < 0 || hr > 24){ //4  *****
                if (hr < 0){ //5   **********
                    throw new RuntimeException("The hours are smaller than the minimum"); //6
                }
                else { //7 *************
                    throw new RuntimeException("The hours are grater than the maximum"); //8
                }
            }
            else if (hr < 24) { //9  *****
                if (min < 0 || min > 59) //10  ********
                    throw new RuntimeException("The minutes are not valid!"); //11   ********
                else { //12 **********
                    if (sec >= 0 && sec <= 59) //13  ***********
                        result.add(hr * 3600 + min * 60 + sec); //14
                    else //15
                        throw new RuntimeException("The seconds are not valid"); //16
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) { //17   ********
                result.add(hr * 3600 + min * 60 + sec); //18
            }
            else { //19  *********
                throw new RuntimeException("The time is greater than the maximum"); //20
            }
        } //21
        return result; //22
    } //23
}