package testng_knowledge;

import org.testng.annotations.Test;

public class _03_Ignoring_Tests {
    @Test(priority = 2, dependsOnMethods = "test2")
    public void test1(){
        System.out.println("This is test1");
    }

    @Test(priority = 3)
    public void test2(){
        System.out.println("This is test2");
    }

    @Test(priority = 1, dependsOnMethods = "test1")
    public void test3(){
        System.out.println("This is test3");
    }
}
