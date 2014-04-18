<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="body">
            <span>zsczczc</span>
            <span>${loginModel.login}</span>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
