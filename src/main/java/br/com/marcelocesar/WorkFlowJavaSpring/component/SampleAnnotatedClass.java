package br.com.marcelocesar.WorkFlowJavaSpring.component;

import br.com.marcelocesar.WorkFlowJavaSpring.annotation.SampleAnnotation;

@SampleAnnotation(name = "SampleAnnotatedClass")
public class SampleAnnotatedClass {

    @SampleAnnotation(name = "annotatedMethod")
    public void annotatedMethod() {
        //Do something
    }

    public void notAnnotatedMethod() {
        //Do something
    }
}