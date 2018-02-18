package com.hxffe.gradle.encoding

import com.hxffe.gradle.EncodingStream

class Utf8 extends EncodingStream {
	final static CHARSET_NAME = "UTF-8"

	Utf8(File file) {
		super(CHARSET_NAME, file)
	}
}
