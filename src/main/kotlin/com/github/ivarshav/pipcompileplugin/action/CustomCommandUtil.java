package com.github.ivarshav.pipcompileplugin.action;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.Nullable;

public class CustomCommandUtil {
    public static final String DISPLAY_NAME = "CustomCommand";
    public static final String CUSTOM_CONSOLE = "CustomConsole";

    @Nullable
    static Content getConsoleViewContent(Project project) {

        if (project == null) {
            return null;
        }
        ToolWindow toolWindow = ToolWindowManager.getInstance(project).getToolWindow(CUSTOM_CONSOLE);

        if (toolWindow == null) {
            return null;
        }
        Content consoleViewContent = getExistingConsoleViewContent(toolWindow);
        if (consoleViewContent != null) {
            return consoleViewContent;
        }

        // Create a new consoleView if it does not exist
        ConsoleView consoleView = TextConsoleBuilderFactory.getInstance().createBuilder(project).getConsole();
        Content newConent =
                toolWindow.getContentManager().getFactory().createContent(consoleView.getComponent(), DISPLAY_NAME, true);
        toolWindow.getContentManager().addContent(newConent);

        return newConent;
    }

    @Nullable
    static Content getExistingConsoleViewContent(ToolWindow toolWindow) {
        ContentManager contentManager = toolWindow.getContentManager();
        return contentManager.findContent(DISPLAY_NAME);
    }

    static void activateConsoleView(Project project) {
        Content content = getConsoleViewContent(project);
        ToolWindow toolWindow = getToolWindow(project);
        if (content != null && toolWindow != null) {
            toolWindow.show();
            toolWindow.getContentManager().setSelectedContent(content);
        }
    }

    @Nullable
    static ToolWindow getToolWindow(Project project) {
        if (project == null || project.isDisposed()) {
            return null;
        }
        return ToolWindowManager.getInstance(project).getToolWindow(CUSTOM_CONSOLE);
    }
}