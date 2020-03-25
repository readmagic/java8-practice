package oop.fun.practice.ch3;

/**
 * 6. 计算一个字符串中小写字母的个数（提示：参阅 String 对象的 chars 方法）。
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-11-13
 * Time: 下午4:15
 */
public class Sex {

    public static void main(String[] args) {
        String str = "dsadsadsaADSADSAcsxadfsadsaAs";
        long z=  str.chars().filter(x->x>=97 && x<=122).count();
        System.out.println(z);

    }
}
