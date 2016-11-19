Jenkins 2
=========

This role can be used to install [Jenkins 2](https://jenkins.io/2.0/)

[![Build Status](https://travis-ci.org/ohtomi/ansible-role-jenkins2.svg?branch=master)](https://travis-ci.org/ohtomi/ansible-role-jenkins2)

Requirements
------------

- Ansible 2.x
- JVM

Role Variables
--------------

```
## Type: list of string
#
# Plugins that you would like to be installed.
#
jenkins2_plugins: []

## Type: string
#
# Yum package name of Jenkins.
#
jenkins2_version: jenkins

## Type: yesno
#
# Whether to disable gpg-check at installing Jenkins.
#
jenkins2_disable_gpg_check: no

## Type: yesno
#
# Whether to enable certificate-validation at importing RPM key.
#
jenkins2_rpm_key_validate_certs: yes

## Type: string
#
# URL of the HTTP proxy to be used at importing RPM key.
# Set to '' (empty string) to disable HTTP proxy
#
jenkins2_rpm_key_proxy_url: ''

## Type: string
#
# Java executable to run Jenkins
# When left empty, we'll try to find the suitable Java.
#
jenkins2_java_cmd: ''

## Type: string
#
# Options to pass to java when running Jenkins.
#
jenkins2_java_options: "-Djava.awt.headless=true -Djenkins.install.runSetupWizard=false"

## Type: integer(0:65535)
#
# Port Jenkins is listening on.
# Set to -1 to disable
#
jenkins2_http_port: 8080

## Type: string
#
# IP address Jenkins listens on for HTTP requests.
# Default is all interfaces (0.0.0.0).
#
jenkins2_listen_address: ''

## Type: integer(1:9)
#
# Debug level for logs -- the higher the value, the more verbose.
# 5 is INFO.
#
jenkins2_debug_level: 5

## Type: yesno
#
# Whether to enable access logging or not.
#
jenkins2_enable_access_log: no

## Type: integer
#
# Maximum number of HTTP worker threads.
#
jenkins2_handler_max: 100

## Type; integer
#
# Maximum number of idle HTTP worker threads.
#
jenkins2_handler_idle: 20

## Type: string
#
# Pass arbitrary arguments to Jenkins.
# Full option list: java -jar jenkins.war --help
#
jenkins2_args: ''

## Type: string
#
# HTTP context path Jenkins is hosted at.
#
jenkins2_context_path: ''

## Type: string
#
# User name to access Jenkins CLI.
#
jenkins2_cli_username: admin

## Type: string
#
# Password to access Jenkins CLI.
#
jenkins2_cli_password: admin

## Type: string
#
# Host name or address of the proxy server.
# Set to '' (empty string) to disable proxy
#
jenkins2_proxy_host: ''

## Type: integer(0:65535)
#
# The port of the proxy server listens on.
#
jenkins2_proxy_port: 0

## Type: string
#
# If the proxy server requires authentication,
# set the name of the user.
#
jenkins2_proxy_username: ''

## Type: string
#
# If the proxy server requires authentication,
# set the password of the user.
#
jenkins2_proxy_password: ''

## Type: string
#
# If certain hosts must be contacted directly,
# you can specify their names.
# You can even use * as a wildcard.
# Example: *jenkins-test*.example.com
# Example: *jenkins-test*.example.com\\n*jenkins-production*.example.com
#
jenkins2_proxy_no_proxy_hosts: ''
```

Dependencies
------------

This role has no dependencies.

Example Playbook
----------------

This role can be installed, as follows:

`$ ansible-galaxy install ohtomi.jenkins2`

This role can be applied, as follows:

```yaml
- hosts: servers
  become: yes
  vars:
    jenkins2_plugins:
      - github-oauth
  roles:
     - ohtomi.jenkins2
```

License
-------

MIT

Author Information
------------------

This role is heavily inspired by [Karl M. Davis](https://github.com/karlmdavis/ansible-jenkins2).
