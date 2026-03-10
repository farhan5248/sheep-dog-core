package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.common.TestObjectIDE;
import org.farhan.objects.xtext.ValidateAnnotation;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateAnnotationImpl extends TestObjectIDE implements ValidateAnnotation {

	@Override
	public String getEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(TestObject.validateDialog.isEmpty());
		return "";
	}

	@Override
	public String getContent(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Content"), TestObject.validateDialog);
		return TestObject.validateDialog;
	}

	@Override
	public void setEmpty(HashMap<String, String> keyMap) {
		TestObject.validateDialog = replaceKeyword("empty");
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		TestObject.validateDialog = keyMap.get("Content");
	}

	@Override
	public String getSetAsFollows(HashMap<String, String> keyMap) {
		return "";
	}

	@Override
	public void setSetAsFollows(HashMap<String, String> keyMap) {
	}
}
