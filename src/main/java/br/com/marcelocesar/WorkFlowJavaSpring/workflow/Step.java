package br.com.marcelocesar.WorkFlowJavaSpring.workflow;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Node;

public interface Step {
    Context process(Flow flow, Node node,Context context);
}
