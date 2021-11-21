package pipcompileplugin.action;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OpenInTerminalSettingsConfigurable implements Configurable {

    private OpenInTerminalSettingsForm openInTerminalSettingsForm;

    private OpenInTerminalSettings openInTerminalSettings;

    public OpenInTerminalSettingsConfigurable() {
        this.openInTerminalSettingsForm = new OpenInTerminalSettingsForm();
        this.openInTerminalSettings = OpenInTerminalSettings.getInstance();
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "OpenInTerminal";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return openInTerminalSettingsForm.getSettingsPanel();
    }

    @Override
    public boolean isModified() {
        return !openInTerminalSettingsForm.getSettingsState().equals(openInTerminalSettings.getState());
    }

    @Override
    public void apply() throws ConfigurationException {
        openInTerminalSettings.loadState(openInTerminalSettingsForm.getSettingsState());
    }

    @Override
    public void reset() {
        if(openInTerminalSettings.getState() != null) {
            openInTerminalSettingsForm.setSettingsState(openInTerminalSettings.getState());
        }
    }

    @Override
    public void disposeUIResources() {

    }
}
