package br.com.marcelocesar.WorkFlowJavaSpring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Context;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Workflow;

@RestController
@RequestMapping("/redesSociais")
public class TesteFluxoController {
	
	@PostMapping("/executar")
	public ResponseEntity<Flow> executarRedesSociais(@RequestBody() Flow fromJson) {
		Workflow workflow = new Workflow();
        Context context = workflow.run(fromJson);
        String output = context.get("http_content");
        
        System.out.println(output);    
		return ResponseEntity.ok(fromJson);
	}
	@PostMapping("/executar2")
	public void executarRedesSociais2() {
	  /*  HttpRequestData httpRequestData = new HttpRequestData("https://dog-api.kinduff.com/api/facts","GET","http_status","http_contenttype","http_content");
        ConsoleData consoleData = new ConsoleData("Dog facts: {{http_content}}");

        //create node connection
        List<OutputConnection> httpToConsole = new ArrayList<>();
        httpToConsole.add(new OutputConnection("2","input_1"));
        List<InputConnection> consoleFromHttp = new ArrayList<>();
        consoleFromHttp.add(new InputConnection("1", "output_1"));
        
        Map<String, NodeInput> httpInput = new HashMap<>();
        Map<String, NodeOutput> httpOutput = new HashMap<>();

        Map<String, NodeInput> consoleInput = new HashMap<>();
        Map<String, NodeOutput> consoleOutput = new HashMap<>();

        httpOutput.put("output_1",new NodeOutput(httpToConsole));
        consoleInput.put("input_1", new NodeInput(consoleFromHttp));

        //create node
        Node httpNode = new Node("1","HttpRequestNode",httpRequestData,"","","",httpInput,httpOutput,0,0);
        Node consoleNode = new Node("2","ConsoleNode",consoleData,"","","",consoleInput,consoleOutput,0,0);

        Map<String, Node> nodes = new HashMap<>();
        nodes.put("1", httpNode);
        nodes.put("2", consoleNode);

        //create page
        FlowPage homePage = new FlowPage(nodes);
        Map<String, FlowPage> pages = new HashMap<>();
        pages.put("Home", homePage);

        //create flow
        Flow flow = new Flow(pages);

        //execute flow
        Workflow workflow = new Workflow();
        Context context = workflow.run(flow);
        String output = context.get("http_content");
        
        System.out.println(output);    */
	}
}
