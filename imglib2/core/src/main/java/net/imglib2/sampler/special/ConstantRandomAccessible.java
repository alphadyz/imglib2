/**
 * Copyright (c) 2009--2010, Stephan Preibisch & Stephan Saalfeld
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.  Redistributions in binary
 * form must reproduce the above copyright notice, this list of conditions and
 * the following disclaimer in the documentation and/or other materials
 * provided with the distribution.  Neither the name of the Fiji project nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.imglib2.sampler.special;

import net.imglib2.AbstractRandomAccess;
import net.imglib2.Interval;
import net.imglib2.RandomAccess;
import net.imglib2.RandomAccessible;


/**
 * @author Lee Kamentsky
 *
 */
public class ConstantRandomAccessible<T> implements RandomAccessible<T> {

	protected class ConstantRandomAccess extends AbstractRandomAccess<T> {
		public ConstantRandomAccess() {
			super(nDimensions);
		}

		@Override
		public void fwd(int d) {
			position[d]++;
		}

		@Override
		public void bck(int d) {
			position[d]--;
		}

		@Override
		public void move(long distance, int d) {
			position[d] += distance;
		}

		@Override
		public void setPosition(int[] position) {
			for (int i=0; i<numDimensions(); i++) {
				this.position[i] = position[i];
			}
		}

		@Override
		public void setPosition(long[] position) {
			for (int i=0; i<numDimensions(); i++) {
				this.position[i] = position[i];
			}
		}

		@Override
		public void setPosition(long position, int d) {
			this.position[d] = position;
		}

		@Override
		public T get() {
			return constant;
		}

		@Override
		public AbstractRandomAccess<T> copy() {
			return new ConstantRandomAccess();
		}

		@Override
		public AbstractRandomAccess<T> copyRandomAccess() {
			return new ConstantRandomAccess();
		}

	}
	private final int nDimensions;
	private final T constant;
	public ConstantRandomAccessible(T constant, int nDimensions) {
		this.nDimensions = nDimensions;
		this.constant = constant;
	}
	@Override
	public int numDimensions() {
		return nDimensions;
	}

	@Override
	public RandomAccess<T> randomAccess() {
		return new ConstantRandomAccess();
	}
	@Override
	public RandomAccess<T> randomAccess(Interval interval) {
		return new ConstantRandomAccess();
	}
}
