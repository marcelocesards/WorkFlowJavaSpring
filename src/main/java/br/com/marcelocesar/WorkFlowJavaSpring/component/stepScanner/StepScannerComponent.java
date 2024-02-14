package br.com.marcelocesar.WorkFlowJavaSpring.component.stepScanner;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.jboss.jandex.AnnotationInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StepScannerComponent {
	
	@Autowired
	private StepAnnotatinInstanceComponent stepAnnotatinInstanceComponent;
	
	public Map<String, Object> getAllSteps() throws IOException {
		return stepAnnotatinInstanceComponent.getStepBeans();
	}
}
