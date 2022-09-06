import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jing Tao
 * @date 2022/9/5 18:21
 */
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getBean(A.class).say();
	}
}
