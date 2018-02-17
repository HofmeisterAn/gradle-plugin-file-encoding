package com.hxffe.gradle

import com.hxffe.gradle.serializable.FileEncodingSerializable

import javax.inject.Inject

class FileEncodingThread implements Runnable {
	private final FileEncodingSerializable fileEncoding

	@Inject
	FileEncodingThread(FileEncodingSerializable fileEncoding) {
		this.fileEncoding = fileEncoding
	}

	@Override
	void run() {
		println(toString())
	}

	@Override
	String toString() {
		return "${fileEncoding.fromEncoding} to ${fileEncoding.toEncoding} ${fileEncoding.target}"
	}
}
