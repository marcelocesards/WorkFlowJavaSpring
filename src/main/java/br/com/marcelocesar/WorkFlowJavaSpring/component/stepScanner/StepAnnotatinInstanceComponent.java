package br.com.marcelocesar.WorkFlowJavaSpring.component.stepScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import br.com.marcelocesar.WorkFlowJavaSpring.annotation.Step;

@Component
public class StepAnnotatinInstanceComponent {	
    @Value("classpath:META-INF/jandex.idx")
    private Resource appFile;
    @Autowired
    private BeanFactory beanfactory;
    @Autowired
    GenericApplicationContext applicationContext;
    
	public Map<String, Object> getStepBeans() {
		Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Step.class);
		return beansWithAnnotation;
	}

	public List<Object> findBeansWithStepAnnotation() {
        List<Object> beansWithStepAnnotation = new ArrayList<>();

        // Get all beans from the ApplicationContext
        Map<String, Object> beansMap = applicationContext.getBeansWithAnnotation(Component.class);

        // Iterate over all beans
        for (Object bean : beansMap.values()) {
            Class<?> beanClass = bean.getClass();

            // Iterate over all methods of the bean
            for (Method method : beanClass.getMethods()) {
                // Check if the method is annotated with @Step
                if (method.isAnnotationPresent(Step.class)) {
                    beansWithStepAnnotation.add(bean);
                    break; // No need to check other methods of this bean
                }
            }
        }

        return beansWithStepAnnotation;
    }
}
