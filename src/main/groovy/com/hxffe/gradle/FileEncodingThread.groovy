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
		this.fileEncoding.target.each { file ->
			EncodingStream input = EncodingStream.create(fileEncoding.fromEncoding, file)
			EncodingStream output = EncodingStream.create(fileEncoding.toEncoding, file)
			EncodingStream.process(input, output)
		}
	}

	@Override
	String toString() {
		return "${fileEncoding.fromEncoding} to ${fileEncoding.toEncoding} ${fileEncoding.target}"
	}
}
