package Ex1.Ex1_2;

public class TestMyTime {
    public static void main(String[] args) {
//        MyTime a = new MyTime(10,59,34);
//        System.out.println(a.toString() + " one hour later is " + (a.nextHour()).toString());
//        System.out.println(a.toString() + " one minute later is " + (a.nextMinute()).toString());
//        MyTime b = new MyTime();
//
//        System.out.println("hour of " + b.toString() + " is " + b.getHour());
//        System.out.println(b.toString() + " one second before is " + (b.previousSecond()).toString());

//        MyTime c = new MyTime(22, 50, 61);
//        System.out.println(c.toString());
//        c.setSecond(88);
//        System.out.println(c.toString());
        try {
            int data = 5 / 0;
        } catch (IllegalArgumentException e) {
            //In ra màn hình tên ngoại lệ
            System.out.println(e);
        }
    }

}