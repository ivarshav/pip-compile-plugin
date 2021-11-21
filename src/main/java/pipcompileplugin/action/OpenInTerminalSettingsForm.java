package pipcompileplugin.action;

import javax.swing.*;

public class OpenInTerminalSettingsForm {
    private JTextField terminalCommand;

    private JTextField terminalCommandOptions;

    private JPanel settingsPanel;

    public JPanel getSettingsPanel() {
        return settingsPanel;
    }

    public OpenInTerminalSettingsState getSettingsState() {
        return new OpenInTerminalSettingsState(terminalCommand.getText(), terminalCommandOptions.getText());
    }

    public void setSettingsState(OpenInTerminalSettingsState settingsState) {
        terminalCommand.setText(settingsState.getTerminalCommand());
        terminalCommandOptions.setText(settingsState.getTerminalCommandOptions());
    }
}
