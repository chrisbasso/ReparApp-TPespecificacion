

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'prueba1.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'prueba1.security.UserRole'
grails.plugin.springsecurity.authority.className = 'prueba1.security.Role'

grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/login/**',       access: ['permitAll']],
	[pattern: '/logout/**',      access: ['permitAll']],
	[pattern: '/dbconsole/**',   access: ['permitAll']],
	[pattern: '/console/**',     access: ['permitAll']],
	[pattern: '/',               access: ['ROLE_ADMIN']],
	[pattern: '/',               access: ['ROLE_USER']],
	[pattern: '/repuesto/**',    access: ['ROLE_ADMIN']],
	[pattern: '/categoria/**',   access: ['ROLE_ADMIN']],
    [pattern: '/tipoarreglo/**', access: ['ROLE_ADMIN']],
	[pattern: '/arreglo/**',     access: ['ROLE_ADMIN']],
	[pattern: '/subcategoria/**',access: ['ROLE_ADMIN']],
	[pattern: '/solicitud/**',   access: ['ROLE_ADMIN']],
	[pattern: '/solicitud/**',   access: ['ROLE_USER']],
	[pattern: '/menu',  		 access: ['permitAll']],
	[pattern: '/menu.gsp',       access: ['permitAll']]


]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]


grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.logout.afterLogoutUrl = '/login/auth'
