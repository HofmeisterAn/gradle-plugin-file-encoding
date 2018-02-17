package com.hxffe.gradle.serializable

interface ExtensionSerializable<T> extends Serializable {
	T serialize()
}