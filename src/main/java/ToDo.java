public class ToDo extends Task{
    private String title;
    private Boolean isDone;

    /**
     *
     * @param title to call the parent constructor
     */
    public ToDo(String title){
        super(title);
    }

    /**
     *
     * @return the new message with type [T]
     */
    @Override
    public String print(){
        return "[T]" + " "+ this.getStatus() + " " + this.getTitle();
    }
}
