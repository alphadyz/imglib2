/*
 * #%L
 * ImgLib2: a general-purpose, multidimensional image processing library.
 * %%
 * Copyright (C) 2009 - 2014 Stephan Preibisch, Tobias Pietzsch, Barry DeZonia,
 * Stephan Saalfeld, Albert Cardona, Curtis Rueden, Christian Dietz, Jean-Yves
 * Tinevez, Johannes Schindelin, Lee Kamentsky, Larry Lindsey, Grant Harris,
 * Mark Hiner, Aivar Grislis, Martin Horn, Nick Perry, Michael Zinsmaier,
 * Steffen Jaensch, Jan Funke, Mark Longair, and Dimiter Prodanov.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imglib2.algorithm.componenttree;

import java.util.List;

import net.imglib2.Localizable;

/**
 * Represents a connected component and a node in a {@link ComponentTree}. The
 * child and parent nodes can be accessed by {@link #getChildren()} and
 * {@link #getParent()}. The set of pixels can be accessed by iterating (
 * {@link #iterator()}) the component. The threshold value that created the
 * component (extremal region) can be obtained by {@link #value()}.
 * 
 * @author Florian Jug
 * @author Tobias Pietzsch <tobias.pietzsch@gmail.com>
 */
public interface Component< T, C extends Component< T, C > > extends Iterable< Localizable >
{
	/**
	 * Get the number of pixels in the connected component.
	 * 
	 * @return number of pixels in the connected component.
	 */
	public long size();

	/**
	 * Get the image threshold that created the connected component (extremal
	 * region).
	 * 
	 * @return the image threshold that created the connected component.
	 */
	public T value();

	/**
	 * Get the parent of this node in the {@link ComponentTree}.
	 * 
	 * @return the parent of this node in the {@link ComponentTree}.
	 */
	public C getParent();

	/**
	 * Get the children of this node in the {@link ComponentTree}.
	 * 
	 * @return the children of this node in the {@link ComponentTree}.
	 */
	public List< C > getChildren();
}