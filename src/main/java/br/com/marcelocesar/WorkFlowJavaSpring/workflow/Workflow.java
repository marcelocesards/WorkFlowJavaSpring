package br.com.marcelocesar.WorkFlowJavaSpring.workflow;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Node;

@Component
public class Workflow {
	
	@Autowired
    private NodeSteps nodeSteps;
	
    public Workflow(){
    }

    public Context run(Flow flow){
        Context context = new Context();
        context.put("Flow", flow);
        return processNext(flow, context);
    }
    
    public Context run(Flow flow, Map<String,Object> input){
        Context context = new Context();
        context.put("Flow", flow);
        input.forEach((key,value)-> context.put(key, value));
        
        return processNext(flow, context);
    }
    
    private Context processNext(Flow flow, Context context){
        Node node = NodeService.getStartNode(flow);
        
        while (node != null) {
            context = nodeSteps.getStep(node.getName()).process(flow, node, context);
            node = NodeService.getNextNode(context);
        }
        return context;
    }
}
