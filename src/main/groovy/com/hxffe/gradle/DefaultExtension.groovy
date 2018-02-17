package com.hxffe.gradle

import com.hxffe.gradle.serializable.ExtensionSerializable
import org.gradle.api.Project

abstract class DefaultExtension<T> implements ExtensionSerializable<T> {
	protected final Project project

	DefaultExtension(Project project) {
		this.project = project
	}
}
