<%@taglib prefix="s" uri="/struts-tags"%>
<p>
        Accede a cualquiera de las opciones en el men&uacute; para 
        realizar las operaciones.
        <s:url var="ingles" includeParams="all" value="">
                <s:param name="request_locale">en</s:param>
        </s:url>	
        <s:url var="espanol" includeParams="all" value="">
                <s:param name="request_locale">es</s:param>
        </s:url>

        <br />
      
         <s:a href="%{ingles}">Ingles</s:a> <br />
         <s:a href="%{espanol}">Español</s:a>
</p>