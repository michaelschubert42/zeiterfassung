<#import "page.ftl" as web/>
<@web.page>
    <button id="kommen"
            onclick="document.getElementById('zeit').appendChild(document.createTextNode('${uhrzeit}'));
                     this.firstChild.data='Gehen'">
        Kommen
    </button>
    <div id="zeit">
    </div>
</@web.page>