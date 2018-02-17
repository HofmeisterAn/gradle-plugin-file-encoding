package com.hxffe.gradle

import com.hxffe.gradle.serializable.FileEncodingSerializable
import org.gradle.api.Project
import org.gradle.api.file.FileCollection

class FileEncoding extends DefaultExtension<FileEncodingSerializable> {
	final String name

	String fromEncoding

	String toEncoding

	FileCollection target

	FileEncoding(Project project, String name) {
		super(project)
		this.name = name
	}

	void target(Object... targets) {
		if (targets == null) {
			this.target = this.project.files([])
		}

		if (targets.length == 0) {
			this.target = this.project.files([])
		}

		if (targets.length == 1) {
			this.target = parseTarget(targets[0])
		}
	}

	private static FileCollection parseTarget(Object target) {
		if (target instanceof FileCollection) {
			return (FileCollection) target
		}
	}

	@Override
	FileEncodingSerializable serialize() {
		return new FileEncodingSerializable(this)
	}
}
