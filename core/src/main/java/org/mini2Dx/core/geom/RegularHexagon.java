/**
 * Copyright (c) 2018 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice, this
 *   list of conditions and the following disclaimer in the documentation and/or
 *   other materials provided with the distribution.
 *
 * * Neither the name of mini2Dx nor the names of its
 *   contributors may be used to endorse or promote products derived from
 *   this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.core.geom;

import org.mini2Dx.core.Geometry;

/**
 * A <a href="https://en.wikipedia.org/wiki/Hexagon">hexagon</a> where all
 * interior angles are 120 degrees.
 */
public class RegularHexagon extends RegularPolygon {
    public static final float ROTATION_SYMMETRY = 60f;
    private static final int TOTAL_SIDES = 6;

    /**
     * Constructor
     * @param centerX The center X coordinate
     * @param centerY The center Y coordinate
     * @param radius The distance from the center to the corner points
     */
    public RegularHexagon(float centerX, float centerY, float radius) {
        super(centerX, centerY, radius, TOTAL_SIDES, ROTATION_SYMMETRY);
    }

    /**
     * Constructs a {@link RegularHexagon} belonging to the {@link Geometry} pool
     * @param geometry the {@link Geometry} pool
     */
    public RegularHexagon(Geometry geometry) {
        super(geometry, TOTAL_SIDES, ROTATION_SYMMETRY);
    }

    @Override
    public void release() {
        if(geometry == null) {
            return;
        }
        geometry.release(this);
    }
}
