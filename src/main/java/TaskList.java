public class TaskList {
    private Task[] tasks;

    private int num_of_tasks;
    public TaskList(){
        this.tasks = new Task[100];
        this.num_of_tasks = 0;
    }

    public void addTask(Task task){
        tasks[num_of_tasks] = task;
        num_of_tasks+=1;
        System.out.println("Got it! I've added this task\n"+task.print());
        System.out.println("Now you have "+num_of_tasks+" tasks in the list.");

    }
    public void list(){
        for(int i=0;i<num_of_tasks;i++){
            Task t = tasks[i];
            int index = i+1;
            System.out.println(index+". "+t.print());
        }
    }
    public Task[] array(){
        return this.tasks;
    }
}
