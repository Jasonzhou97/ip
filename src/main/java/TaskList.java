import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    private int num_of_tasks;
    public TaskList(){
        this.tasks = new ArrayList<Task>();
        this.num_of_tasks = 0;
    }

    public void addTask(Task task){
        tasks.add(task);
        num_of_tasks+=1;
        System.out.println("Got it! I've added this task\n"+task.print());
        System.out.println("Now you have "+num_of_tasks+" tasks in the list.");

    }
    public void list(){
        for(int i=0;i<num_of_tasks;i++){
            Task t = tasks.get(i);
            int index = i+1;
            System.out.println(index+". "+t.print());
        }
    }
    public ArrayList<Task> array(){

        return this.tasks;
    }

    public void delete(int index) throws DukeException{
        if(index>num_of_tasks || index<0){
            throw new DukeException("Oops you entered an invalid index!");
        }
        Task task = this.tasks.get(index);
        System.out.println("Noted. I've removed this task: \n"+task.print());

        this.tasks.remove(index);
        num_of_tasks--;
        System.out.println("Now you have "+num_of_tasks+" tasks in the list.");
    }

}
