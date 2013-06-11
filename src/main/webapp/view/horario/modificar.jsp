<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Modificar horario">
    <div class="informacion">
        <span>${mensaje}</span>
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <c:if test="${not empty requestScope.errores}">
                <ul>
                    <c:forEach var="error" items="${requestScope.errores}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>
    <form action="modificarHorario" method="post">
        <fieldset>
            <legend>Datos</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="3" readonly value="<c:out value="${horario.codigo}" />" />
            </div>
            <div>
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text" id="descripcion" name="descripcion" required autofocus maxlength="20" value="<c:out value="${horario.descripcion}" />" />
            </div>
            <div>
                <label for="inicio">Momento de inicio</label>
                <input type="text" id="inicio" name="inicio" required maxlength="2" value="<c:out value="${horario.momentoInicio}" />" />
            </div>
            <div>
                <label for="fin">Momento de fin</label>
                <input type="text" id="fin" name="fin" required maxlength="2" value="<c:out value="${horario.momentoFin}" />" />
            </div>
            <div>
                <label for="estado">Estado</label>
                <select name="estado" id="estado">
                    <c:choose>
                        <c:when test="${horario.estado=='Valido'}">
                            <option value="1" selected>Válido</option>
                            <option value="2">Obsoleto</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">Válido</option>
                            <option value="2" selected>Obsoleto</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>            
        </fieldset>
        <button>Guardar</button>
    </form>
</gch:base>