/**
 * Copyright (c) 2016 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.core.geom;

import org.mini2Dx.core.graphics.Graphics;

import com.badlogic.gdx.math.Vector2;

/**
 * A {@link Shape} where all interior angles are the same
 */
public class RegularShape implements Shape {
	private final float rotationSymmetry;
	private final int totalSides;
	private final Point center;

	private Polygon polygon;
	private float radius;

	/**
	 * Constructor
	 * 
	 * @param centerX
	 *            The center X coordinate
	 * @param centerY
	 *            The center Y coordinate
	 * @param radius
	 *            The distance from the center to the corner points
	 * @param totalSides
	 *            The total sides of this shape
	 * @param rotationSymmetry
	 *            The rotational symmetry of the corner points from the center
	 */
	public RegularShape(float centerX, float centerY, float radius, int totalSides, float rotationSymmetry) {
		this.center = new Point(centerX, centerY);
		this.rotationSymmetry = rotationSymmetry;
		this.totalSides = totalSides;
		setRadius(radius);
	}

	@Override
	public boolean contains(float x, float y) {
		return polygon.contains(x, y);
	}

	@Override
	public boolean contains(Vector2 vector2) {
		return polygon.contains(vector2);
	}

	/**
	 * Returns if this {@link RegularShape} intersects a {@link Polygon}
	 * 
	 * @param polygon
	 *            The {@link Polygon} to check
	 * @return True if this {@link RegularShape} and {@link Polygon} intersect
	 */
	public boolean intersects(Polygon polygon) {
		return polygon.intersects(polygon);
	}

	/**
	 * Returns if the specified {@link Rectangle} intersects this
	 * {@link RegularShape}
	 * 
	 * @param rectangle
	 *            The {@link Rectangle} to check
	 * @return True if this {@link RegularShape} and {@link Rectangle} intersect
	 */
	public boolean intersects(Rectangle rectangle) {
		return rectangle.intersects(polygon);
	}

	/**
	 * Returns if this {@link RegularShape} intersects a {@link LineSegment}
	 * 
	 * @param lineSegment
	 *            The {@link LineSegment}
	 * @return True if this {@link RegularShape} intersects the
	 *         {@link LineSegment}
	 */
	public boolean intersects(LineSegment lineSegment) {
		return intersectsLineSegment(lineSegment.getPointA(), lineSegment.getPointB());
	}

	/**
	 * Returns if this {@link RegularShape} intersects a line segment
	 * 
	 * @param pointA
	 *            The first {@link Point} in the line segment
	 * @param pointB
	 *            The second {@link Point} in the line segment
	 * @return True if this {@link RegularShape} intersects the line segment
	 */
	public boolean intersectsLineSegment(Point pointA, Point pointB) {
		return polygon.intersectsLineSegment(pointA, pointB);
	}

	@Override
	public void draw(Graphics g) {
		polygon.draw(g);
	}

	@Override
	public void fill(Graphics g) {
		polygon.fill(g);
	}

	/**
	 * Returns the center X coordinate of this {@link RegularShape}
	 * 
	 * @return The center X coordinate
	 */
	@Override
	public float getX() {
		return center.getX();
	}

	/**
	 * Sets the X coordinate of this {@link RegularShape}
	 * 
	 * @param centerX
	 *            The center X coordinate
	 */
	public void setX(float centerX) {
		if (this.center.getX() == centerX) {
			return;
		}
		float diff = centerX - center.getX();
		polygon.translate(diff, 0f);
		center.set(centerX, center.y);
	}

	/**
	 * Returns the center Y coordinate of this {@link RegularShape}
	 * 
	 * @return The center Y coordinate
	 */
	@Override
	public float getY() {
		return center.getY();
	}

	/**
	 * Sets the Y coordinate of this {@link RegularShape}
	 * 
	 * @param centerY
	 *            The center Y coordinate
	 */
	public void setY(float centerY) {
		if (this.center.getY() == centerY) {
			return;
		}
		float diff = centerY - this.center.getY();
		polygon.translate(0f, diff);
		center.set(center.x, centerY);
	}

	/**
	 * Sets the center X and Y coordinates. Faster than calling
	 * {@link RegularShape#setX(float)} and {@link RegularShape#setY(float)}
	 * separately.
	 * 
	 * @param centerX
	 *            The center X coordinate
	 * @param centerY
	 *            The center Y coordinate
	 */
	public void set(float centerX, float centerY) {
		float diffX = centerX - this.center.getX();
		float diffY = centerY - this.center.getY();
		polygon.translate(diffX, diffY);
		center.set(centerX, centerY);
	}

	/**
	 * Returns the radius of this {@link RegularShape}
	 * 
	 * @return The distance between the center and its corners
	 */
	public float getRadius() {
		return radius;
	}

	/**
	 * Sets the radius of this {@link RegularShape}
	 * 
	 * Note: This operation is expensive
	 * 
	 * @param radius
	 *            The distance between the center and its corners
	 */
	public void setRadius(float radius) {
		if (this.radius == radius) {
			return;
		}
		this.radius = radius;

		Point[] points = new Point[totalSides];
		points[0] = new Point(center.getX(), center.getY() - radius);
		for (int i = 1; i < points.length; i++) {
			points[i] = new Point(points[0]);
			points[i].rotateAround(center, rotationSymmetry * i);
		}
		polygon = new Polygon(points);
	}

	/**
	 * Returns the x coordinate of the corner at the specified index
	 * 
	 * @param index
	 *            The index where 0 = the top corner and increments in a
	 *            clockwise method
	 * @return The x coordinate of the corner
	 */
	public float getX(int index) {
		return polygon.getVertices()[index * 2];
	}
	
	/**
	 * Returns the y coordinate of the corner at the specified index
	 * 
	 * @param index
	 *            The index where 0 = the top corner and increments in a
	 *            clockwise method
	 * @return The y coordinate of the corner
	 */
	public float getY(int index) {
		return polygon.getVertices()[(index * 2) + 1];
	}

	@Override
	public int getNumberOfSides() {
		return totalSides;
	}
}
