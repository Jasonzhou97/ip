package duke.task;
public class Task {
    /**
     * basic variables every task and subclasses should have
     */
    private String title;
    private Boolean isDone;

    /**
     *
     * @param title name of task
     */
    public Task(String title){
        this.title = title;
        this.isDone = false;
    }

    /**
     *
     * @return the name of the task
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * if mark will return with a X
     * @return the string of the status of task
     */
    public String getStatus(){
        return isDone ? "[X]" : "[ ]";
    }

    public Boolean getIsDone(){
        return isDone;
    }
    /**
     * method to mark task as done along with printing the details
     */
    public void markDone(){
        isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(print());
    }

    /**
     * for loading tasks that are done without output
     */
    public void markDoneSilently(){
        isDone = true;
    }
    /**
     * method to unmark task along with printing the details
     */
    public void unmark(){
        isDone = false;
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(print());
        isDone = false;
    }

    /**
     *
     * @return the messages that describes the task
     */
    public String print(){
        return getStatus() + " "+this.title;
    }


}
