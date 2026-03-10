package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.common.TestObjectIDE;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesPopup;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesPopupImpl extends TestObjectIDE implements ListQuickfixesPopup {

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(TestObject.listQuickfixesDialog.isEmpty());
        return listToString(TestObject.listQuickfixesDialog);
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObject.listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return p.getValue().toString();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and value: ").append(keyMap.get("Proposal Value"));
        sb.append(listToString(TestObject.listQuickfixesDialog));
        Assertions.fail(sb.toString());
        return "";
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObject.listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return p.getDescription();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and description: ").append(keyMap.get("Proposal Description"));
        sb.append(listToString(TestObject.listQuickfixesDialog));
        Assertions.fail(sb.toString());
        return "";
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObject.listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return p.getId();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(listToString(TestObject.listQuickfixesDialog));
        Assertions.fail(sb.toString());
        return "";
    }

    @Override
    public void setProposalId(HashMap<String, String> keyMap) {
        TestObject.listQuickfixesDialog.add(new SheepDogIssueProposal());
        TestObject.listQuickfixesDialog.getLast().setId(keyMap.get("Proposal Id"));
    }

    @Override
    public void setProposalDescription(HashMap<String, String> keyMap) {
        TestObject.listQuickfixesDialog.getLast().setDescription(keyMap.get("Proposal Description"));
    }

    @Override
    public void setProposalValue(HashMap<String, String> keyMap) {
        TestObject.listQuickfixesDialog.getLast().setValue(keyMap.get("Proposal Value"));
    }

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return listToString(TestObject.listQuickfixesDialog);
    }

    @Override
    public void setSetAsFollows(HashMap<String, String> keyMap) {
    }

}
