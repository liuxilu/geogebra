package org.geogebra.common.jre.openGL;

import java.nio.ShortBuffer;

import org.geogebra.common.geogebra3D.euclidian3D.openGL.GLBufferIndices;

/**
 * buffers for openGL
 * 
 * @author Mathieu
 *
 */
public class GLBufferIndicesJavaNio implements GLBufferIndices {
	private ShortBuffer impl;
	private boolean isEmpty;

	private int currentLength;
	/**
	 * constructor from float array
	 */
	public GLBufferIndicesJavaNio() {
		isEmpty = true;
	}

	@Override
	public boolean isEmpty() {
		return isEmpty;
	}

	@Override
	public void setEmpty() {
		isEmpty = true;
	}

	@Override
	public void allocate(int length) {

		// allocate buffer only at start and when length change
		if (impl == null || impl.capacity() < length) {
			impl = ShortBuffer.allocate(length);
		} else {
			impl.rewind();
		}

		impl.limit(length);

	}

	@Override
	public void setLimit(int length) {
		impl.limit(length);
		currentLength = length;

		impl.rewind();
		isEmpty = false;
	}

	@Override
	public void put(short value) {
		impl.put(value);
	}

	@Override
	public short get() {
		return impl.get();
	}

	@Override
	public void rewind() {
		impl.rewind();
	}

	@Override
	public int capacity() {
		return currentLength;
	}

	@Override
	public void array(short[] ret) {
		impl.rewind();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = impl.get();
		}
	}

	/**
	 * 
	 * @return buffer
	 */
	public ShortBuffer getBuffer() {
		return impl;
	}

}
