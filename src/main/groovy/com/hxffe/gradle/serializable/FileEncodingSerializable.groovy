package com.hxffe.gradle.serializable

import com.hxffe.gradle.FileEncoding

class FileEncodingSerializable implements Serializable {
	final String fromEncoding

	final String toEncoding

	final Set<File> target

	FileEncodingSerializable(FileEncoding fileEncoding) {
		this.fromEncoding = fileEncoding.fromEncoding
		this.toEncoding = fileEncoding.toEncoding

		if (fileEncoding.target) {
			this.target = fileEncoding.target.files
		} else {
			this.target = []
		}
	}
}
