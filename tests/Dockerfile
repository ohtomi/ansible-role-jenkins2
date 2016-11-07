FROM centos:7
# Install Ansible
RUN yum -y install epel-release
RUN yum -y install git
RUN yum -y install ansible
RUN yum -y install sudo
RUN yum -y install initscripts
# Install JDK
RUN yum -y install java-1.8.0-openjdk
# Clean up
RUN yum clean all
# Disable requiretty
RUN sed -i -e 's/^\(Defaults\s*requiretty\)/#--- \1/' /etc/sudoers
# Install Ansible role files
COPY . /etc/ansible/
VOLUME [ "/sys/fs/cgroup" ]
CMD ["/usr/sbin/init"]
