<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Modificar Información de Curso">
    <div class="informacion">
        <span>${mensaje}</span>
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
           <!-- <ul>
                <c:forEach var="error" items="">
                    <li></li>
                </c:forEach>
            </ul>-->
                <ul>
                   <li>${errores}</li>
                </ul>
        </div> 
    </div>
    <form action="actualizarCurso" method="post">
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" value="${curso.codigo}"  readonly  >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos del Curso</legend>
            <div>
                <label for="titulo">nombre</label>
                <input type="text" id="nombre" name="nombre" value="${curso.nombre}" maxlength="50"  autofocus="" />
            </div>
            <div>
                <label for="descripcion">Descripci&oacute;n</label>
                <input type="text" id="descripcion" name="descripcion" value="${curso.descripcion}" maxlength="50" />
            </div>
            <div>
                <label for="objetivos">Objetivos</label>
                <input type="text" id="objetivos" name="objetivos" value="${curso.objetivos}" maxlength="50" />
            </div>
            <div>
                <label for="requisitos">Requisitos</label>
                <input type="text" id="requisitos" name="requisitos" value="${curso.requisitos}"  maxlength="400" />
            </div>
            <div>
                <label for="duracion">Duraci&oacute;n </label>
                <input type="text" id="duracion" name="duracion" value="${curso.duracion}" maxlength="400" />
            </div>
            <div>
                <label for="precio">estado</label>
                <input type="date" id="estado" name="estado" value="${curso.estado}" maxlength="400" />
            </div>
        </fieldset>
        <button>Actualizar</button>
    </form>
</gch:base>
