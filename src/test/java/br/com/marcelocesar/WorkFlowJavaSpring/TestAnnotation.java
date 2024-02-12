package br.com.marcelocesar.WorkFlowJavaSpring;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import br.com.marcelocesar.WorkFlowJavaSpring.annotation.SampleAnnotation;

@SpringBootTest
public class TestAnnotation {
	@Test
	public void testAnnotation() throws ClassNotFoundException {
		Class<?> clazz = ClassLoader.getSystemClassLoader()
				.loadClass("br.com.marcelocesar.WorkFlowJavaSpring.component.SampleAnnotatedClass");
		SampleAnnotation classAnnotation = clazz.getAnnotation(SampleAnnotation.class);
		Assertions.assertThat(classAnnotation.name()).isEqualTo("SampleAnnotatedClass");
		Method[] methods = clazz.getMethods();
		List<String> annotatedMethods = new ArrayList<>();
		for (Method method : methods) {
			SampleAnnotation annotation = method.getAnnotation(SampleAnnotation.class);
			if (annotation != null) {
				annotatedMethods.add(annotation.name());
			}
		}
		Assertions.assertThat(annotatedMethods.size()).isEqualTo(1);
		Assertions.assertThat(annotatedMethods.get(0)).isEqualTo("annotatedMethod");
	}

	@Test
	public void testAnnotation2() throws ClassNotFoundException {
		ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
		provider.addIncludeFilter(new AnnotationTypeFilter(SampleAnnotation.class));

		Set<BeanDefinition> beanDefs = provider.findCandidateComponents("br.com.marcelocesar.WorkFlowJavaSpring");
		List<String> annotatedBeans = new ArrayList<>();
		for (BeanDefinition bd : beanDefs) {
			if (bd instanceof AnnotatedBeanDefinition) {
				Map<String, Object> annotAttributeMap = ((AnnotatedBeanDefinition) bd).getMetadata()
						.getAnnotationAttributes(SampleAnnotation.class.getCanonicalName());
				annotatedBeans.add(annotAttributeMap.get("name").toString());
			}
		}
		Assertions.assertThat(annotatedBeans.size()).isEqualTo(1);
		Assertions.assertThat(annotatedBeans.get(0)).isEqualTo("SampleAnnotatedClass");
	}
	@Test
	public void testAnnotation3() throws ClassNotFoundException {
		Reflections reflections = new Reflections("br.com.marcelocesar.WorkFlowJavaSpring");
		Set<Method> methods = reflections
				  .getMethodsAnnotatedWith(SampleAnnotation.class);
				List<String> annotatedMethods = methods.stream()
				  .map(method -> method.getAnnotation(SampleAnnotation.class)
				  .name())
				  .collect(Collectors.toList());
				Assertions.assertThat(annotatedMethods.size()).isEqualTo(1);
				Assertions.assertThat(annotatedMethods.get(0)).isEqualTo("annotatedMethod");
		Set<Class<?>> types = reflections
				  .getTypesAnnotatedWith(SampleAnnotation.class);
				List<String> annotatedClasses = types.stream()
				  .map(clazz -> clazz.getAnnotation(SampleAnnotation.class)
				  .name())
				  .collect(Collectors.toList());
				Assertions.assertThat(annotatedClasses.size()).isEqualTo(1);
				Assertions.assertThat(annotatedClasses.get(0)).isEqualTo("SampleAnnotatedClass");	
	}
}
