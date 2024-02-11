package br.com.marcelocesar.WorkFlowJavaSpring.drawflow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputConnection {
    private String node;
    private String output; 
}
