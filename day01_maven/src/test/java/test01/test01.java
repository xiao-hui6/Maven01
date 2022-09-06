package test01;


import com.test01.User;
import org.junit.Test;


/**
 * @author shkstart
 * @create 2022-09-05 10:31
 */
public class test01 {
    @Test
    public void test(){
        User tom = new User("tom", 19);
        System.out.println(tom);
        System.out.println("hot-fix hello");
        System.out.println("master hello");
        System.out.println("hot-fix 2");
        System.out.println("hhhhhh 1");
        System.out.println("hhhhhh 2");
    }
}
