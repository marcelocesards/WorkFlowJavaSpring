package br.com.marcelocesar.WorkFlowJavaSpring.drawflow;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    private String id;
    private String name;
	private Object data;   
    private String className;
    private String html;
    private String typenode;
    private Map<String, InputOutput> inputs;
    private Map<String, InputOutput> outputs;
    private int posX;
    private int posY;
         
	@SuppressWarnings("unchecked")
    public <T> T getData() {
        return (T)data;
    }
}
