package br.com.marcelocesar.WorkFlowJavaSpring.component.httpRequest;

public class HttpRequestData {
    private String url;
    private String method;
    private String outputStatus;
    private String outputContentType;
    private String outputContent;
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getOutputStatus() {
        return outputStatus;
    }
    public void setOutputStatus(String outputStatus) {
        this.outputStatus = outputStatus;
    }
    public String getOutputContentType() {
        return outputContentType;
    }
    public void setOutputContentType(String outputContentType) {
        this.outputContentType = outputContentType;
    }
    public String getOutputContent() {
        return outputContent;
    }
    public void setOutputContent(String outputContent) {
        this.outputContent = outputContent;
    }
    public HttpRequestData(String url, String method, String outputStatus, String outputContentType, String outputContent){
        this.url = url;
        this.method = method;
        this.outputStatus = outputStatus;
        this.outputContentType = outputContentType;
        this.outputContent = outputContent;
    }
}
