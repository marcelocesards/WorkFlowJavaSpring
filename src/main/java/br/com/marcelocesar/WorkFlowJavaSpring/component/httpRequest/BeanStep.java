package br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Node;
import br.com.marcelocesar.WorkFlowJavaSpring.exception.httpRequest.StepMethodException;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Context;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeanStep implements Step{
	
	private Object bean;
	private String methodExecutor;
	private String beanName;

    @Override
    public Context process(Flow flow, Node node, Context context) {
    /*	Map<String, Object> datateste =  node.getData();
    	ObjectMapper mapper = new ObjectMapper();
    	HttpRequestData data = mapper.convertValue(datateste, HttpRequestData.class);*/
    	
    	try {
			bean.getClass().getMethod(this.beanName, Flow.class, Node.class, Context.class)
			.invoke(flow, node, context);
		} catch (Exception e) {
			throw new StepMethodException(String.format("Error to execute bean [%s] method [%s]", beanName, methodExecutor));
		}
        return context;
    }
}
