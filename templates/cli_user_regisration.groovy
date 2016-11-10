def securityRealmName = jenkins.model.Jenkins.instance.securityRealm.getClass().getName()
if (securityRealmName == "hudson.security.SecurityRealm\$None") {
    return
}

def userId = "{{ jenkins2_cli_username }}"
def password = "{{ jenkins2_cli_password }}"

try {
    jenkins.model.Jenkins.instance.securityRealm.loadUserByUsername(userId)
} catch (e) {
    jenkins.model.Jenkins.instance.securityRealm.createAccount(userId, password)
}
