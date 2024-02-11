package br.com.marcelocesar.WorkFlowJavaSpring.component.console;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Node;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Context;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.NodeService;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Step;

public class ConsoleNode implements Step {

    @Override
    public Context process(Flow flow, Node node, Context context) {
        ConsoleData data = node.getData();
    
        String text = NodeService.setValues(data.getMessage(), context);
        System.out.println(text);
        
        NodeService.setNextNode(flow, node, context, "output_1");
        return context;
    }
    
}
