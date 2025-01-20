public class Deadline extends Task {

    private String title;
    private Boolean isDone;
    /**
     * new variable for end date and time
     */
    private String endDate;

    /**
     *
     * @param title name of todo task
     * @param endDate end date and time of todo
     */
    public Deadline(String title,String endDate){
        super(title);
        this.endDate = endDate;
    }

    /**
     *
     * @return end date time
     */
    public String getEndDate(){
        return "(by: " + endDate +")";
    }
    @Override
    public String print(){
        return "[D]" + " "+ this.getStatus() + " " + this.getTitle() + this.getEndDate();
    }


}
