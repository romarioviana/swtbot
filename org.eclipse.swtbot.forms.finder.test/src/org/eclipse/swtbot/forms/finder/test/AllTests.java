/*******************************************************************************
 * Copyright (c) 2011 Ketan Padegaonkar and others.
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
package org.eclipse.swtbot.forms.finder.test;

import org.eclipse.swtbot.forms.finder.test.widgets.SWTBotHyperlinkTest;
import org.eclipse.swtbot.forms.finder.test.widgets.SWTBotImageHyperlinkTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Ketan Padegaonkar &lt;KetanPadegaonkar [at] gmail [dot] com&gt;
 */
@RunWith(Suite.class)
@SuiteClasses({
	SWTBotHyperlinkTest.class,
	SWTBotImageHyperlinkTest.class,
	})
public class AllTests {

}
