public class Event extends Task{
    private String title;
    private Boolean isDone;
    /**
     * 2 new variables specifying start and end date
     */
    private String startDate;
    private String endDate;

    public Event(String title,String startDate,String endDate){
        super(title);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPeriod(){
        return " (from: "+startDate+" to: "+endDate+")";
    }

    @Override
    public String print(){
        return "[E]" + " "+ this.getStatus() + " " + this.getTitle() + this.getPeriod();
    }

}
