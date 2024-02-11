package br.com.marcelocesar.WorkFlowJavaSpring.drawflow;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeInput {
	private List<InputConnection> inputs = new ArrayList<>();
}
