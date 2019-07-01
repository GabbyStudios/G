/**
 * Copyright (c) 2017 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.style;

import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.assets.AssetManager;
import org.mini2Dx.core.files.FileHandleResolver;
import org.mini2Dx.core.graphics.TextureRegion;
import org.mini2Dx.core.serialization.annotation.Field;

/**
 *
 */
public class RadioButtonStyleRule extends LabelStyleRule {
	@Field
	private String active;
	@Field
	private String inactive;
	@Field(optional=true)
	private String activeHover;
	@Field(optional=true)
	private String inactiveHover;
	@Field
	private String disabledActive;
	@Field
	private String disabledInactive;
	@Field(optional=true)
	private String disabledActiveHover;
	@Field(optional=true)
	private String disabledInactiveHover;
	@Field
	private int optionsSpacing;
	@Field
	private int labelIndent;
	
	private TextureRegion activeTextureRegion, inactiveTextureRegion, activeHoverTextureRegion, inactiveHoverTextureRegion,
		disabledActiveTextureRegion, disabledInactiveTextureRegion, disabledActiveHoverTextureRegion, disabledInactiveHoverTextureRegion;

	@Override
	public void prepareAssets(UiTheme theme, FileHandleResolver fileHandleResolver, AssetManager assetManager) {
		if (theme.isHeadless()) {
			return; 
		}
		
		super.prepareAssets(theme, fileHandleResolver, assetManager);
		activeTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(active));
		inactiveTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(inactive));
		disabledActiveTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(disabledActive));
		disabledInactiveTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(disabledInactive));
	
		if(activeHover != null) {
			activeHoverTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(activeHover));
		} else {
			activeHoverTextureRegion = activeTextureRegion;
		}
		if(inactiveHover != null) {
			inactiveHoverTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(inactiveHover));
		} else {
			inactiveHoverTextureRegion = inactiveTextureRegion;
		}
		if(disabledActiveHover != null) {
			disabledActiveHoverTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(disabledActiveHover));
		} else {
			disabledActiveHoverTextureRegion = disabledActiveTextureRegion;
		}
		if(disabledInactiveHover != null) {
			disabledInactiveHoverTextureRegion = Mdx.graphics.newTextureRegion(theme.getTextureAtlas().findRegion(disabledInactiveHover));
		} else {
			disabledInactiveHoverTextureRegion = disabledInactiveTextureRegion;
		}
	}
	
	public TextureRegion getActiveTextureRegion() {
		return activeTextureRegion;
	}

	public TextureRegion getInactiveTextureRegion() {
		return inactiveTextureRegion;
	}

	public TextureRegion getDisabledActiveTextureRegion() {
		return disabledActiveTextureRegion;
	}

	public TextureRegion getDisabledInactiveTextureRegion() {
		return disabledInactiveTextureRegion;
	}

	public TextureRegion getActiveHoverTextureRegion() {
		return activeHoverTextureRegion;
	}
	
	public TextureRegion getInactiveHoverTextureRegion() {
		return inactiveHoverTextureRegion;
	}

	public TextureRegion getDisabledActiveHoverTextureRegion() {
		return disabledActiveHoverTextureRegion;
	}

	public TextureRegion getDisabledInactiveHoverTextureRegion() {
		return disabledInactiveHoverTextureRegion;
	}

	public int getOptionsSpacing() {
		return optionsSpacing;
	}

	public void setOptionsSpacing(int optionsSpacing) {
		this.optionsSpacing = optionsSpacing;
	}

	public int getLabelIndent() {
		return labelIndent;
	}

	public void setLabelIndent(int labelIndent) {
		this.labelIndent = labelIndent;
	}
}
