<%--

  Test Run component.

  

--%><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%@page import="com.cqblueprints.bnp.*" %><%
	// TODO add you code here
	
	// lets run the test runner
	TestJCR.runNodeRunner("test-config.json",resourceResolver);
%>Test node ran?