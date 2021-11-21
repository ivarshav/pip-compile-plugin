package pipcompileplugin.action;

import com.intellij.openapi.components.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "OpenInTerminalSettings",
        storages = @Storage("openinterminal.xml")
)
public class OpenInTerminalSettings implements PersistentStateComponent<OpenInTerminalSettingsState> {

    private OpenInTerminalSettingsState openInTerminalSettingsState = new OpenInTerminalSettingsState();

    public static OpenInTerminalSettings getInstance() {
        return ServiceManager.getService(OpenInTerminalSettings.class);
    }

    @Nullable
    @Override
    public OpenInTerminalSettingsState getState() {
        return openInTerminalSettingsState;
    }

    @Override
    public void loadState(@NotNull OpenInTerminalSettingsState state) {
        openInTerminalSettingsState = state;
    }
}