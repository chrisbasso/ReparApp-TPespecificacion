package prueba1

import prueba1.security.Role
import prueba1.security.User
import prueba1.security.UserRole

class BootStrap {

    def init = { servletContext ->
        environments {
            development {
//                bootStrapEntities()
            }
        }
    }
    def destroy = {
    }

    private void bootStrapEntities() throws Exception {

        createRoles()
        createUsers()

    }

    private static void createRoles() throws Exception {
        createRol('ROLE_USER')
    }

    private static void createRol(String authority) {
        def role = new Role(authority: authority)
        role.save(failOnError: true)
    }

    private void createUsers() throws Exception {
        createUser('carlitos', 'carlitos', 'ROLE_USER')
    }

    private void createUser(String username, String password,String role)
            throws Exception {

        def user = new User(username: username, password: password)
        user.save(failOnError: true)
        def elRol = Role.findByAuthority(role)

        if (!elRol) {
            elRol = createRol(role)
        }

        new UserRole(user: user, role: elRol).save(failOnError: true)
    }
}
