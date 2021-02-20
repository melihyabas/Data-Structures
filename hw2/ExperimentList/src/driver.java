import java.util.NoSuchElementException;

/**
 * This is a driver class. It writted to test programm
 */
public class driver {
    /**
     * main method of driver
     * @param args String argument
     */
    public static void main(String[] args){
        ExperimentList expList1 = new ExperimentList();
        expList1.head = new ExperimentNode();

        ExperimentNode exp1 = new ExperimentNode();
        exp1.obj = new Experiment();
        exp1.obj.setSetup("The experiment was run in phases.");
        exp1.obj.setDay(1);
        exp1.obj.setTime("08:00");
        exp1.obj.setCompleted(true);
        exp1.obj.setAccuracy(1780);

        ExperimentNode exp12 = new ExperimentNode();
        exp12.obj = new Experiment();
        exp12.obj.setSetup("Nothing was calculeted in the earth.");
        exp12.obj.setDay(1);
        exp12.obj.setTime("05:00");
        exp12.obj.setCompleted(true);
        exp12.obj.setAccuracy(749);
        exp1.next = exp12;

        ExperimentNode exp2 = new ExperimentNode();
        exp2.obj = new Experiment();
        exp2.obj.setSetup("This experiment used the 6-city domain and was run in 6 phases.");
        exp2.obj.setDay(2);
        exp2.obj.setTime("10:00");
        exp2.obj.setCompleted(true);
        exp2.obj.setAccuracy(421);

        expList1.head.next = exp1;
        exp12.next = exp2;

        exp1.nextDay = exp2;

        ExperimentNode exp3 = new ExperimentNode();
        exp3.obj = new Experiment();
        exp3.obj.setSetup("The planner could take advantage of linking opportunities.");
        exp3.obj.setDay(2);
        exp3.obj.setTime("18:30");
        exp3.obj.setCompleted(true);
        exp3.obj.setAccuracy(17);
        exp2.next = exp3;

        ExperimentNode exp4 = new ExperimentNode();
        exp4.obj = new Experiment();
        exp4.obj.setSetup("It also meant that often the planner.");
        exp4.obj.setDay(3);
        exp4.obj.setTime("20:00");
        exp4.obj.setCompleted(true);
        exp4.obj.setAccuracy(457);
        exp3.next = exp4;
        expList1.listExp(1);
        expList1.listExp(2);
        expList1.listExp(3);
        exp2.nextDay = exp4;
        System.out.printf("\n\naddExp method tested.\n");
        System.out.printf("\n___________________________________\n");

        Experiment exp5 = new Experiment();
        exp5 = new Experiment();
        exp5.setSetup("The size of the test problems!");
        exp5.setDay(3);
        exp5.setTime("23:00");
        exp5.setCompleted(true);
        exp5.setAccuracy(7500);
        expList1.addExp(exp5);
        expList1.listExp(1);
        expList1.listExp(2);
        expList1.listExp(3);

        Experiment exp6 = new Experiment();
        exp6 = new Experiment();
        exp6.setSetup("\"Experimental Setup\" in his science journal articles.");
        exp6.setDay(2);
        exp6.setTime("22:55");
        exp6.setCompleted(true);
        exp6.setAccuracy(4321);

        expList1.addExp(exp6);

        System.out.printf("\n___________________________________\n");

        System.out.printf("\n\nGet operation tested.\n");
        expList1.listExp(1);
        expList1.listExp(2);
        expList1.listExp(3);
        ExperimentNode getting = new ExperimentNode();

        try{
            getting = (expList1.getExp(2,2));        }
        catch (Exception e)
        {
            System.out.printf("\nKONUM BULUNAMADII\n");
        }

        System.out.printf("\nThe Experiment that we get:\n");
        System.out.printf("Setup:%s\n",getting.getObj().getSetup());
        System.out.printf("Day:%s\n",getting.getObj().getDay());
        System.out.printf("Time:%s\n",getting.getObj().getTime());
        System.out.printf("Completed:%s\n",getting.getObj().getCompleted());
        System.out.printf("Accuracy:%s\n\n\n",getting.getObj().getAccuracy());

        System.out.printf("\n___________________________________\n");

        Experiment setting = new Experiment();
        setting = new Experiment();

        setting.setSetup("SET OPERATION IS FINISHED!");
        setting.setDay(1);
        setting.setTime("00:00");
        setting.setCompleted(true);
        setting.setAccuracy(1234);

        System.out.printf("\n\nsetExp Method tested.\n");
        try{
            expList1.setExp(2,1,setting);
        }
        catch (Exception e)
        {
                System.out.printf("\nKONUM BULUNAMADII\n");
        }
        expList1.listExp(1);
        expList1.listExp(2);
        expList1.listExp(3);
        System.out.printf("\n___________________________________\n");

        System.out.printf("\n\nremoveDay method tested.\n");
        expList1.removeDay(2);
        expList1.listExp(1);
        expList1.listExp(2);
        expList1.listExp(3);

        System.out.printf("\n___________________________________\n");

        System.out.printf("\n\nremoveExp method tested.\n");
        expList1.listExp(1);
        expList1.listExp(2);
        expList1.listExp(3);

        try {
            expList1.removeExp(1, 1);
        }
        catch (Exception e)
        {
            System.out.printf("\nThere is no experiment there!\n");
        }
        System.out.printf("\n___________________________________\n");

        System.out.printf("\norderDay method tested.\n");

       expList1.orderDay(1);
        System.out.printf("\n___________________________________\n");

        expList1.orderExperiments();
        System.out.printf("\norderExperiments method tested.\n");

    }
}