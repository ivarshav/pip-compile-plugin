package com.github.ivarshav.pipcompileplugin.action;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static com.github.ivarshav.pipcompileplugin.action.CustomCommandUtil.getConsoleViewContent;
import static com.github.ivarshav.pipcompileplugin.action.CustomCommandUtil.activateConsoleView;

public class CommandLineAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }
        ArrayList<String> cmds = new ArrayList<>();
        cmds.add("echo hello");
        GeneralCommandLine commandLine = new GeneralCommandLine(cmds);
        commandLine.setCharset(StandardCharsets.UTF_8);
        commandLine.setWorkDirectory(project.getBasePath());
        // One way to create the process and run it
        // Simply create a process from commandline which will start the process
        /*
        try {
            commandLine.createProcess();
        } catch (ExecutionException exception) {
            exception.printStackTrace();
        }
         */

        // Second way to create the process is using the ProcessHandler
        ProcessHandler processHandler = null;
        try {
            processHandler = new OSProcessHandler(commandLine);
        } catch (ExecutionException exception) {
            exception.printStackTrace();
        }
        assert processHandler != null : "Process Handler should not be null";

        /*
        To monitor the execution of a process and capture its output,
        the OSProcessHandler class is usually used.
        Once you’ve created an instance of OSProcessHandler from either a command line or a Process object,
        you need to call the startNotify() method to capture its output.
         */
        processHandler.startNotify();

        activateConsoleView(project);
        // Create a consoleView
        Content content = getConsoleViewContent(project);
        assert content != null;
        ConsoleView console = (ConsoleView) (content.getComponent());

        // Created GeneralCommandLine

        // Create ProcessHandler

        // Attach the console to the processHandler
        console.attachToProcess(processHandler);

        processHandler.startNotify();
    }

    @Override
    public boolean isDumbAware() {
        return true;
    }
}