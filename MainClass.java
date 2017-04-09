
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainClass {
	
	
	public static void main(String args[]) throws IllegalArgumentException, IntrospectionException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException
	{
		FinanceSheetFilter financeSheetFilter = new FinanceSheetFilter();
		financeSheetFilter.setCountryNames("India");
		
		boolean condition = getConditionCreated(financeSheetFilter,"countryNames");
		
		System.out.println(condition);
	}

	private static boolean getConditionCreated(Object obj , String attributeName) throws IntrospectionException, IllegalArgumentException, IllegalAccessException,
	InvocationTargetException, SecurityException {
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(attributeName, obj.getClass());
		Method getter = propertyDescriptor.getReadMethod();
		
		Object value = getter.invoke(obj);
		
		return (value != null && !value.toString().isEmpty());
		
	}

}
