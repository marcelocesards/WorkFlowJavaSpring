package br.com.marcelocesar.WorkFlowJavaSpring.workflow;
import java.util.HashMap;
import java.util.Map;

import br.com.marcelocesar.WorkFlowJavaSpring.component.console.ConsoleNode;
import br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest.HttpRequestNode;

public class NodeSteps {
    private Map<String, Object> map = new HashMap<>();
    
    public NodeSteps(){
        map.put("HttpRequestNode", new HttpRequestNode());
        map.put("ConsoleNode", new ConsoleNode());
    }
    Step getStep(String name){
        return (Step)map.get(name);
    }
}
