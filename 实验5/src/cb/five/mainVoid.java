package cb.five;

/**
 * Created by cb on 16-11-17.
 */
public class mainVoid {
    public static void main(String[] args){
        studentC sc=new studentC();
        sc.putWork("studentC:");
        //多态的实现

        //向上转型
        studentC scj=new studentJ();
        scj.putWork("studentJ:");
        //向下转型
        studentJ sjc=(studentJ) scj;
        sjc.findError();
    }
}
