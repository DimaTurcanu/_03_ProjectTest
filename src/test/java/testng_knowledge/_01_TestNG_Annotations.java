package testng_knowledge;

import org.testng.annotations.*;

public class _01_TestNG_Annotations {

    @BeforeMethod
    public void setUp(){
        System.out.println("All the pre conditions");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("All the post conditions");
    }

    @Test
    public void test1(){
        System.out.println("This is test1");
    }

    @Test
    public void test2(){
        System.out.println("This is test2");
    }

    @Test
    public void test3(){
        System.out.println("This is test3");
    }
}