package pipcompileplugin.action;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.Editor;

public class CustomActionGroup extends DefaultActionGroup {

    public CustomActionGroup() {
        super();
        getTemplatePresentation().setText("Pip compile");
        getTemplatePresentation().setVisible(true);
    }

    @Override
    public void update(AnActionEvent event) {
        // Take this opportunity to set an icon for the group.
        event.getPresentation().setIcon(AllIcons.General.Information);
    }
}