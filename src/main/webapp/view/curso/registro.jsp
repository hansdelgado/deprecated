<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Curso">
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
    <form action="registrarCurso" method="post">
        <fieldset>

            <div>
                <label for="codigo">
                    C&oacute;digo:
                </label>
                <input type="text" id="codigo" name="codigo" value="${codigo}"  autofocus >
            </div>

            <div>
                <label for="nombre">Nombres</label>
                <input type="text" id="nombre" name="nombre"  value="${nombre}" />
            </div>
            <div>
                <label for="descripcion">Descripcion:</label>
                <input type="text" id="descripcion" name="descripcion"  value="${descripcion}" />
            </div>
            <div>
                <label for="objetivos">Objetivos:</label>
                <input type="text" id="objetivos" name="objetivos" value="${objetivos}" />
            </div>
        
    
            <div>
                <label for="requisito">Requisitos</label>
                <input type="text" id="requisitos" name="requisitos"  value="${requisitos}" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <input type="text" id="referencia" name="referencia" value="${referencia}" />
            </div>
        
            
            <div>
                <label for="duracion">
                    Duracion:
                </label>
                <input type="2" name="duracion" id="duracion" value="${duracion}" />
            </div>
            <div>
                <label for="estado">
                    Estado:
                </label>
                <input type="text" name="estado" id="estado" value="${estado}" />
            </div>

        </fieldset>
        <button>Registrar</button>
    </form>
</gch:base>
