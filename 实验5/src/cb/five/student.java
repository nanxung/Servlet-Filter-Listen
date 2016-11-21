package cb.five;

/**
 * Created by cb on 16-11-17.
 */
public class student {
    private teacher teacher;
    public student(teacher t){
        this.teacher=t;
    }
    public void doWork(String say){
        System.out.println(say+"作业写完了！！");
        teacher.checkHomeWork();
    }
}
