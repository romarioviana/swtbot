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
package org.eclipse.swtbot.swt.finder.widgets;

import static org.junit.Assert.assertEquals;

import org.eclipse.swtbot.swt.finder.test.AbstractControlExampleTest;
import org.junit.Before;
import org.junit.Test;

public class SWTBotToolbarPushButtonWithToolTipTest extends AbstractControlExampleTest {

	@Test
	public void findsToolBarButtonWithToolTipBasedOnIndex() throws Exception {
		SWTBotToolbarButton button = bot.toolbarButtonWithTooltip("SWT.PUSH", 0);
		assertEquals("", button.getText());

		button = bot.toolbarButtonWithTooltip("SWT.PUSH", 1);
		assertEquals("", button.getText());

		button = bot.toolbarButtonWithTooltip("SWT.PUSH", 2);
		assertEquals("Push", button.getText());

		button = bot.toolbarButtonWithTooltip("SWT.PUSH", 3);
		assertEquals("Push", button.getText());
	}

	@Test
	public void findsToolBarButtonWithToolTip() throws Exception {
		for (int i = 0; i < 6; i++) {
			bot.toolbarButtonWithTooltip("SWT.PUSH", i);
		}
	}

	@Test
	public void findsToolBarButtonWithToolTip2() throws Exception {
		for (int i = 0; i < 6; i++) {
			bot.toolbarRadioButtonWithTooltip("SWT.RADIO", i);
		}
	}

	@Test
	public void getsTooltipOnButton() throws Exception {
		SWTBotToolbarRadioButton button = bot.toolbarRadioButtonWithTooltip("SWT.RADIO");
		String toolTipText = button.getToolTipText();
		assertEquals("SWT.RADIO", toolTipText);
	}

	@Before
	public void prepareExample() throws Exception {
		bot.tabItem("ToolBar").activate();
	}

}
