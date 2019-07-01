/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.element;

import org.mini2Dx.core.input.button.GamePadButton;
import org.mini2Dx.gdx.Input;
import org.mini2Dx.ui.navigation.UiNavigation;
import org.mini2Dx.ui.render.ActionableRenderNode;

/**
 * Common interface for {@link UiElement}s that can be navigated by keyboard or
 * controller
 */
public interface Navigatable {
	/**
	 * Returns the unique id of the {@link Navigatable}
	 * @return A non-null {@link String} that is the id
	 */
	public String getId();
	/**
	 * Triggers a navigation and returns the newly highlighted {@link ActionableRenderNode}
	 * @param keycode The navigation {@link Input.Keys} value
	 * @return Null if no {@link UiNavigation} is available
	 */
	public ActionableRenderNode navigate(int keycode);

	/**
	 * Returns the corresponding {@link ActionableRenderNode} mapped to a keyboard hotkey
	 * @param keycode The {@link Input.Keys} keycode that is the hotkey
	 * @return Null if there is no mapping
	 */
	public ActionableRenderNode hotkey(int keycode);

	/**
	 * Returns the corresponding {@link ActionableRenderNode} mapped to a {@link GamePadButton} hotkey
	 * @param button The {@link GamePadButton} that is the hotkey
	 * @return Null if there is no mapping
	 */
	public ActionableRenderNode hotkey(GamePadButton button);

	/**
	 * Maps a {@link GamePadButton} to a {@link Actionable}
	 * @param button The {@link GamePadButton} that is the hotkey
	 * @param actionable The {@link Actionable} to trigger when the hotkey is pressed
	 */
	public void setHotkey(GamePadButton button, Actionable actionable);

	/**
	 * Maps a keyboard button to a {@link Actionable}
	 * @param keycode The {@link Input.Keys} keycode that is the hotkey
	 * @param actionable The {@link Actionable} to trigger when the key is pressed
	 */
	public void setHotkey(int keycode, Actionable actionable);

	/**
	 * Unmaps a {@link GamePadButton} hotkey
	 * @param button The {@link GamePadButton} that is the hotkey
	 */
	public void unsetHotkey(GamePadButton button);

	/**
	 * Unmaps a keyboard hotkey
	 * @param keycode The {@link Input.Keys} keycode that is the hotkey
	 */
	public void unsetHotkey(int keycode);
	
	/**
	 * Unmaps all hotkeys
	 */
	public void clearHotkeys();
	
	/**
	 * Unmaps all controller hotkeys
	 */
	public void clearGamePadHotkeys();
	
	/**
	 * Unmaps all keyboard hotkeys
	 */
	public void clearKeyboardHotkeys();

	/**
	 * Returns the {@link UiNavigation} currently being navigated
	 * @return Null if no navigation is occurring
	 */
	public UiNavigation getNavigation();
}
