package br.com.marcelocesar.WorkFlowJavaSpring.drawflow;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowPage {
	private Map<String, Node> map = new HashMap<>();
}
