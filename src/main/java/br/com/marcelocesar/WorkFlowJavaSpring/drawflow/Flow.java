package br.com.marcelocesar.WorkFlowJavaSpring.drawflow;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flow {
	private Map<String, FlowPage> drawflow;
}
