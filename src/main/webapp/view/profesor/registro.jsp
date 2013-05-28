<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="gch" uri="/WEB-INF/tlds/gch" %>
<gch:base titulo="Registro de Profesor">
    <div class="informacion">
        <span>${mensaje}</span>
    </div>
    <form action="registrarProfesor" method="post">
        <div class="informacion" style="display: ${empty requestScope.errores ? 'none' : 'block'}">
            <ul>
                <c:forEach var="error" items="${requestScope.errores}">
                    <li>${error.value}</li>
                </c:forEach>
            </ul>
        </div>
        <fieldset>
            <legend>Sistema</legend>
            <div>
                <label for="codigo">
                    C&oacute;digo
                </label>
                <input type="text" id="codigo" name="codigo" maxlength="8" required autofocus >
            </div>
        </fieldset>
        <fieldset>
            <legend>Datos Personales</legend>
            <div>
                <label for="nombres">Nombres</label>
                <input type="text" id="nombres" name="nombres" required maxlength="50" />
            </div>
            <div>
                <label for="apellidoPaterno">Apellido Paterno</label>
                <input type="text" id="apellidoPaterno" name="apellidoPaterno" required maxlength="50" />
            </div>
            <div>
                <label for="apellidoMaterno">Apellido Materno</label>
                <input type="text" id="apellidoMaterno" name="apellidoMaterno" maxlength="50" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Direcci&oacute;n</legend>
            <div>
                <label for="direccion">Direcci&oacute;n Completa</label>
                <input type="text" id="direccion" name="direccion" required maxlength="400" />
            </div>
            <div>
                <label for="referencia">Referencia</label>
                <input type="text" id="referencia" name="referencia" maxlength="400" />
            </div>
        </fieldset>
        <fieldset>
            <legend>Detalle</legend>
            <div>
                <label for="fechaNacimiento">
                    Fecha de Nacimiento
                </label>
                <input type="date" name="fechaNacimiento" id="fechaNacimiento" required />
            </div>
            <div class="multiopciones">
                <span>Sexo</span>
                <input type="radio" name="sexo" id="masculino" value="m" />
                <label for="masculino">Masculino</label>
                <input type="radio" name="sexo" id="femenino" value="f" />
                <label for="femenino">Femenino</label>
            </div>
            <div>
                <label for="estado">
                    Estado del Profesor
                </label>
                <select name="estado" id="estado">
                    <option value="">-- Seleccione --</option>
                    <option value="1">Activo</option>
                    <option value="2">Inactivo</option>
                    <option value="3">NoDeterminado</option>
                    <option value="4">Vacaciones</option>
                </select>
            </div>
        </fieldset>
        <button>Registrar</button>
    </form>
</gch:base>