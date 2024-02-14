package br.com.marcelocesar.WorkFlowJavaSpring.workflow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.marcelocesar.WorkFlowJavaSpring.component.console.ConsoleNode;
import br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest.HttpRequestNode;
import jakarta.annotation.PostConstruct;

@Component
public class NodeSteps {
    private Map<String, Object> map = new HashMap<>();
    
    @Autowired(required = false)
    private List<Step> steps = new ArrayList<>();
    
    @PostConstruct
    public void NodeStepsStart() {
    	steps.forEach(step->{
    		map.put(step.getClass().getSimpleName(), step);
    	});
        map.put("HttpRequestNode", new HttpRequestNode());
        map.put("ConsoleNode", new ConsoleNode());
    }
    
    Step getStep(String name){
        return (Step)map.get(name);
    }
}
