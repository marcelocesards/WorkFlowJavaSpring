package br.com.marcelocesar.WorkFlowJavaSpring.component.console;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Node;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Context;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.NodeService;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Step;

public class ConsoleNode implements Step {

    @Override
    public Context process(Flow flow, Node node, Context context) {    
        ObjectMapper mapper = new ObjectMapper();
        Map<String, ConsoleData> data2 = node.getData();
        ConsoleData data = mapper.convertValue(data2, ConsoleData.class);
        
        
        
        String text = NodeService.setValues(data.getMessage(), context);
        System.out.println(text);
        
        NodeService.setNextNode(flow, node, context, "output_1");
        return context;
    }
    
}
