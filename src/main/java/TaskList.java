public class TaskList {
    private Task[] tasks;
    private int num_of_tasks;
    public TaskList(){
        this.tasks = new Task[100];
        this.num_of_tasks = 0;
    }

    public void addTask(String title){
        tasks[num_of_tasks] = new Task(title);
        num_of_tasks+=1;
        System.out.println("added: "+title);
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
