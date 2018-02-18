package com.hxffe.gradle.encoding

import com.hxffe.gradle.EncodingStream

class Iso88591 extends EncodingStream {
	final static CHARSET_NAME = "ISO-8859-1"

	Iso88591(File file) {
		super(CHARSET_NAME, file)
	}
}
