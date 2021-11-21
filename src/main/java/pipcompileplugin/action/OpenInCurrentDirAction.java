package pipcompileplugin.action;

import com.google.common.base.Joiner;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class OpenInCurrentDirAction  extends AnAction {

    public void actionPerformed(AnActionEvent e) {

        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);

        OpenInTerminalSettingsState openInTerminalSettingsState = OpenInTerminalSettings.getInstance().getState();

        if (openInTerminalSettingsState != null) {

            String directoryPath = getPath(file);

            String openTerminalCmd = Joiner.on(" ").join(
                    openInTerminalSettingsState.getTerminalCommand(),
                    openInTerminalSettingsState.getTerminalCommandOptions(),
                    directoryPath);
            try {
                Runtime.getRuntime().exec(openTerminalCmd);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
//            catch (IOException e1) {
//                notifyAboutIncorrectOptions(openInTerminalSettingsState);
//            }
        } else {
            System.out.println("todo");
//            notifyAboutUnsetOptions();
        }
    }

    @NotNull
    protected String getPath(VirtualFile file) {
        return file.isDirectory() ? file.getPath() : file.getParent().getPath();
    }

    @Override
    public void update(AnActionEvent e) {
        e.getPresentation().setVisible(e.getData(CommonDataKeys.VIRTUAL_FILE) != null);
//        e.getPresentation().setIcon(AllIcons.General.Information);
    }

//    protected void notifyAboutIncorrectOptions(OpenInTerminalSettingsState openInTerminalSettingsState) {
//        Notifications.Bus.notify(new Notification(NOTIFICATION_DISPLAY_ID, NOTIFICATION_TITLE,
//                String.format(ERROR_DURING_OPENING_TERMINAL_MESSAGE,
//                        openInTerminalSettingsState.getTerminalCommand(),
//                        openInTerminalSettingsState.getTerminalCommandOptions()),
//                NotificationType.ERROR));
//    }

//    protected void notifyAboutUnsetOptions() {
//        Notifications.Bus.notify(new Notification(NOTIFICATION_DISPLAY_ID, NOTIFICATION_TITLE,
//                OPTIONS_NOT_PROVIDED_MESSAGE,
//                NotificationType.WARNING));
//    }
}