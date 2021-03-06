////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2015 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////
package com.puppycrawl.tools.checkstyle.checks.whitespace;

import com.google.common.collect.Maps;
import com.puppycrawl.tools.checkstyle.BaseCheckTestSupport;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;

import java.io.File;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static com.puppycrawl.tools.checkstyle.checks.whitespace.GenericWhitespaceCheck.WS_FOLLOWED;
import static com.puppycrawl.tools.checkstyle.checks.whitespace.GenericWhitespaceCheck
.WS_ILLEGAL_FOLLOW;
import static com.puppycrawl.tools.checkstyle.checks.whitespace.GenericWhitespaceCheck
.WS_NOT_PRECEDED;
import static com.puppycrawl.tools.checkstyle.checks.whitespace.GenericWhitespaceCheck.WS_PRECEDED;

public class GenericWhitespaceCheckTest
    extends BaseCheckTestSupport
{
    private DefaultConfiguration checkConfig;

    @Before
    public void setUp()
    {
        checkConfig = createCheckConfig(GenericWhitespaceCheck.class);
        Map<Class<?>, Integer> x = Maps.newHashMap();
        for (final Map.Entry<Class<?>, Integer> entry : x.entrySet()) {
            entry.getValue();
        }
        //for (final Entry<Class<?>, Integer> entry : entrySet())
    }

    @Test
    public void testDefault() throws Exception
    {
        final String[] expected = {
            "16:13: " + getCheckMessage(WS_PRECEDED, "<"),
            "16:15: " + getCheckMessage(WS_FOLLOWED, "<"),
            "16:23: " + getCheckMessage(WS_PRECEDED, ">"),
            "16:43: " + getCheckMessage(WS_PRECEDED, "<"),
            "16:45: " + getCheckMessage(WS_FOLLOWED, "<"),
            "16:53: " + getCheckMessage(WS_PRECEDED, ">"),
            "17:13: " + getCheckMessage(WS_PRECEDED, "<"),
            "17:15: " + getCheckMessage(WS_FOLLOWED, "<"),
            "17:20: " + getCheckMessage(WS_PRECEDED, "<"),
            "17:22: " + getCheckMessage(WS_FOLLOWED, "<"),
            "17:30: " + getCheckMessage(WS_PRECEDED, ">"),
            "17:32: " + getCheckMessage(WS_FOLLOWED, ">"),
            "17:32: " + getCheckMessage(WS_PRECEDED, ">"),
            "17:52: " + getCheckMessage(WS_PRECEDED, "<"),
            "17:54: " + getCheckMessage(WS_FOLLOWED, "<"),
            "17:59: " + getCheckMessage(WS_PRECEDED, "<"),
            "17:61: " + getCheckMessage(WS_FOLLOWED, "<"),
            "17:69: " + getCheckMessage(WS_PRECEDED, ">"),
            "17:71: " + getCheckMessage(WS_FOLLOWED, ">"),
            "17:71: " + getCheckMessage(WS_PRECEDED, ">"),
            "30:17: " + getCheckMessage(WS_NOT_PRECEDED, "<"),
            "30:21: " + getCheckMessage(WS_ILLEGAL_FOLLOW, ">"),
            "42:21: " + getCheckMessage(WS_PRECEDED, "<"),
            "42:30: " + getCheckMessage(WS_FOLLOWED, ">"),
            "60:60: " + getCheckMessage(WS_NOT_PRECEDED, "&"),
            "63:60: " + getCheckMessage(WS_FOLLOWED, ">"),
        };
        verify(checkConfig,
                getPath("whitespace/InputGenericWhitespaceCheck.java"),
                expected);
    }

    @Test
    public void testGh47() throws Exception
    {
        final String[] expected = {};
        verify(checkConfig, getPath("whitespace/Gh47.java"), expected);
    }

    @Test
    public void testInnerClass() throws Exception
    {
        final String[] expected = {

        };
        verify(checkConfig, getPath("whitespace/"
                + "InputGenericWhitespaceInnerClassCheck.java"), expected);
    }

    @Test
    public void testMethodReferences() throws Exception
    {
        final String[] expected = {};
        verify(checkConfig, new File("src/test/resources-noncompilable/com/puppycrawl/tools/"
                + "checkstyle/grammars/java8/"
                + "InputMethodReferencesTest3.java").getCanonicalPath(), expected);
    }
}
