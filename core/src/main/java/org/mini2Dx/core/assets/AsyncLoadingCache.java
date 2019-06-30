/*******************************************************************************
 * Copyright 2019 Viridian Software Limited
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
package org.mini2Dx.core.assets;

import org.mini2Dx.gdx.utils.ObjectMap;

public class AsyncLoadingCache {
	private final ObjectMap<String, Object> cache = new ObjectMap<String, Object>(7);

	public String getCache(String cacheKey) {
		return getCache(cacheKey, String.class, null);
	}

	public <T> T getCache(String cacheKey, Class<T> clazz) {
		return (T) cache.get(cacheKey);
	}

	public <T> T getCache(String cacheKey, Class<T> clazz, T defaultValue) {
		return (T) cache.get(cacheKey, defaultValue);
	}

	public void setCache(String cacheKey, Object value) {
		cache.put(cacheKey, value);
	}

	public boolean containsCache(String cacheKey) {
		return cache.containsKey(cacheKey);
	}

	public void clearCache() {
		cache.clear();
	}
}
