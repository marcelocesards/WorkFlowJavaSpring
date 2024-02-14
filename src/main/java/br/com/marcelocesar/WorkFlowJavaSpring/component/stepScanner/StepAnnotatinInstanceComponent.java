package br.com.marcelocesar.WorkFlowJavaSpring.component.stepScanner;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import br.com.marcelocesar.WorkFlowJavaSpring.annotation.Step;
import br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest.BeanStep;

@Component
public class StepAnnotatinInstanceComponent {	

	@Autowired
    private GenericApplicationContext applicationContext;
    
	public Map<String, Object> getStepBeans() {
		Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Step.class);
		return beansWithAnnotation;
	}

	public List<BeanStep> findBeansWithStepAnnotation() {
        List<Object> beansWithStepAnnotation = new ArrayList<>();
        List<BeanStep> beanSteps = new ArrayList<>();

        // Get all beans from the ApplicationContext
      //  Map<String, Object> beansMap = applicationContext.getBeansWithAnnotation(Component.class);
        Map<String, Object> beansMap = applicationContext.getBeansWithAnnotation(Step.class);
        
        for (Map.Entry<String, Object> entry : beansMap.entrySet()) {
			String beanName = entry.getKey();
			Object bean = entry.getValue();
			
			 Class<?> beanClass = bean.getClass();

            // Iterate over all methods of the bean
            for (Method method : beanClass.getMethods()) {
                // Check if the method is annotated with @Step
                if (method.isAnnotationPresent(Step.class)) {
                	beanSteps.add(BeanStep
                			.builder()
                			.bean(bean)
                			.methodExecutor(method.getName())
                			.beanName(beanName)
                			.build());
                    beansWithStepAnnotation.add(bean);
                    break; // No need to check other methods of this bean
                } 
                if("process".equals(method.getName())) {
            		beanSteps.add(BeanStep
                			.builder()
                			.bean(bean)
                			.methodExecutor(method.getName())
                			.beanName(beanName)
                			.build());
                    beansWithStepAnnotation.add(bean);
                    break; // No need to check other methods of this bean
                }
            }
		}
        return beanSteps;
    }
}
