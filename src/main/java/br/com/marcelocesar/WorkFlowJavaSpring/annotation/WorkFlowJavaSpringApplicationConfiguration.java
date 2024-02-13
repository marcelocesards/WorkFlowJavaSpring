package br.com.marcelocesar.WorkFlowJavaSpring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.marcelocesar.WorkFlowJavaSpring.WorkFlowJavaSpringApplication;

@ComponentScan(basePackageClasses = WorkFlowJavaSpringApplication.class)
@Configuration
public class WorkFlowJavaSpringApplicationConfiguration {
}