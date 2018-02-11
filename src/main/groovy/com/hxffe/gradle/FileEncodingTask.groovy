package com.hxffe.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class FileEncodingTask extends DefaultTask {
	static final String taskName = "convert"

	FileEncoding fileEncoding

	@TaskAction
	def action() { }
}
