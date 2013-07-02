<%@taglib prefix="s" uri="/struts-tags"%>
    <aside>
        <!-- Bloque de comentarios de ayuda para el usuario -->
        <p>
            <s:text name="help.parrafo1" />
        </p>
        <p>
            <s:text name="help.parrafo2" />
            <a href="mailto:<s:text name="help.email" />?subject=Feedback%20GCH">
                <s:text name="help.email" />
            </a>.
        </p>
    </aside>