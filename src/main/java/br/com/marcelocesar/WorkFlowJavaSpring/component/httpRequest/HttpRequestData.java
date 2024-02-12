package br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpRequestData {
    private String url;
    private String method;
    private String outputStatus;
    private String outputContentType;
    private String outputContent;
}
