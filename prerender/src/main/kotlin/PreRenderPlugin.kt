package energy.lux.prerender

import energy.lux.prerender.persistence.PerDomainDiskPagePersistence
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.register

class PreRenderPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.tasks.register<PreRenderTask>("preRender") {
            entryPointUrl.set("http://localhost:8080")
            outputDir.set(project.layout.buildDirectory.dir("preRender"))
            persistence.set(PerDomainDiskPagePersistence(outputDir.get()))
            group = "preRender"
            description = "Pre-renders HTML"
        }
    }
}
