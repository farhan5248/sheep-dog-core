package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.common.TestObjectIDE;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListProposalsPopup;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsPopupImpl extends TestObjectIDE implements ListProposalsPopup {

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(TestObject.listProposalsDialog.isEmpty());
        return "";
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObject.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and value: ").append(keyMap.get("Proposal Value"));
        sb.append(listToString(TestObject.listProposalsDialog));
        Assertions.fail(sb.toString());
        return "";
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObject.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and description: ").append(replaceKeyword(keyMap.get("Proposal Description")));
        sb.append(listToString(TestObject.listProposalsDialog));
        Assertions.fail(sb.toString());
        return "";
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObject.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(listToString(TestObject.listProposalsDialog));
        Assertions.fail(sb.toString());
        return "";
    }

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return "";
    }

}
