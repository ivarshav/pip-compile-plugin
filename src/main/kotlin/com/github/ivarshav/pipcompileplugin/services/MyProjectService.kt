package com.github.ivarshav.pipcompileplugin.services

import com.intellij.openapi.project.Project
import com.github.ivarshav.pipcompileplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
