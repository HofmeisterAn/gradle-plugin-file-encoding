package com.hxffe.gradle

import com.hxffe.gradle.encoding.Iso88591
import com.hxffe.gradle.encoding.Utf8

abstract class EncodingStream {
	private static final Map<String, Class<EncodingStream>> encodingStreams = new HashMap<>()

	private final String charsetName

	private final File inputFile

	private final File outputFile

	InputStreamReader getInputStreamReader() {
		FileInputStream fis = new FileInputStream(this.inputFile)
		return new InputStreamReader(fis, this.charsetName)
	}

	OutputStreamWriter getOutputStreamWriter() {
		FileOutputStream fos = new FileOutputStream(this.outputFile)
		return new OutputStreamWriter(fos, this.charsetName)
	}

	static {
		encodingStreams.put(Iso88591.CHARSET_NAME, Iso88591.class)
		encodingStreams.put(Utf8.CHARSET_NAME, Utf8.class)
	}

	EncodingStream(String charsetName, File file) {
		this(charsetName, file, file)
	}

	EncodingStream(String charsetName, File inputFile, File outputFile) {
		this.charsetName = charsetName
		this.inputFile = inputFile
		this.outputFile = outputFile
	}

	static EncodingStream create(String charsetName, File file) {
		return encodingStreams.get(charsetName).getConstructor(File.class).newInstance(file)
	}

	static process(EncodingStream input, EncodingStream output) {
		new BufferedReader(input.getInputStreamReader()).withCloseable { reader ->
			new BufferedWriter(output.getOutputStreamWriter()).withCloseable { writer ->
				int ch
				while ((ch = reader.read()) > -1) {
					writer.write(ch)
				}
			}
		}
	}
}
