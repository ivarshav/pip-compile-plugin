package com.github.ivarshav.pipcompileplugin.action;

import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.DefaultActionGroup;

public class CustomActionGroup extends DefaultActionGroup {

    public CustomActionGroup() {
        super();
        getTemplatePresentation().setText("Pip compile");
        getTemplatePresentation().setVisible(true);
    }
}