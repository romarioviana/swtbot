/*******************************************************************************
 * Copyright (c) 2008 Ketan Padegaonkar and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Ketan Padegaonkar - initial API and implementation
 *******************************************************************************/
package org.eclipse.swtbot.swt.finder.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Ketan Padegaonkar &lt;KetanPadegaonkar [at] gmail [dot] com&gt;
 * @version $Id$
 */
public class StringUtilsTest {

	@Test
	public void isEmptyOrNull() throws Exception {
		assertTrue(StringUtils.isEmptyOrNull(null));
		assertTrue(StringUtils.isEmptyOrNull(""));
		assertTrue(StringUtils.isEmptyOrNull("  "));
		assertTrue(StringUtils.isEmptyOrNull("  \t "));
		assertFalse(StringUtils.isEmptyOrNull("  foo bar "));
	}

	@Test
	public void canJoinListsUsingTheObjectConverter() throws Exception {
		Object[] toJoin = new Object[] { new TestObject("foo"), new TestObject("bar"), new TestObject("baz") };
		StringConverter converter = new StringConverter() {
			@Override
			public String toString(Object object) {
				return ((TestObject) object).string;
			}
		};

		assertEquals("foo, bar, baz", StringUtils.join(toJoin, ", ", converter));
	}

	@Test
	public void joinOfObjects() throws Exception {
		assertEquals("foo, bar, baz", StringUtils.join(new String[] { "foo", "bar", "baz" }, ", "));
	}

	private class TestObject {

		String	string;

		public TestObject(String string) {
			this.string = string;
		}
	}
}
