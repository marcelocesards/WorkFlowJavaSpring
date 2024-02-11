package br.com.marcelocesar.WorkFlowJavaSpring.drawflow;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeOutput {

    private List<OutputConnection> outputs = new ArrayList<>();

}
