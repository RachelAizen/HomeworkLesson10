import org.openqa.selenium.By;

public class WebCalculator{

    public static void Five()
    {DriverSingleton.getDriverInstance().findElement(By.id("five")).click();}

    public static void Plus()
    {DriverSingleton.getDriverInstance().findElement(By.id("add")).click();}

    public static void Equals()
    {DriverSingleton.getDriverInstance().findElement(By.id("equal")).click();}

    public static String Result()
    {return DriverSingleton.getDriverInstance().findElement(By.id("screen")).getText();}
}
