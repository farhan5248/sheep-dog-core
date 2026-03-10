package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestObjectIDE;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Input2FileAsciidocFileImpl extends TestObjectIDE implements Input2FileAsciidocFile {

    @Override
    public String getStepObjectName(HashMap<String, String> keyMap) {
        assertStepObjectName(replaceKeyword(keyMap.get("Step Object Name")));
        return "";
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        Assertions.assertNotNull(cursor);
        return "";
    }
}
