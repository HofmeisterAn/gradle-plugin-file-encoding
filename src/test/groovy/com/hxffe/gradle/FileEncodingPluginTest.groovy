package com.hxffe.gradle

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.testkit.runner.BuildResult
import org.gradle.testkit.runner.GradleRunner
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

import static org.gradle.testkit.runner.TaskOutcome.*

class FileEncodingPluginTest {
	private final String pluginId = "com.hxffe.gradle.file-encoding"

	private class BuildFile {
		final private URI resource = getClass().getResource("build.gradle").toURI()

		File getBuildFile() {
			return new File(resource)
		}

		File getRootPath() {
			return new File(resource).getParentFile()
		}
	}

	private BuildFile buildFile

	@Before
	void setup() {
		this.buildFile = new BuildFile()
	}

	@Test
	void fileEncodingPluginAddsFileEncodingTaskToProject() {
		Project project = ProjectBuilder.builder().build()
		project.pluginManager.apply this.pluginId

		assertTrue(project.tasks.convert instanceof FileEncodingTask)
	}

	@Test
	void fileEncodingPluginTestsFileEncodingTaskConvert() {
		BuildResult result = GradleRunner.create()
				.withProjectDir(buildFile.rootPath)
				.withArguments(FileEncodingTask.taskName)
				.build()

		assertEquals(SUCCESS, result.task(":${FileEncodingTask.taskName}").getOutcome())
	}
}
