package com.hxffe.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.workers.IsolationMode
import org.gradle.workers.WorkerConfiguration
import org.gradle.workers.WorkerExecutor

import javax.inject.Inject

class FileEncodingTask extends DefaultTask {
	static final def taskName = "convert"

	WorkerExecutor workerExecutor

	List<FileEncoding> fileEncodings = []

	@Inject
	FileEncodingTask(WorkerExecutor workerExecutor) {
		this.workerExecutor = workerExecutor
	}

	@TaskAction
	def action() {
		this.fileEncodings.each { fileEncoding ->
			this.workerExecutor.submit(FileEncodingThread.class) { WorkerConfiguration conf ->
				// Any better way to serialize params?
				conf.isolationMode = IsolationMode.PROCESS
				conf.params = [fileEncoding.serialize()]
			}
		}
	}
}
