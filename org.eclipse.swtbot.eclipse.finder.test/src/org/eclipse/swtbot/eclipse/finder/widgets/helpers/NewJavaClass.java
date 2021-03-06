/*******************************************************************************
 * Copyright (c) 2008, 2019 Ketan Padegaonkar and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *     Ketan Padegaonkar - initial API and implementation
 *     Patrick Tasse - Speed up SWTBot tests
 *******************************************************************************/
package org.eclipse.swtbot.eclipse.finder.widgets.helpers;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 * Screen object to create a new java class.
 * 
 * @author Ketan Padegaonkar &lt;KetanPadegaonkar [at] gmail [dot] com&gt;
 * @version $Id$
 */
public class NewJavaClass {

	private SWTWorkbenchBot	bot	= new SWTWorkbenchBot();

	public void createClass(String packageName, String className) {
		bot.shell().activate();

		if (!bot.activePerspective().getLabel().equals("Java")) {
			SWTBotMenu windowMenu = bot.menu("Window");
			SWTBotMenu perspectiveMenu = windowMenu.menu("Open Perspective");
			SWTBotMenu javaPerspectiveMenu = perspectiveMenu.menu("Java");
			if (javaPerspectiveMenu.isVisible() && javaPerspectiveMenu.isEnabled()) { 
				javaPerspectiveMenu.click();
			}
		}
		bot.menu("File").menu("New").menu("Class").click();

		SWTBotShell shell = bot.shell("New Java Class");
		shell.activate();
		bot.textWithLabel("Package:").setText(packageName);
		bot.textWithLabel("Name:").setText(className);
		bot.button("Finish").click();

		bot.waitUntil(Conditions.shellCloses(shell));

		bot.shell().activate();
	}
}
