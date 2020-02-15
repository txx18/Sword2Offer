package others.e10;

import org.junit.Test;

/**
 * @author Shane Tang
 * @create 2019-10-07 21:51
 */
public class E10Test {

    @Test
    public void testFibonacci(){
        Fibonacci obj = new Fibonacci();
        int res1 = obj.getNItemByRecursion(3);
        System.out.println("res1 = " + res1);
        int res2 = obj.getNItemByLoop(3);
        System.out.println("res2 = " + res2);
//        Assert.assertEquals(2, res1);
////        Assert.assertEquals(2, res2);
    }

    @Test
    public void testFrog(){
        FrogJumpSteps obj = new FrogJumpSteps();
        int res1 = obj.frogByRecursion(3);
        System.out.println("res1 = " + res1);
        int res2 = obj.frogByLoop(3);
        System.out.println("res2 = " + res2);
//        Assert.assertEquals(3, res1);
//        Assert.assertEquals(3, res2);
    }

    @Test
    public void testRectangleCover(){
        RectangleCover obj = new RectangleCover();
        int res = obj.rectangleCoverByRecur(4);
        System.out.println("res = " + res);
    }
}
