package br.com.marcelocesar.WorkFlowJavaSpring.workflow;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.FlowPage;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Node;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.NodeOutput;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.OutputConnection;

public class NodeService {
    public static Node getStartNode(Flow flow){
        for (Map.Entry<String, FlowPage> entry : flow.getMap().entrySet()) {
            FlowPage page = entry.getValue();

            for (Map.Entry<String, Node> nodeItem : page.getMap().entrySet()) {
                Node node = nodeItem.getValue();
                if(node.getInputs().size() == 0){
                    return node;
                }
            }
        }
        return null;
    }
    public static Node getNextNode(Context context){
        Node node = context.get("NextNode");
        if(node != null){
            context.remove("NextNode");
        }
        return node;
    }
    public static Node getNextNode(Flow flow, OutputConnection outputConnection){
        for (Map.Entry<String, FlowPage> entry : flow.getMap().entrySet()) {
            FlowPage page = entry.getValue();

            for (Map.Entry<String, Node> nodeItem : page.getMap().entrySet()) {
                Node node = nodeItem.getValue();
                if(node.getId() == outputConnection.getNode()){
                    return node;
                }
            }
        }
        return null;        
    }

    public static Context setNextNode(Flow flow,Node node,Context context,String outputKey){
        if(node.getOutputs().size()>0){
            NodeOutput output = node.getOutputs().get(outputKey);
            if(output != null && output.getOutputs().size()>0){
                context.put("NextNode", getNextNode(flow,output.getOutputs().get(0)));
            }
        }
        return context;
    }
    public static String setValues(String text,Context context){
        String pattern = "\\{\\{([^}]+)\\}\\}";
        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(text);
        while (matcher.find()) {
            String matchValue = matcher.group(0);
            String groupValue = matcher.group(1);
            String replacement = context.get(groupValue);
            text = text.replace(matchValue, replacement);
        }
        return text;
    }
}
