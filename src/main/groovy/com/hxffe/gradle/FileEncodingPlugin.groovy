package com.hxffe.gradle

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator

class FileEncodingPlugin implements Plugin<Project> {
	@Override
	void apply(Project target) {
		final Class<FileEncoding> fileEncodingClass = FileEncoding.class

		final Class<FileEncodingTask> fileEncodingTaskClass = FileEncodingTask.class

		// Pass project to named object container extension
		final NamedDomainObjectContainer<FileEncoding> fileEncodings
		fileEncodings = target.container(fileEncodingClass, { name ->
			return target.getServices().get(Instantiator).newInstance(fileEncodingClass, target, name)
		})

		final FileEncodingTask fileEncodingTask
		fileEncodingTask = target.getTasks().create(FileEncodingTask.taskName, fileEncodingTaskClass)

		target.extensions.add("fileEncodings", fileEncodings)

		fileEncodings.all { fileEncoding ->
			target.afterEvaluate {
				fileEncodingTask.fileEncodings.add(fileEncoding)
			}
		}
	}
}
