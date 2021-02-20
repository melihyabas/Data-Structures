/**
 * Keeps an experiment, its next and its next day.
 */
public class ExperimentNode {
    public Experiment obj;

    public ExperimentNode()
    { }
    public  ExperimentNode(Experiment e)
    {
        obj = e;
    }
    public Experiment getObj()
    {
        return obj;
    }
    public void setObj(Experiment e)
    {
        obj = e;
    }

    public ExperimentNode next;
    public ExperimentNode nextDay;



}
