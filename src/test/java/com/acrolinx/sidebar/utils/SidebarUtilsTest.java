/* Copyright (c) 2017-present Acrolinx GmbH */

package com.acrolinx.sidebar.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SidebarUtilsTest
{
    @Test
    void isValidURLNullTest()
    {
        assertFalse(SidebarUtils.isValidURL(null));
    }

    @Test
    void isValidURLLocalhostTest()
    {
        assertTrue(SidebarUtils.isValidURL("http://sifnos"));
    }

    @Test
    void isValidURLTEST()
    {
        assertTrue(SidebarUtils.isValidURL("https://us-demo.acrolinx.cloud:443/dashboard.html"));
    }

    @Test
    void isValidURLTEST2()
    {
        assertTrue(SidebarUtils.isValidURL(
                "https://acrolinxiq.wdf.sap.corp/output/en/czv1533128749082_xml_d020143_810d34842a633047_601823388_report.html"));
    }

    @Test
    void isNOTValidURLTEST()
    {
        assertFalse(SidebarUtils.isValidURL(
                "https:/acrolinxiq.wdf.sap.corp/output/en/czv1533128749082_xml_d020143_810d34842a633047_601823388_report.html"));
    }

    @Test
    void testSidebarSystemUtils()
    {
        assertNotNull(SidebarUtils.getSystemJavaVMName());
        assertTrue(SidebarUtils.getSystemJavaVersion() >= 8);
        assertNotNull(SidebarUtils.getPathOfCurrentJavaJRE());
        assertNotNull(SidebarUtils.getFullCurrentJavaVersionString());
    }
}
