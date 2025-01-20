public class Task {
    private String title;
    private Boolean isDone;
    public Task(String title){
        this.title = title;
        this.isDone = false;
    }

    public String getTitle(){
        return this.title;
    }

    public String getStatus(){
        return isDone ? "[X]" : "[ ]";
    }

    public void markDone(){
        isDone = true;
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(print());
    }

    public void unmark(){
        isDone = false;
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(print());
        isDone = false;
    }

    public String print(){
        return getStatus() + " "+this.title;
    }


}
