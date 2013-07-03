<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><s:text name="titulo" /></title>
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/reset.css"/>">
        <link rel="stylesheet" type="text/css" href="<s:url value="/css/default.css"/>">
        <s:head />
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="help" />
        <section id="contenido">
            <h1>${titulo}</h1>
            <div>
                <tiles:insertAttribute name="body" />
            </div>
        </section>
        <tiles:insertAttribute name="footer" />
    </body>
</html>