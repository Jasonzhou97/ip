import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private String path;
    public Storage(String path){
        this.path = path;
    }

    public void saveToFile(TaskList tasks){
        try {
            FileWriter fw = new FileWriter(path);
            for(Task t : tasks.array()){
                String formatted = formatTask(t);
                fw.write(formatted);
            }
            fw.close();
        }
        catch (IOException e){
            System.out.println("File not created ");
        }
    }
    public String formatTask(Task task){
        String type = task instanceof Deadline ? "D"
                    : task instanceof ToDo ? "T" : "E";
        String status = task.getStatus();
        String basic = String.format("%s | %s | %s", type, status, task.getTitle());

        if (task instanceof Deadline) {
            return basic + " | " + ((Deadline) task).getEndDateFile()+"\n";
        } else if (task instanceof Event) {
            return basic + " | " + ((Event) task).getStartDate() + " | " + ((Event) task).getEndDate() +"\n";
        }
        return basic+"\n";
    }
    public TaskList loadTasks(){
        TaskList tasks = new TaskList();
        try {
            File tasksFile = new File(path);
            //create the file if user is opening for the first time
            if (tasksFile.createNewFile()) {
                System.out.println("File created successfully!");
            }
            Scanner sc = new Scanner(tasksFile);
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                Task task = parseTasks(line);
                tasks.addInitialTask(task);
            }
            sc.close();
            return tasks;
        }
        catch (FileNotFoundException e) {
            return tasks;
        }
        catch (IOException e) {
            System.out.println("Error occured");
        }
        catch (DukeException e) {
            System.out.println("Error parsing tasks");
        }
        return tasks;
    }

    public Task parseTasks(String line) throws DukeException{
        String[] parts = line.split(" \\| ");

            if (parts.length < 3) {
                throw new DukeException("Invalid task form!");
            }

        Task task = switch (parts[0]) {
            case "T" -> new ToDo(parts[2]);
            case "D" -> new Deadline(parts[2], parts[3]);
            case "E" -> new Event(parts[2], parts[3],parts[4]);
            default -> throw new DukeException("Unknown task type");
        };
            if(parts[1].equals("[X]")){
                task.markDoneSilently();
            }
            return task;
    }

}
