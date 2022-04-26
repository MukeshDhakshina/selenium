package sample_testNG;

import org.testng.annotations.Test;

public class SampleTestCase {

    @Test (priority=0)
	public void FirstTestCase(){
		System.out.println("First Test case");
	}
    @Test (priority=1)
	public void SecondTestCase(){
		System.out.println("Second Test case");
	}
    @Test (priority=2)
	public void ThirdTestCase(){
		System.out.println("Third Test Case");
	}
    @Test (priority=3)
	public void FourthTestCase(){
		System.out.println("Fourth Test Case");
	}
}
