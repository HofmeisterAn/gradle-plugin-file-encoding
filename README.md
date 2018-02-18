# Gradle Plugin File Encoding

This Gradle plugin converts files from one encoding to another.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

None

## Running

To encode files add the plugin to your `build.gradle`, as well as a named object to `fileEncodings` and run the `convert` task. See the example below:

```gradle
buildscript {
	dependencies { classpath files('libs/file-encoding-1.0.jar') }
}

apply plugin: 'com.hxffe.gradle.file-encoding'

fileEncodings {
	src {
		fromEncoding = 'ISO-8859-1'
		toEncoding = 'UTF-8'
		target files('ISO-8859-1.txt')
	}
}
```

### Supported Encodings
- ISO-8859-1
- UTF-8

## Authors

* **Andre Hofmeister** - *Initial work* - [padme-amidala](https://github.com/padme-amidala/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
