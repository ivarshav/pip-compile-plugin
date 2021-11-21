package pipcompileplugin.action;

public class OpenInTerminalSettingsState {
    private String terminalCommand;

    private String terminalCommandOptions;

    public OpenInTerminalSettingsState() {
    }

    public OpenInTerminalSettingsState(String terminalCommand, String terminalCommandOptions) {
        this.terminalCommand = terminalCommand;
        this.terminalCommandOptions = terminalCommandOptions;
    }

    public String getTerminalCommand() {
        return terminalCommand;
    }

    public void setTerminalCommand(String terminalCommand) {
        this.terminalCommand = terminalCommand;
    }

    public String getTerminalCommandOptions() {
        return terminalCommandOptions;
    }

    public void setTerminalCommandOptions(String terminalCommandOptions) {
        this.terminalCommandOptions = terminalCommandOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpenInTerminalSettingsState that = (OpenInTerminalSettingsState) o;

        if (!terminalCommand.equals(that.terminalCommand)) return false;
        return terminalCommandOptions.equals(that.terminalCommandOptions);

    }

    @Override
    public int hashCode() {
        int result = terminalCommand.hashCode();
        result = 31 * result + terminalCommandOptions.hashCode();
        return result;
    }
}
