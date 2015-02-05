<#assign current_lang = themeDisplay.getLanguageId() >
  <div class="container" id="content">    
		<div class="row-fluid lulb-header">
		<div class="span6">
		  <a title="<@liferay.language key="titulo"/>" href="http://www.lurraldebus.net">
		    <img title="Lurraldebus" src="${images_folder}/lurraldebus.logo.png">
		  </a>
		</div>      
		<div class="span6">
		  <div class="tophead">
		    <ul class="inline languages">
				<#if current_lang == "eu_ES"> 
			      <li class="active"><a href="/eu"><@liferay.language key="eu"/></a><span class="divider">/</span></li> 
			      <li><a href="/es"><@liferay.language key="es"/></a><span class="divider"></span></li>
				</#if>
				<#if current_lang == "es_ES"> 
			      <li><a href="/eu"><@liferay.language key="eu"/></a><span class="divider">/</span></li> 
			      <li class="active"><a href="/es"><@liferay.language key="es"/></a><span class="divider"></span></li>
				</#if>            	              
		    </ul>
		    <ul class="inline social">
		      <li><@liferay.language key="siguenos_t_f"/>:</li>
		      <li class="twitter"><a href="https://twitter.com/Lurraldebus" target="_blank">T</a></li>
		      <li class="facebook"><a href="https://es-es.facebook.com/lurraldebus" target="_blank">F</a></li>
		    </ul>
		  </div>
		</div>
		</div>
	</div>
	
	
	<div class="lulb-menu-wrapper">
    <div class="container">      
    <div class="row-fluid lulb-menu">
      <div class="span12">
        
        

	 <nav class="navbar">
     <div class="navbar-inner">
         <div class="container">
             
             	  <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">                  
	                <span class="btn-navbar-text"><@liferay.language key="menu"/></span>             
	                <span class="btn-navbar-bars">
	                  <span class="icon-bar"></span>
	                  <span class="icon-bar"></span>
	                  <span class="icon-bar"></span>
	                </span>
	              </button>
             
        </div>
         <div class="collapse nav-collapse">
             <ul class="nav">
							<#list nav_items as nav_item>					
							<#assign nav_item_attr_has_popup = "" />
							<#assign nav_item_attr_selected = "" />
							<#assign nav_item_css_class = "" />					
							<#if nav_item.isSelected()>
								<#assign nav_item_attr_has_popup = "aria-haspopup='true'" />
								<#assign nav_item_attr_selected = "aria-selected='true'" />
								<#assign nav_item_css_class = "selected" />
							</#if>
								<li><a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span>${nav_item.icon()} ${nav_item.getName()}</span></a></a></li>
							</#list>
							
							<#if show_site_name>
							<span class="site-name" title="<@liferay.language_format objects="${site_name}" key="go-to-x" />">
								${site_name}
							</span>
							</#if>
		            </ul>
		       </div>
		    </div>
		</nav>
					
					
			

        </div>
      </div>
      
      
    </div><!-- /.container -->
  </div>