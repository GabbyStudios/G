/*******************************************************************************
 * Copyright 2019 See AUTHORS file
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.mini2Dx.core.reflect;

import org.mini2Dx.core.exception.ReflectionException;

public interface Field {

	/**
	 * Returns the name of the field
	 * @return
	 */
	public String getName ();

	/**
	 * Returns the current value of the field for a given instance
	 *
	 * @param instance The instance to get the field's value from
	 * @return The field's value
	 * @throws ReflectionException
	 */
	public Object get(Object instance) throws ReflectionException;

	/**
	 * Sets the current value of the field for a given instance
	 *
	 * @param instance The instance to set the field's value for
	 * @param value    The new value
	 * @throws ReflectionException
	 */
	public void set(Object instance, Object value) throws ReflectionException;

	/**
	 * Returns true if the field if annotated with the given annotation class
	 *
	 * @param annotation The annotation class
	 * @return False if the annotation is not present
	 */
	public boolean isAnnotationPresent(Class<? extends java.lang.annotation.Annotation> annotation);

	/**
	 * Returns the declared annotations
	 * @return An empty array if no annotations declared
	 */
	public Annotation [] getDeclaredAnnotations();

	/**
	 * Returns a annotation on this field
	 * @param annotationType The annotation type to search for
	 * @return Null if the field is not annotated with the annotation
	 */
	public Annotation getDeclaredAnnotation (Class<? extends java.lang.annotation.Annotation> annotationType);

	/**
	 * Returns the class type this field was declared as
	 *
	 * @return
	 */
	public Class getType();

	/**
	 * Returns the class of the generic type parameter at the specific index
	 *
	 * @param index The generic parameter index
	 * @return Null if the type is not generic
	 */
	public Class getElementType(int index);

	/**
	 * Returns if the field is not public/private/protected
	 */
	public boolean isDefaultAccess();

	/**
	 * Returns if the field is declared as final
	 */
	public boolean isFinal();

	/**
	 * Returns if the field is private
	 */
	public boolean isPrivate();

	/**
	 * Returns if the field is protected
	 */
	public boolean isProtected();

	/**
	 * Returns if the field is public
	 */
	public boolean isPublic();

	/**
	 * Returns if the field is static
	 */
	public boolean isStatic();

	/**
	 * Returns if the field is declared transient
	 */
	public boolean isTransient();

	/**
	 * Returns if the field is declared volatile
	 */
	public boolean isVolatile();

	/**
	 * Returns if the field is synthetic (generated by compiler)
	 */
	public boolean isSynthetic();
}