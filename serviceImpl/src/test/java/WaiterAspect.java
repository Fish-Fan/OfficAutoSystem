import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WaiterAspect {
    @AfterReturning(value = "target(com.fanyank.service.NaiveWaiter)")
    public void afterGreet() {
        System.out.println("after()======");
    }
}
