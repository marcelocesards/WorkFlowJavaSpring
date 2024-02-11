package br.com.marcelocesar.WorkFlowJavaSpring.component.console;

public class ConsoleData {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public ConsoleData(String message){
        this.message = message;
    }
}
