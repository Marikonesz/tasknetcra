package ua.sumdu.j2se.Moroz.tasks.Model;


import java.util.Arrays;

/**
 * the class implements a task list based on the array
 */
public class ArrayTaskList extends TaskList {
    /**
     * array of tasks
     */
    private Task[] arrayTaskList;
    /**
     * the number of tasks stored in the tasks array
     */
    private int size;

    /**
     * constructor which creates a new instance of class with empty array job with 10 cells and a variable size of 0
     */
    public ArrayTaskList() {
        this.arrayTaskList = new Task[10];
        this.size = 0;
    }


    /**
     * method which add new task in array of tasks
     *
     * @param task instance of class Task that will be added to the array
     */
    public void add(Task task) {
        size++;
        if (size % 10 == 0) {

            Task[] intermediateArray = Arrays.copyOf(arrayTaskList, arrayTaskList.length);
            arrayTaskList = Arrays.copyOf(intermediateArray,arrayTaskList.length+10);
         //   intermediateArray = null;
        }
        System.out.println(arrayTaskList.length+" " + size);
if(size>0)
        arrayTaskList[size - 1] = task;
        else
    arrayTaskList[0] = task;

    }

    public int size() {
        return size;

    }

    /**
     * @param index
     * @return
     */
    public Task getTask(int index) {

        return arrayTaskList[index];
    }

    /**
     * @param task
     * @return
     */
    public boolean remove(Task task) {
        if(size>=0) {
            Task[] intermediateArr = new Task[arrayTaskList.length];
            int startCopy = 0;
            for (int i = 0; i < size; i++) {
                if (arrayTaskList[i] != null) {
                    if (!arrayTaskList[i].equals(task)) {
                        intermediateArr[i] = arrayTaskList[i];
                        startCopy = i;
                    } else {
                        startCopy = i;
                        break;

                    }
                }
            }
            for (int j = startCopy; j < size; j++) {
                System.out.println(arrayTaskList.length);
                intermediateArr[j] = arrayTaskList[j + 1];
            }


            if (startCopy == -1)
                return false;
            else {
                arrayTaskList = Arrays.copyOf(intermediateArr, intermediateArr.length);
                intermediateArr = null;
                size--;
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayTaskList tasks = (ArrayTaskList) o;

        if (size != tasks.size) return false;

        return Arrays.equals(arrayTaskList, tasks.arrayTaskList);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arrayTaskList);
        result = 31 * result + size;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "arrayTaskList=" + Arrays.toString(arrayTaskList) +
                ", size=" + size +
                '}';
    }
}

