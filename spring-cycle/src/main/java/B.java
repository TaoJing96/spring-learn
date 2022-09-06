import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jing Tao
 * @date 2022/9/5 18:22
 */
@Component
public class B {

	@Autowired
	private A a;
}
