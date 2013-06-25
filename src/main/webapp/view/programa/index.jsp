<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:text name='listado_programas' var="listado_programas"/>
<gch:base titulo="${listado_programas}">
    <s:url action="listarProgramas" var="urlEn" >
        <s:param name="request_locale">en</s:param>
    </s:url>
    <s:url action="listarProgramas" var="urlEs" >
        <s:param name="request_locale">es</s:param>
    </s:url>
    <s:a href="%{urlEn}" >English</s:a>
    <s:a href="%{urlEs}" >Español</s:a>
    <div class="informacion">
        <s:fielderror/>
        <span><s:property value="mensaje" /></span><br><br>
        <c:if test="${not empty requestScope.errores}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error}</li>
                    </c:forEach>
            </ul>
        </c:if>
    </div>
    <s:form action="buscarProgramas" method="post">
        <fieldset>
            <legend><s:text name="datos_de_busqueda"/></legend>
            <div>
                <label for="titulo">
                    <s:text name="titulo" />
                </label>
                <input type="search" name="titulo" id="titulo" value="<s:property value="titulo"/>" maxlength="50" />
            </div>
            <div>
                <label for="descripcion">
                    <s:text name="descripcion" />
                </label>
                <input type="search" name="descripcion" id="descripcion" value="<s:property value="descripcion"/>" maxlength="50" />
            </div>
            <div>
                <label for="tipoBusqueda">
                    <s:text name="tipo_busqueda"/>
                </label>
                <select name="tipoBusqueda">
                    <option value="0" <c:if test="${tipoBusqueda == 0}">selected</c:if> ><s:text name="completa"/></option>
                    <option value="1" <c:if test="${tipoBusqueda == 1}">selected</c:if> ><s:text name="parcial"/></option>
                    </select>
                </div>            
            </fieldset>
            <button><span><s:text name="buscar"/></span></button>
    </s:form>
    <div>
        <nav>
            <ul>
                <li>
                    <s:a action="irRegistroPrograma">
                        <s:text name="registrar_nuevo_programa"/>
                    </s:a>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <ul id="resultadoConsulta">
            <li class="cabeceraConsulta">
                <span><s:text name="codigo"/></span>
                <span><s:text name="titulo"/></span>
                <span><s:text name="descripcion"/></span>
                <span><s:text name="editar"/></span>
                <span><s:text name="eliminar"/></span>
            </li>

            <s:iterator var="programa" value="programas" >
                <li>
                    <span><s:property value="codigo"></s:property></span>
                    <span><s:property value="titulo"></s:property></span>
                    <span><s:property value="descripcion"></s:property></span>

                    <s:url action="irActualizaPrograma" var="urlEditar" >
                        <s:param name="codigo"><s:property value="codigo"></s:property></s:param>
                    </s:url>
                    <span><s:a href="%{urlEditar}" ><s:text name="editar"/></s:a></span>

                    <s:url action="irEliminarPrograma" var="urlEliminar" >
                        <s:param name="codigo"><s:property value="codigo"></s:property></s:param>
                    </s:url>
                    <s:text name="confirmar_eliminar" var="confirmar_msg" />
                    <span>
                        <s:a href="%{urlEliminar}" onclick="if(!confirm('%{confirmar_msg}')){return false;}" style="cursor: pointer" >
                            <s:text name="eliminar"/>
                        </s:a>
                    </span>
                    </li>
            </s:iterator>        
        </ul>
    </div>
</gch:base>
