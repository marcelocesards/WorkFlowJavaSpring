package br.com.marcelocesar.WorkFlowJavaSpring.workflow;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.marcelocesar.WorkFlowJavaSpring.component.console.ConsoleNode;
import br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest.BeanStep;
import br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest.HttpRequestNode;
import br.com.marcelocesar.WorkFlowJavaSpring.component.stepScanner.StepAnnotatinInstanceComponent;
import jakarta.annotation.PostConstruct;

@Component
public class NodeSteps {
    private Map<String, Object> map = new HashMap<>();
    
    @Autowired
    private StepAnnotatinInstanceComponent stepAnnotatinInstanceComponent;
    
    @PostConstruct
    public void NodeStepsStart() {
    	List<BeanStep> beansWithStepAnnotation = stepAnnotatinInstanceComponent.findBeansWithStepAnnotation();
    	beansWithStepAnnotation.forEach(bean->{
    		map.put(bean.getBeanName(), bean);
    	});
        map.put("HttpRequestNode", new HttpRequestNode());
        map.put("ConsoleNode", new ConsoleNode());
    }
    
    Step getStep(String name){
        return (Step)map.get(name);
    }
}
