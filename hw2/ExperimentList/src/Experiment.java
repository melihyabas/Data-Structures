/**
 * Experiment Class keeps information of an experiment. Additionally, it has own setter and getter methods.
 */
public class Experiment {

    private String setup;
    private int day;
    private String time;
    private boolean completed;
    private float accuracy;

    public String getSetup() {

        return setup;
    }

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public boolean getCompleted() {
        return completed;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setSetup(String s) {
        setup = s;
    }

    public void setDay(int d) {
        day = d;
    }

    public void setTime(String t) {
        time = t;
    }

    public void setCompleted(Boolean c) {
        completed = c;
    }

    public void setAccuracy(float a) {
        accuracy = a;
    }

}
