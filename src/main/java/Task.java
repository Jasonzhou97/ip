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

}
