package com.hxffe.gradle

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project

class FileEncodingPlugin implements Plugin<Project> {
	@Override
	void apply(Project target) {
		final NamedDomainObjectContainer<FileEncoding> fileEncodings
		fileEncodings = target.container(FileEncoding)

		final FileEncodingTask fileEncodingTask
		fileEncodingTask = target.getTasks().create(FileEncodingTask.taskName, FileEncodingTask)

		target.extensions.add("fileEncodings", fileEncodings)

		fileEncodings.all { fileEncoding ->
			target.afterEvaluate { fileEncodingTask.fileEncodings.add(fileEncoding) }
		}
	}
}
