<!--footer statico-->
    
    <div class="lulb-footer-wrapper">
      <div class="container">  
        <div class="row-fluid">
            <div class="span12">
              <div class="span8">
               
       
                <#if current_lang == "es_ES">               
	                <a href="/es/baldintzak">                
	                	<@liferay.language key="condiciones"/>
	                </a>
                </#if>
                <#if current_lang == "eu_ES">              
	                <a href="/eu/baldintzak">                
	                	<@liferay.language key="condiciones"/>
	                </a>
                </#if>
                
                <#if current_lang == "es_ES">               
	                <a href="/es/mapa">                
	                	<@liferay.language key="mapa"/>
	                </a>
                </#if>
                <#if current_lang == "eu_ES">              
	                <a href="/eu/mapa">                
	                	<@liferay.language key="mapa"/>
	                </a>
                </#if>
                      
              
                <#if current_lang == "es_ES">               
	                <a href="/es/faq">                
	                	<@liferay.language key="faq"/>
	                </a>
                </#if>
                <#if current_lang == "eu_ES">              
	                <a href="/eu/faq">                
	                	<@liferay.language key="faq"/>
	                </a>
                </#if>
                
                <#if current_lang == "es_ES">               
	                <a href="/es/harremana">                
	                	<@liferay.language key="contacto"/>
	                </a>
                </#if>
                <#if current_lang == "eu_ES">              
	                <a href="/eu/harremana">                
	                	<@liferay.language key="contacto"/>
	                </a>
                </#if>
                

                <#if !is_signed_in>  
                  <a href="${sign_in_url}" data-redirect="${is_login_redirect_required?string}" id="sign-in" rel="nofollow" >${sign_in_text}</a>
                </#if>
                
                
              </div>
              <div class="span4">
                <p class="muted pull-right"><@liferay.language key="lurralde_c"/></p>
              </div>
            </div>
        </div>
      </div><!-- /.container -->
    </div><!-- /.lulb-footer-wrapper -->
    
