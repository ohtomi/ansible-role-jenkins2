def host = "{{ jenkins2_proxy_host }}"
def port = {{ jenkins2_proxy_port }}
def username = "{{ jenkins2_proxy_username }}"
def password = "{{ jenkins2_proxy_password }}"
def noProxyHosts = "{{ jenkins2_proxy_no_proxy_hosts }}"

def proxy = new hudson.ProxyConfiguration(host, port, username, password, noProxyHosts)
proxy.save()

jenkins.model.Jenkins.instance.proxy = proxy
