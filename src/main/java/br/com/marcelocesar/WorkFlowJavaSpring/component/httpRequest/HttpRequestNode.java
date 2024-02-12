package br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Flow;
import br.com.marcelocesar.WorkFlowJavaSpring.drawflow.Node;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Context;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.NodeService;
import br.com.marcelocesar.WorkFlowJavaSpring.workflow.Step;

public class HttpRequestNode implements Step{

    @Override
    public Context process(Flow flow, Node node, Context context) {
    	Map<String, Object> datateste =  node.getData();
    	ObjectMapper mapper = new ObjectMapper();
    	HttpRequestData data = mapper.convertValue(datateste, HttpRequestData.class);
        URL url;
        try {
            url = new URL(data.getUrl());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(data.getMethod());

            int statusCode = con.getResponseCode();
            context.put(data.getOutputStatus(), statusCode);
            context.put(data.getOutputContentType(), con.getContentType());
            
            if(statusCode>= 200 && statusCode <300){
                BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();       
                context.put(data.getOutputContent(), content.toString());        
                NodeService.setNextNode(flow, node, context, "output_1");
            }
            else{
                NodeService.setNextNode(flow, node, context, "output_2");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return context;
    }
}
