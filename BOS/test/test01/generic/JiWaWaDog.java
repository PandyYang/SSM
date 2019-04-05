package test01.generic;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class JiWaWaDog extends Dog<String, Integer> {

	
	public JiWaWaDog() {
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
				ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
				
				Type[] types = genericSuperclass.getActualTypeArguments();
				
				System.out.println(types[0]);
				System.out.println(types[1]);
	}
}

