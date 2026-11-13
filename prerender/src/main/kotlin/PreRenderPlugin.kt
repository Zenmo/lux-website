package energy.lux.prerender

import energy.lux.prerender.persistence.PerDomainDiskPagePersistence
import org.gradle.api.Plugin
import org.gradle.api.Project

class PreRenderPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register("preRender", PreRenderTask::class.java) { task ->
            task.urls.convention(listOf("http://localhost:8080"))
            task.outputDir.set(target.layout.buildDirectory.dir("preRender"))
            task.persistence.set(PerDomainDiskPagePersistence(task.outputDir.get()))
            task.group = "preRender"
            task.description = "Pre-renders HTML"
        }
    }
}
